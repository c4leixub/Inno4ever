package com.zeetcode.array.rotated;

public class RotateArrayByK {
	public void rotate(int[] arr, int k) {
		if (arr == null || arr.length <= 1)	return;
		
		k = k % arr.length;
		if (k == 0) {
			return;
		} else if (k < 0) {
			k = k + arr.length;
		}
		
		// the inner loop is push the last element of the array to front
		// and we do this K times
		for (int i = 0; i < k; i++) {
			for (int j = arr.length - 1; j > 0; j--) {
				int temp = arr[j];
				arr[j] = arr[j - 1];
				arr[j - 1] = temp;
			}
		} // O(k * n)
	}
	
	// O((n-k)/2 + k/2 + n/2) = O(n)
	public void rotateDivideAndReverse(int[] arr, int k) {		
		if (arr == null || arr.length <= 1)	return;
		
		k = k % arr.length;
		if (k == 0) {
			return;
		} else if (k < 0) {
			k = k + arr.length;
		}
		
		// suppose {1,2,3,4,5,6} and k = 2, split into 1,2,3,4 and 5,6
		
		// reverse the first part, 4,3,2,1,5,6
		reverse(arr, 0, arr.length-1-k);
		
		// reverse the second part, 4,3,2,1,6,5
		reverse(arr, arr.length-k, arr.length-1);
		
		// reverse all, 5,6,1,2,3,4
		reverse(arr, 0, arr.length-1);
	}
	public void reverse(int[] arr, int i, int j) {
		if (i < 0 || j >= arr.length)	return;
		
		while (i < j) {
			int t = arr[i];
			arr[i] = arr[j];
			arr[j] = t;
			i++;
			j--;
		}
	}
	
	public static void main(String[] args) {
		RotateArrayByK r = new RotateArrayByK();
		
		int[] arr = new int[] {1,2,3,4,5,6};
		r.rotate(arr, -1);
		
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		
		arr = new int[] {1,2,3,4,5,6};
		r.rotateDivideAndReverse(arr, -1);
		
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
}
