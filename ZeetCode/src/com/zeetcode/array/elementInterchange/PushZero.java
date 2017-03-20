package com.zeetcode.array.elementInterchange;

public class PushZero {
	public static void pushZeroToEnd(int[] A) {
		int count = 0;	// The non-zero counter
		for (int i = 0; i < A.length; i++) {
			if (A[i] != 0) {
				A[count] = A[i];
				count++;
			}
		}
		// after the first loop the, all the non
		// zero int are in the front, now set the
		// zeros at the back
		while (count < A.length) {
            A[count] = 0;
            count++;
		}
	}
	
	public static void pushZeroToFront(int[] A) {
		int nonZeroIndex = A.length - 1;
		for (int i = A.length - 1; i > 0; i--) {
			if (A[i] != 0) {
				A[nonZeroIndex] = A[i];
				nonZeroIndex--;
			}
		}
		
		while (nonZeroIndex > 0) {
			A[nonZeroIndex] = 0;
			nonZeroIndex--;
		}
	}
	
	public static void main (String[] args) {
        int[] A = {1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0, 9};
        pushZeroToEnd(A);
        for (int i : A) {
        		System.out.print(i + " ");
        }
        System.out.println();
        
        int[] B = {1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0, 9};
        pushZeroToFront(B);
        for (int i : B) {
    			System.out.print(i + " ");
        }
        System.out.println();
	}
	
}
