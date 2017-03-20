package com.zeetcode.binarysearch;

public class Test {
	public static void main(String[] args) {
		Test a = new Test();
		int[] A = new int[] {2, 2, 2, 2, 1, 2, -1, 2, 1, 3};
		System.out.println(a.solution(A));
	}
	
	public int solution(int[] A) {
        int max = 1, maxIndex = 0;
        boolean[] visited = new boolean[A.length];
        
        for (int i = 0; i < A.length; i++) {            
            if (visited[i]) {
                continue;
            }
            
            int subLen = 1;
            for (int j = i+1; j < A.length; j++) {
                if (A[j-1] < A[j]) {
                    subLen++;
                    visited[j-1] = true;
                } else {
                    break;
                }
            }
            
            if (subLen > max) {
                max = subLen;
                maxIndex = i;
            }
        }
        
        return maxIndex;   
    }
}
