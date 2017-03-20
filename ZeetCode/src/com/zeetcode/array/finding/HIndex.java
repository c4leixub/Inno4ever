package com.zeetcode.array.finding;

import java.util.Arrays;

/**
 * H-Index means the biggest number H s.t H element in the array >= H
 * 
 * For example, given citations = [3, 0, 6, 1, 5], which means the researcher has 5 papers 
 * in total and each of them had received 3, 0, 6, 1, 5 citations respectively. Since the 
 * researcher has 3 papers with at least 3 citations each and the remaining two with no 
 * more than 3 citations each, his h-index is 3.
 */
public class HIndex {

	public int hIndex(int[] citations) {
		int n = citations.length;
		if (n == 0)
			return 0;
		int min = 0, max = citations.length - 1;
		while (min <= max) {
			int mid = (min + max) / 2;
			if (citations[mid] < n - mid) {
				min = mid + 1;
			} else {
				max = mid - 1;
			}
		}

		return n - min;
	}
}
