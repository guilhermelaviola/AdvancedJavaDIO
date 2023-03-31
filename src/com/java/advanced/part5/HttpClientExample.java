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
/*
 Web scraper example
 What does a web scraper do? Web scraping is the process of using bots to extract content
 and data from a website. Unlike screen scraping, which only copies pixels displayed onscreen,
 web scraping extracts underlying HTML code and, with it, data stored in a database.
 The scraper can then replicate entire website content elsewhere.
 */
public class HttpClientExample {

	static ExecutorService executor = Executors.newFixedThreadPool(6, new ThreadFactory() {

		@Override
		public Thread newThread(Runnable runnable) {
			Thread thread = new Thread(runnable);
			System.out.println("New Thread created: " + (thread.isDaemon() ? "daemon" : "") + "Thread Group: "
					+ thread.getThreadGroup());
			return thread;
		}
	});

	public static void main(String[] args) throws Exception {
		/* Testing
		You can't execute both methods at once, otherwise you'll get the following error:
		
		Exception in thread "main" java.util.concurrent.RejectedExecutionException:
		Task java.util.concurrent.FutureTask@32eebfca[Not completed,
		task = java.util.concurrent.Executors$RunnableAdapter@23fe1d71[Wrapped task =
		com.java.advanced.part5.HttpClientExample$$Lambda$243/0x0000000800d626b0@28ac3dc3]]
		rejected from java.util.concurrent.ThreadPoolExecutor@4e718207[Terminated, pool size = 0,
		active threads = 0, queued tasks = 0, completed tasks = 361] 
		*/
		connectAkamaiHttp1Client();
		//connectAkamaiHttp2Client();
		connectAndPrintURLJavaOracle();
	}

	private static void connectAkamaiHttp1Client() throws Exception {
		System.out.println("Running HTTP/1.1 example...");
		try {
			HttpClient httpClient = HttpClient.newBuilder().version(HttpClient.Version.HTTP_1_1)
					.proxy(ProxySelector.getDefault()).build();

			long start = System.currentTimeMillis();

			HttpRequest mainRequest = HttpRequest.newBuilder()
					.uri(URI.create("https://http2.akamai.com/demo/h2_demo_frame.html")).build();

			HttpResponse<String> response = httpClient.send(mainRequest, HttpResponse.BodyHandlers.ofString());

			System.out.println("Status Code: " + response.statusCode());
			System.out.println("Response Headers: " + response.headers());
			;
			String responseBody = response.body();
			System.out.println(responseBody);

			List<Future<?>> future = new ArrayList<>();

			responseBody.lines().filter(line -> line.trim().startsWith("<img height"))
					.map(line -> line.substring(line.indexOf("src='") + 5, line.indexOf("'/>"))).forEach(image -> {
						Future<?> imgFuture = executor.submit(() -> {
							HttpRequest imgRequest = HttpRequest.newBuilder()
									.uri(URI.create("https://http2.akamai.com" + image)).build();
							try {

								HttpResponse<String> imageResponse = httpClient.send(imgRequest,
										HttpResponse.BodyHandlers.ofString());
								System.out.println(
										"Image Loaded: " + image + "ststus code: " + imageResponse.statusCode());
							} catch (IOException | InterruptedException e) {
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
		System.out.println("Running HTTP/2 example...");
		try {
			HttpClient httpClient = HttpClient.newBuilder()
					.version(HttpClient.Version.HTTP_2)
					.proxy(ProxySelector.getDefault())
					.build();
			
			long start = System.currentTimeMillis();
			
			HttpRequest mainRequest = HttpRequest.newBuilder()
					.uri(URI.create("https://http2.akamai.com/demo/h2_demo_frame.html"))
					.build();
			
			HttpResponse<String> response = httpClient.send(mainRequest, HttpResponse.BodyHandlers.ofString());
			
			System.out.println("Status Code: " + response.statusCode());
			System.out.println("Response Headers: " + response.headers());
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
								System.out.println("Loaded Image: " + image + " Status Code: " + imageResponse.statusCode());
							} catch(IOException | InterruptedException e) {
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
	
	private static void connectAndPrintURLJavaOracle() throws IOException, InterruptedException {
		HttpRequest request = HttpRequest.newBuilder()
				.GET().uri(URI.create("https://docs.oracle.com/javase/10/language/"))
				.build();
		
		HttpClient httpClient = HttpClient.newHttpClient();
		
		HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
		
		System.out.println("Status Code: " + response.statusCode());
		System.out.println("Headers Respons: " + response.headers());
		System.out.println(response.body());;
	}
}
