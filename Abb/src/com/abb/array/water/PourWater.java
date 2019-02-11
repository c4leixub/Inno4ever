package com.abb.array.water;

public class PourWater {
	public int[] pourWater(int[] heights, int V, int K) {
        int i = 0, best;
        while (i < V) {
        	best = K;
        	int left = K - 1;
            while (left >= 0 && heights[left] <= heights[left+1]) {
            	if (heights[left] < heights[left+1]) {
            		best = left;
            	}          	
            	left--;
            }
            
            if (best != K) {
            	heights[best]++;
            	i++;
            	continue;
            };
            
            best = K;
            int right = K + 1;
            while (right < heights.length && heights[right] <= heights[right-1]) {
            	if (heights[right] < heights[right-1]) {
            		best = right;
            	}
            	right++;
            }
            
            if (best != K) {
            	heights[best]++;
            	i++;
            	continue;
            }
            
            heights[K]++;
            i++;
        }
        
        return heights;
	}
	
	public static void main(String[] args) {
		PourWater pw = new PourWater();
		
		int[] heights = new int[] {2,1,1,2,1,2,2};
		int V = 4, K = 3;
		
		int[] re = pw.pourWater(heights, V, K);
		
		print(re);
		
		heights = new int[] {1,2,3,4,3,2,1,2,3,4,3,2,1};
		V = 2;
		K = 5;
		
		re = pw.pourWater(heights, V, K);
		print(re);
	}
	
	private static void print(int[] re) {
		for (int i = 0; i < re.length; i++) {
			System.out.print(re[i]);
			System.out.print(", ");
		}
		System.out.println();
	}
}