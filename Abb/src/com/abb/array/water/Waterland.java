package com.abb.array.water;

public class Waterland {
	public void pourWater(int[] heights, int water, int location) {
		int[] waters = new int[heights.length];
		
		//print(heights, waters);
		
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
            
            waters[best]++;
        	water--;
		}

		printTwo(heights, waters);
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
	
	private void printTest(int[] heights, int[] waters) {
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
	
	private void printTwo(int[] heights, int[] waters) {
		int n = heights.length;
		int maxHeight = 0;
		for (int i = 0; i < n; i++) {
			maxHeight = Math.max(maxHeight, heights[i] + waters[i]);
		}
		
		StringBuilder[] sbs = new StringBuilder[maxHeight+1];
		for (int i = 0; i < maxHeight+1; i++) {
			sbs[i] = new StringBuilder(n);
		}
		
		for (int i = 0; i < n; i++) {
			sbs[maxHeight].append('+');
			
			int index = maxHeight-1;
			for (int h = heights[i]; h > 0 && index >= 0; h--) {
				sbs[index].append('+');
				index--;
			}
			
			for (int w = waters[i]; w > 0 && index >= 0; w--) {
				sbs[index].append('W');
				index--;
			}
			
			while (index >= 0) {
				sbs[index].append(' ');
				index--;
			}
		}
		
		for (int i = 0; i < maxHeight+1; i++) {
			System.out.println(sbs[i]);
		}
	}
	
	
	public static void main(String[] args) {
		Waterland w = new Waterland();
		
		int[] heights = new int[] {5,4,2,1,2,3,2,1,0,1,2,4};
		int water = 8;
		int location = 5;
		
		w.pourWater(heights, water, location);
		
//		heights = new int[] {2,1,1,2,1,2,2};
//		water = 4; location = 3;
//		w.pourWater(heights, water, location);
		
		
	}
}
