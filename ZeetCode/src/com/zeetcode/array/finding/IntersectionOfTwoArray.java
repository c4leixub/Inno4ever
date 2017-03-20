package com.zeetcode.array.finding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class IntersectionOfTwoArray {

	// Time = O(n). Space = O(n).
	public int[] intersection(int[] nums1, int[] nums2) {
		HashSet<Integer> set1 = new HashSet<Integer>();
		for (int i : nums1) {
			set1.add(i);
		}

		HashSet<Integer> set2 = new HashSet<Integer>();
		for (int i : nums2) {
			set2.add(i);
		}

		Iterator<Integer> iter = set1.iterator();
		while (iter.hasNext()) {
			int i = iter.next();
			if (!set2.contains(i)) {
				iter.remove();
			}
		}

		int[] result = new int[set1.size()];
		int i = 0;
		for (int x : set1) {
			result[i++] = x;
		}

		return result;
	}

	// Time = O(nlog(n)). Space = O(n).
	public int[] intersectionBinaryWithSearch(int[] nums1, int[] nums2) {
		Arrays.sort(nums1);
		Arrays.sort(nums2);

		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < nums1.length; i++) {
			if (i == 0 || (i > 0 && nums1[i] != nums1[i - 1])) {
				if (Arrays.binarySearch(nums2, nums1[i]) > -1) {
					list.add(nums1[i]);
				}
			}
		}

		
		int[] result = new int[list.size()];
		int k = 0;
		for (int i : list) {
			result[k++] = i;
		}

		return result;
	}

	// Time = O(n). Space = O(n).
	public int[] intersectDuplicate(int[] nums1, int[] nums2) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i : nums1) {
			if (map.containsKey(i)) {
				map.put(i, map.get(i) + 1);
			} else {
				map.put(i, 1);
			}
		}

		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i : nums2) {
			if (map.containsKey(i)) {
				if (map.get(i) > 1) {
					map.put(i, map.get(i) - 1);
				} else {
					map.remove(i);
				}
				list.add(i);
			}
		}

		int[] result = new int[list.size()];
		int i = 0;
		while (i < list.size()) {
			result[i] = list.get(i);
			i++;
		}

		return result;
	}

	// Time = O(nlog(n)). Space = O(n).
	public int[] intersectDuplicateSort(int[] nums1, int[] nums2) {
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		ArrayList<Integer> list = new ArrayList<Integer>();
		int p1 = 0, p2 = 0;
		while (p1 < nums1.length && p2 < nums2.length) {
			if (nums1[p1] < nums2[p2]) {
				p1++;
			} else if (nums1[p1] > nums2[p2]) {
				p2++;
			} else {
				list.add(nums1[p1]);
				p1++;
				p2++;

			}
		}

		int[] result = new int[list.size()];
		int i = 0;
		while (i < list.size()) {
			result[i] = list.get(i);
			i++;
		}
		return result;
	}
}
