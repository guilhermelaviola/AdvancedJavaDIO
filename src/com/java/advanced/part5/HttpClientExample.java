package com.java.advanced.part5;

import java.io.IOException;
import java.net.ProxySelector;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;

public class HttpClientExample {
	
	static ExecutorService executor = Executors.newFixedThreadPool(6, new ThreadFactory() {
		
		@Override
		public Thread newThread(Runnable runnable) {
			Thread thread = new Thread(runnable);
			System.out.println("New Thread created: " + (thread.isDaemon() ? "daemon" : "") 
					+ "Thread Group: " + thread.getThreadGroup());
			return thread;
		}
	});
	
	public static void main(String[] args) throws Exception {
		// Testing
		connectAkamaiHttp1Client();
	}
	
	private static void connectAkamaiHttp1Client() throws Exception {
		System.out.println("Running HTTP/1.1 example...");
		try {
			HttpClient httpClient = HttpClient.newBuilder()
					.version(HttpClient.Version.HTTP_1_1)
					.proxy(ProxySelector.getDefault())
					.build();
			
			long start = System.currentTimeMillis();
			
			HttpRequest mainRequest = HttpRequest.newBuilder()
					.uri(URI.create("https://http2.akamai.com/demo/h2_demo_frame.html"))
					.build();
			
			HttpResponse<String> response = httpClient.send(mainRequest, HttpResponse.BodyHandlers.ofString());
			
			System.out.println("Status Code: " + response.statusCode());
			System.out.println("Response Headers: " + response.headers());;
			String responseBody = response.body();
			System.out.println(responseBody);
			
			List<Future<?>> future = new ArrayList<>();
			
			responseBody
			.lines()
			.filter(line -> line.trim().startsWith("<img height"))
			.map(line -> line.substring(line.indexOf("src='") + 5, line.indexOf("'/>")))
			.forEach(image -> {
				Future<?> imgFuture = executor.submit(() -> {
					HttpRequest imgRequest = HttpRequest.newBuilder()
							.uri(URI.create("https://http2.akamai.com" + image))
							.build();
					try {
						
						HttpResponse<String> imageResponse = httpClient.send(imgRequest, HttpResponse.BodyHandlers.ofString());
						System.out.println("Image Loaded: " + image + "ststus code: " + imageResponse.statusCode());
					} catch (IOException | InterruptedException e){
						System.out.println("Error message during the request to recover the image: " + image);
					}
				});
				future.add(imgFuture);
				System.out.println("Future for image submitted..." + image);
			});
			
			future.forEach(f -> {
				try {
					f.get();
				} catch (InterruptedException | ExecutionException e) {
					System.out.println("Error while waiting the future image load!");
				}
			});
			
			long end = System.currentTimeMillis();
			System.out.println("Total waiting time: " + (end - start) + "ms.");
		} finally {
			executor.shutdown();
		}
	}
	
	private static void connectAkamaiHttp2Client() throws Exception {

	}
}
