package com.lkin.onlinetest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeSet;

/** 给一个int array，按照里面数字binary表达式里1的个数排序 */
public class SortByBinaryOne {

	private Map<Integer, Integer> map;

	private int countOne(int num) {
		int count = 0;
		while (num > 0) {
			if (num % 2 == 1) {
				count++;
			}
			num = num / 2;
		}
		return count;
	}
	
	public void sort(int[] nums) {
		map = new HashMap<Integer, Integer>();
		for (int num : nums) {
			map.putIfAbsent(num, countOne(num));
		}

		/*	built-in library 
		sortWithBuildIn(nums);
		*/

		this.mergeSort(nums, 0, nums.length - 1);
	}

	private void mergeSort(int[] num, int l, int r) {
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
		int n1 = m - l + 1;
		int n2 = r - m;

		int L[] = new int[n1];
		int R[] = new int[n2];

		for (int i = 0; i < n1; ++i)
			L[i] = num[l + i];
		for (int j = 0; j < n2; ++j)
			R[j] = num[m + 1 + j];

		int i = 0, j = 0;
		int k = l;

		while (i < n1 && j < n2) {
			if (L[i] == R[j] || map.get(L[i]) < map.get(R[j])
					|| (map.get(L[i]) == map.get(R[j]) && L[i] < R[j])) {
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
	
	private void sortWithBuildIn(int[] nums) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int num : nums) {
			list.add(num);
		}
		Collections.sort(list, new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2) {
				int count1 = map.get(o1);
				int count2 = map.get(o2);

				if (count1 == count2) {
					return o1 - o2;
				}

				return count1 - count2;
			}
		});

		for (int i = 0; i < list.size(); i++) {
			nums[i] = list.get(i);
		}
	}

	public static void main(String[] args) {
		SortByBinaryOne s = new SortByBinaryOne();
		int[] nums = new int[] { 7, 8, 5, 6, 5 };
		s.sort(nums);
		for (int num : nums) {
			System.out.print(num);
			System.out.print(' ');
		}
		System.out.println();
	}
}
