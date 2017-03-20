package com.zeetcode.array.finding;

public class RandomMax {
	public int randomMax(int[] A) {
		if (A == null || A.length == 0) {
			return -1;
		}
		int max = A[0];
		int index = 1;
		for (int i = 1; i < A.length; i++) {
			if (A[i] == max) {
				int temp = A[index];
				A[index] = i;
				A[i] = temp;
				index++;
			} else if (A[i] > max) {
				max = A[i];
				index = 0;
				int temp = A[index];
				A[index] = i;
				A[i] = temp;
				index++;

			}
		}

		int random = (int) (Math.random() * index);
		return A[random];
	}
	
	public static void main(String[] args) {
		int[] A = new int[] {1,5,2,6,0};
		RandomMax r = new RandomMax();
		System.out.println(r.randomMax(A));
	}
}
