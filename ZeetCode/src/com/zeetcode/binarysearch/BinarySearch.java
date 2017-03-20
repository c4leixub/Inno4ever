package com.zeetcode.binarysearch;

public class BinarySearch {
	/*
	 * Time complexity O(log n) Space complexity O(1)
	 */
	public static int search(int[] a, int x) {
		int low = 0;
		int high = a.length - 1;
		int mid;

		while (low <= high) {
			mid = (low + high) / 2;
			if (a[mid] < x) {
				low = mid + 1;
			} else if (a[mid] > x) {
				high = mid - 1;
			} else {
				return mid;
			}
		}

		return -1; // element not found
	}

	public static int searchRecursive(int[] a, int x) {
		return searchHelper(a, x, 0, a.length - 1);
	}

	private static int searchHelper(int[] a, int x, int low, int high) {

		if (low <= high) {
			int mid = (low + high) / 2;

			if (a[mid] < x) {
				searchHelper(a, x, mid + 1, high);
			} else if (a[mid] > x) {
				searchHelper(a, x, low, mid - 1);
			} else {
				return mid;
			}
		}

		return -1;

	}

}
