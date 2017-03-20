package com.zeetcode.dynamicprogramming;

/**
 * There are a row of n houses, each house can be painted with one of the three
 * colors: red, blue or green. The cost of painting each house with a certain 
 * color is different. You have to paint all the houses such that no two 
 * adjacent houses have the same color.

The cost of painting each house with a certain color is represented by a 
n x 3 cost matrix. For example, costs[0][0] is the cost of painting house 
0 with color red; costs[1][2] is the cost of painting house 1 with color 
green, and so on... Find the minimum cost to paint all houses.
 */
public class PaintHouse {
	public int minCost(int[][] costs) {
	    if(costs==null||costs.length==0)
	        return 0;
	 
	    for(int i=1; i<costs.length; i++){
	        costs[i][0] += Math.min(costs[i-1][1], costs[i-1][2]);
	        costs[i][1] += Math.min(costs[i-1][0], costs[i-1][2]);
	        costs[i][2] += Math.min(costs[i-1][0], costs[i-1][1]);
	    }
	 
	    int m = costs.length-1;
	    return Math.min(Math.min(costs[m][0], costs[m][1]), costs[m][2]);
	}
	
	public int minCostWithKColor(int[][] costs) {
	    if(costs==null || costs.length==0)
	        return 0;
	 
	    int preMin=0;
	    int preSecond=0;
	    int preIndex=-1; 
	 
	    for(int i=0; i<costs.length; i++){
	        int currMin=Integer.MAX_VALUE;
	        int currSecond = Integer.MAX_VALUE;
	        int currIndex = 0;
	 
	        for(int j=0; j<costs[0].length; j++){
	            if(preIndex==j){
	                costs[i][j] += preSecond;
	            }else{
	                costs[i][j] += preMin;
	            }
	 
	            if(currMin>costs[i][j]){
	                currSecond = currMin;
	                currMin=costs[i][j];
	                currIndex = j;
	            } else if(currSecond>costs[i][j] ){
	                currSecond = costs[i][j];
	            }
	        }
	 
	        preMin=currMin;
	        preSecond=currSecond;
	        preIndex =currIndex;
	    }
	 
	    int result = Integer.MAX_VALUE;
	    for(int j=0; j<costs[0].length; j++){
	        if(result>costs[costs.length-1][j]){
	            result = costs[costs.length-1][j];
	        }
	    }
	    return result;
	}
}
