package com.zeetcode.priorityqueue;

import java.io.InputStream;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MovingAverage {
	
	private LinkedList<Integer> queue = new LinkedList<Integer>();
	private int size;
	
	public MovingAverage(int size) {
		this.size = size;
	}
	
	public double next(int value) {
		queue.add(value);
		if (queue.size() > size) {
			queue.poll();
		}
		
		int sum = 0;
		for (int i = 0; i < queue.size(); i++) {
			sum += queue.get(i);
		}
		
		return sum / (double) this.size;
	}
	
	public void movingAverage(InputStream input, int windowSize) {
		LinkedList<Integer> queue = new LinkedList<Integer>();
		Scanner scanner = new Scanner(input);
		while (scanner.hasNextLine()) {
			queue.add(Integer.parseInt(scanner.nextLine()));
			if (queue.size() > windowSize) {
				queue.poll();
			}
			
			int sum = 0;
			for (int i = 0; i < queue.size(); i++) {
				sum += queue.get(i);
			}
			
			System.out.println(sum / (double) windowSize);
		}
		scanner.close();
	}
}
