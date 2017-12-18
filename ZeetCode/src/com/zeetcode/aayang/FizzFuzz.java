package com.zeetcode.aayang;

import java.util.HashMap;
import java.util.Map;

/**
 * 输入是一个integer n
 * 
 * 输出 从 1 到 n, 如果数字能整除3 输出Fizz， 如果数字能整除5 输出Fuzz 如果数字能整除3和5 输出FizzFuzz
 * 
 * 例子 n = 6
 * 
 * 1 2 Fizz 4 Fuzz 6
 */
public class FizzFuzz {

	public void fizzFuzz(int n) {
		for (int a = 1; a <= n; a++) {
			// if(a%3==0){
			// System.out.println("Fizz");
			// }else if(a%5==0){
			// System.out.println("Fuzz");
			// }else if(a%3==0 && a%5==0){
			// System.out.println("FizzFuzz");
			// }else{
			// System.out.println(a);
			// }

			if (a % 3 == 0) {
				System.out.print("Fizz");
			}
			if (a % 5 == 0) {
				System.out.print("Fuzz");
			}
			if (a % 3 != 0 && a % 5 != 0) {
				System.out.print(a);
			}

			System.out.println();
		}
	}

	/**
	 * {1,....,n} 找没出现的数字
	 * 
	 * n = 4 {3,1,4,3}, 输出 2
	 */
	public int findMiss(int[] arr) {
		int n = arr.length;
		boolean[] flags = new boolean[n + 1]; // flags[i] 都是false的
		
		for (int a = 0; a <= n - 1; a++) {
			int k = arr[a];
			flags[k] = true;
		}
		
		for (int a = 1; a <= n - 1; a++) {
			if (flags[a] == false) {
				return a;
			}
		}

		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FizzFuzz f = new FizzFuzz();
		// f.fizzFuzz(15);

		int[] a = new int[] { 3, 1, 4, 3 };
		f.findMiss(a);
	}

}
