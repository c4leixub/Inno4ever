package com.lkin.stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class ExclusiveTimeFunctions {
	public int[] exclusiveTime(int n, List<String> logs) {
		int[] res = new int[n];
		Stack<Integer> stack = new Stack();
		int pre = 0;
		for (String log : logs) {
			String[] arr = log.split(":");
			if (arr[1].equals("start")) {
				if (!stack.isEmpty()) {
					res[stack.peek()] += Integer.parseInt(arr[2]) - pre;
				}
				stack.push(Integer.parseInt(arr[0]));
				pre = Integer.parseInt(arr[2]);
			
			} else {
				res[stack.pop()] += Integer.parseInt(arr[2]) - pre + 1;
				pre = Integer.parseInt(arr[2]) + 1;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		List<String> logs = new ArrayList<String>();
		logs.add("0:start:0");
		logs.add("1:start:2");
		logs.add("1:end:5");
		logs.add("0:end:6");

		ExclusiveTimeFunctions e = new ExclusiveTimeFunctions();
		e.exclusiveTime(2, logs);
	}
}
