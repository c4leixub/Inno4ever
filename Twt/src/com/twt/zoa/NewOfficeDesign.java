package com.twt.zoa;

public class NewOfficeDesign {

	public int maxHashTag(int[] tablePositions, int[] tableHeights) {
		
		int max = 0;
		for(int i = 1; i < tablePositions.length; i++) {
			if (tablePositions[i] - tablePositions[i-1] > 1) {
				max = Math.max(max,
						getMaxHeight(tablePositions[i-1], tablePositions[i],
										tableHeights[i-1], tableHeights[i]));
			}
		}
		
		return max;
	}
	
	private int getMaxHeight(int p1, int p2, int h1, int h2) {
		int shorter = Math.min(h1, h2), taller = Math.max(h1, h2);
		int gap = Math.abs(p2 - p1) - 1;
		if (taller >= shorter + gap) {
			return shorter + gap;
		} else {
			int top = shorter + gap, down = taller + 1;
			return (top + down) / 2;
		}
	}
	
	public static void main(String[] args) {
		NewOfficeDesign n = new NewOfficeDesign();
		
		int[] tablePositions = new int[] {1,2,4,7}, 
				tableHeights = new int[] {4,5,7,11};
		System.out.println(n.maxHashTag(tablePositions, tableHeights));	//9
		
		tablePositions = new int[] {1,3,7};
		tableHeights = new int[] {4,3,3};
		System.out.println(n.maxHashTag(tablePositions, tableHeights));	//5
		
		tablePositions = new int[] {1,10};
		tableHeights = new int[] {1,5};
		System.out.println(n.maxHashTag(tablePositions, tableHeights));	//7
	}
}
