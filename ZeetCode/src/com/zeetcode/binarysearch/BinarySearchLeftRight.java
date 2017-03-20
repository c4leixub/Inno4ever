package com.zeetcode.binarysearch;

public class BinarySearchLeftRight {
	
	public int binarySearchLeft(int[] array) {
		int s = 0, e = array.length-1;
		while (s < e) {
			int m = s + (e - s) / 2;
			if (array[m] == 1) {
				e = m;
			} else {
				s = m + 1;
			}
		}
		
		return s;
	}
	
	public int binarySearchRight(int[] array) {
		int s = 0, e = array.length-1;
		while (s + 1 < e) {
			int m = s + (e - s) / 2;
			if (array[m] == 1) {
				s = m;
			} else {
				e = m - 1;
			}
		}
		
		if (array[e] == 1) return e;
		return s;
	}
	
	public int binarySearchRightFirstZero(int[] array) {
		int s = 0, e = array.length-1;
		while (s < e) {
			int m = s + (e - s) / 2;
			if (array[m] == 0) {
				e = m;
			} else {
				s = m + 1;
			}
		}
		
		return s;
	}
	
	public static void main(String[] args) {
		BinarySearchLeftRight b = new BinarySearchLeftRight();
		
		int[] array = new int[] {0, 0, 1, 1, 1, 1, 1, 0, 0};
		System.out.println(b.binarySearchLeft(array));
		System.out.println(b.binarySearchRight(array));
		System.out.println(b.binarySearchRightFirstZero(array));
		System.out.println();
		
		array = new int[] {1, 1, 1, 1, 1, 0, 0};
		System.out.println(b.binarySearchLeft(array));
		System.out.println(b.binarySearchRight(array));
		System.out.println(b.binarySearchRightFirstZero(array));
		System.out.println();
		
		array = new int[] {0, 1, 0};
		System.out.println(b.binarySearchLeft(array));
		System.out.println(b.binarySearchRight(array));
		System.out.println(b.binarySearchRightFirstZero(array));
		System.out.println();
		
		array = new int[] {0, 0, 1, 1, 1};
		System.out.println(b.binarySearchLeft(array));
		System.out.println(b.binarySearchRight(array));
		System.out.println(b.binarySearchRightFirstZero(array));
		System.out.println();
		
		array = new int[] {1};
		System.out.println(b.binarySearchLeft(array));
		System.out.println(b.binarySearchRight(array));
		System.out.println();
	}
	
}
