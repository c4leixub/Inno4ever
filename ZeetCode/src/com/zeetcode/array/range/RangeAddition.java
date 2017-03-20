package com.zeetcode.array.range;

/** Given:length = 5,updates = [[1,  3,  2],[2,  4,  3],[0,  2, -2]]
Output:
[-2, 0, 3, 5, 3]
Explanation:
Initial state: [ 0, 0, 0, 0, 0 ]
After applying operation [1, 3, 2]: [ 0, 2, 2, 2, 0 ]
After applying operation [2, 4, 3]: [ 0, 2, 5, 5, 3 ]
After applying operation [0, 2, -2]: [-2, 0, 3, 5, 3 ] */
public class RangeAddition {
	public int[] getModifiedArray(int length, int[][] updates) {
        int[] re = new int[length];
        
        for (int[] update : updates) {
        	int start = update[0], end = update[1], val = update[2];
        	re[start] += val;
        	if (end < length - 1) {
        		re[end+1] -= val;
        	}
        }
        
        int sum = 0;
        for (int i = 0; i < re.length; i++) {
        	sum += re[i];
        	re[i] = sum;
        }
        
        return re;
    }
}
