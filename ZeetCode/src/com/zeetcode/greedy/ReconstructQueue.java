package com.zeetcode.greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
/**
 * Suppose you have a random list of people standing in a queue. Each person is described by a pair of integers (h, k), where h is the height of the person and k is the number of people in front of this person who have a height greater than or equal to h. Write an algorithm to reconstruct the queue.
Example
Input:
[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]

Output:
[[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 */
public class ReconstructQueue {
	public int[][] reconstructQueue(int[][] people) {
        // Ex [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
		Arrays.sort(people, new Comparator<int[]>() {
                public int compare(int[] p1, int[] p2) {
                    if (p1[0] == p2[0]) {
                        return p1[1] - p2[1];
                    }
                    
                    // the tall one in front
                    return p2[0] - p1[0];
                }
            }
        );
		
		// after sort it high first, then order by the # of tall in front
		// we have [[7,0], [7,1], [6,1], [5,0], [5,2], [4,4]]
        // Note: second element become index now
		
        List<int[]> resultList = new LinkedList<>();
        for(int[] cur : people){
            resultList.add(cur[1], cur);	
        }
        return resultList.toArray(new int[people.length][]);
    }
}
