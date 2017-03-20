package com.zeetcode.array.finding;

public class FindPeakOrValley {
	public int findPeak(int[] A, int i, int j) {
		int m = (i+j)/ 2;
		if (m == 0 || m == A.length-1)	return -1; 
		
		if (A[m-1] <= A[m] && A[m] >= A[m+1]) {
			return A[m];
		} else if (A[m-1] > A[m]) {
			return findPeak(A, i, m-1);
		} else if (A[m] < A[m+1]) {
			return findPeak(A, m+1, j);
		}
		
		return -1;
	}
	
	public int findValley(int[] A, int i, int j) {
		int m = (i+j)/ 2;
		if (m == 0 || m == A.length-1)	return -1; 
		
		if (A[m-1] >= A[m] && A[m] <= A[m+1]) {
			return A[m];
		} else if (A[m-1] < A[m]) {
			return findValley(A, i, m-1);
		} else if (A[m] > A[m+1]) {
			return findValley(A, m+1, j);
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		FindPeakOrValley f = new FindPeakOrValley();
		int[] A = new int[] {1,2,6,5,3,7,4};
		System.out.println(f.findPeak(A, 0, A.length-1));
		A = new int[] {1,2,3,4,5,6,7};
		System.out.println(f.findPeak(A, 0, A.length-1));
		
		A = new int[] {2,1,3,5,6,7,4};
		System.out.println(f.findValley(A, 0, A.length-1));
		A = new int[] {1,2,3,4,5,6,7};
		System.out.println(f.findValley(A, 0, A.length-1));
	}
}
