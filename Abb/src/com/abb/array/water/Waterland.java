package com.abb.array.water;

public class Waterland {
	public void pourWater(int[] heights, int water, int location) {
		int[] waters = new int[heights.length];
		int best;

		while (water > 0) {
			best = location;
			int left = location - 1;
			while (left >= 0 && heights[left] + waters[left]  <= heights[left+1] + waters[left+1]) {
            	if (heights[left] + waters[left] < heights[left+1] + waters[left+1]) {
            		best = left;
            	}          	
            	left--;
            }
			
			if (best != location) {
            	waters[best]++;
            	water--;
            	continue;
            };
            
            best = location;
            int right = location + 1;
            while (right < heights.length && heights[right]+waters[right] <= heights[right-1]+waters[right-1]) {
            	if (heights[right]+waters[right] < heights[right-1]+waters[right-1]) {
            		best = right;
            	}
            	right++;
            }
            
            if (best != location) {
            	waters[best]++;
            	water--;
            	continue;
            };
            
            waters[best]++;
        	water--;
		}

		print(heights, waters);
	}

	private void print(int[] heights, int[] waters) {
		int n = heights.length;
		int maxHeight = 0;
		for (int i = 0; i < n; i++) {
			maxHeight = Math.max(maxHeight, heights[i] + waters[i]);
		}

		for (int height = maxHeight; height >= 0; height--) {
			for (int i = 0; i < n; i++) {
				if (height <= heights[i]) {
					System.out.print("+");
				} else if (height > heights[i] && height <= heights[i] + waters[i]) {
					System.out.print("W");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		Waterland w = new Waterland();
		
		int[] heights = new int[] {5,4,2,1,2,3,2,1,0,1,2,4};
		int water = 8;
		int location = 5;
		
		w.pourWater(heights, water, location);
	}
}
