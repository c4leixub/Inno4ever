package com.zeetcode.alinkedin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Find three values that can be the lengths of the sides of a triangle. Three
 * segments of lengths A, B, C can form a triangle if and only if: A + B > C, B
 * + C > A, A + C > B. e.g. 6, 4, 5 can form a triangle, 10, 2, 7 can't.
 */
public class FindTriangle {
	public List<List<Integer>> findTriangleBruteForce(int[] segmentLengths) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		for (int i = 0; i < segmentLengths.length; i++) {
			for (int j = i + 1; j < segmentLengths.length; j++) {
				for (int k = j + 1; k < segmentLengths.length; k++) {
					if (isTriangle(segmentLengths[i], segmentLengths[j],
							segmentLengths[k])) {

						List<Integer> triangle = new ArrayList<Integer>();
						triangle.add(segmentLengths[i]);
						triangle.add(segmentLengths[j]);
						triangle.add(segmentLengths[k]);
						result.add(triangle);
					}
				}
			}
		}

		return result;
	}
	private boolean isTriangle(int a, int b, int c) {
		return (a + b) > c && (b + c) > a && (a + c) > b;
	}

	public List<List<Integer>> findTriangleSorted(int[] segments) {
		int counter = 0;	// # of triangle counter
		Arrays.sort(segments);
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		for (int i = 0; i <= segments.length - 3; i++) {
			int k = i + 2;
			for (int j = i + 1; j <= segments.length - 2; j++) {
				while (k <= segments.length - 1
						&& segments[i] + segments[j] > segments[k]) {
					List<Integer> triangle = new ArrayList<Integer>();
					triangle.add(segments[i]);
					triangle.add(segments[j]);
					triangle.add(segments[k]);
					result.add(triangle);
					k++;
				}
				
				counter += (k-j-1);
			}
		}
		
		System.out.println(counter);
		return result;
	}

	public static void main(String[] args) {
		FindTriangle f = new FindTriangle();
		System.out.println(f
				.findTriangleBruteForce(new int[] { 10, 5, 7, 4, 3 }));
		System.out.println(f.findTriangleSorted(new int[] { 10, 5, 7, 4, 3 }));
	}
}
