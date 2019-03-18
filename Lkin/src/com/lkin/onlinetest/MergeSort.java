package com.lkin.onlinetest;

public class MergeSort {
	public void mergeSort(int[] num, int l, int r) {
		if (l < r) {
			// Find the middle point
			int m = (l + r) / 2;

			// Sort first and second halves
			mergeSort(num, l, m);
			mergeSort(num, m + 1, r);

			// Merge the sorted halves
			merge(num, l, m, r);
		}
	}

	private void merge(int[] num, int l, int m, int r) {
		// create two arrays 
		int n1 = m - l + 1;
		int n2 = r - m;

		int L[] = new int[n1];
		int R[] = new int[n2];

		for (int i = 0; i < n1; ++i)
			L[i] = num[l + i];
		for (int j = 0; j < n2; ++j)
			R[j] = num[m + 1 + j];

		// merge two sorted array
		int i = 0, j = 0;
		int k = l;
		while (i < n1 && j < n2) {
			if (L[i] <= R[j]) {
				num[k] = L[i];
				i++;
			} else {
				num[k] = R[j];
				j++;
			}
			k++;
		}

		while (i < n1) {
			num[k] = L[i];
			i++;
			k++;
		}

		while (j < n2) {
			num[k] = R[j];
			j++;
			k++;
		}
	}
}
