package com.zeetcode.alinkedin;

import java.util.Arrays;

public class PythagoreanTriplet {
	public boolean isTriplet(int ar[], int n) {

		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				for (int k = j + 1; k < n; k++) {

					// Calculate square of array elements
					int x = ar[i] * ar[i], y = ar[j] * ar[j], z = ar[k] * ar[k];

					if (x == y + z || y == x + z || z == x + y)
						return true;
				}
			}
		}

		return false;
	}

	public boolean isTripletSort(int arr[], int n) {
		// Square array elements
		for (int i = 0; i < n; i++)
			arr[i] = arr[i] * arr[i];

		Arrays.sort(arr);

		for (int i = n - 1; i >= 2; i--) {

			int l = 0; 
			int r = i - 1;
			while (l < r) {
				// A triplet found
				if (arr[l] + arr[r] == arr[i])	return true;

				// Else either move 'l' or 'r'
				if (arr[l] + arr[r] < arr[i]) {
					l++;
				} else {
					r--;
				}
			}
		}

		return false;
	}

	public static void main(String[] args) {
		int arr[] = { 3, 1, 4, 6, 5 };
		int arr_size = arr.length;

		PythagoreanTriplet pt = new PythagoreanTriplet();
		System.out.println(pt.isTriplet(arr, arr_size));
		System.out.println(pt.isTripletSort(arr, arr_size));
	}
}
