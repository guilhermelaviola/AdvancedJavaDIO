package com.java.advanced.part3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

public class FutureExample {
	private static final ExecutorService peopleToExecuteTheTasks = Executors.newFixedThreadPool(4);
	
	public static void main(String[] args) throws InterruptedException {
		Factory factory = new Factory(new QualityControl());
		List<Future<String>> futures = new CopyOnWriteArrayList<>(factory.getFactoryTasks().stream()
				.map(task -> peopleToExecuteTheTasks.submit(() -> {
					try {
						return task.doTask();
					} catch(InterruptedException e) {
						e.printStackTrace();
					}
					return null;
				})
			)
			.collect(Collectors.toList()));
		
		while(true) {
			int numberOfNonFinishedTasks = 0;
			for(Future<?> future : futures) {
				if (future.isDone()) {
					try {
						System.out.println("Congratulations, you finished " + future.get());
						futures.remove(future);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}catch (ExecutionException e) {
						e.printStackTrace();
					}
				}
				else {
					numberOfNonFinishedTasks++;
				}
			}
			if (futures.stream().allMatch(Future::isDone)) {
				break;
			}
			System.out.println("Number of non finished tasks: " + numberOfNonFinishedTasks);
			Thread.sleep(5000);
		}
		peopleToExecuteTheTasks.shutdown();
	}
}


class Factory {
	private List<Area> areas;
	
	Factory(Area... areas){
		this.areas = Arrays.asList(areas);
	}
	
	List<Task> getFactoryTasks() {
		return this.areas.stream().map(Area::getAreaTasks)
				.reduce(new ArrayList<Task>(), (pivot, tasks) -> {
					pivot.addAll(tasks);
					return pivot;
				});
	}
}

interface Task {
	String doTask() throws InterruptedException;
}

abstract class Area {
	abstract List<Task> getAreaTasks();
}

class QualityControl extends Area {
	@Override
	List<Task> getAreaTasks(){
		
		return Arrays.asList(
				this::checkPlasticParts,
				this::checkMetalParts
				);
	}
	
	private String checkPlasticParts() throws InterruptedException {
		Thread.sleep(5000);
		String checkingPlasticParts = "Checking plastic parts...";
		System.out.println(checkingPlasticParts);
		return checkingPlasticParts;
	}
	
	private String checkMetalParts() throws InterruptedException {
		Thread.sleep(8000);
		String checkingMetalParts = "Checking metal parts...";
		System.out.println(checkingMetalParts);
		return checkingMetalParts;
	}
}