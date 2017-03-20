package com.zeetcode.binaryIndexandsegmenttree;

public class RangeSumQuery {
	
	int[] btree;
	int[] arr;
	
	public RangeSumQuery(int[] nums) {
		btree = new int[nums.length+1];
		arr = nums;
		
		for(int i=0; i<nums.length; i++){
            add(i+1, nums[i]);
        }
    }
	
    private void add (int i, int val) {
        for (int j = i; j < btree.length; j = j + ( j & (-j) )) {
        	btree[j] += val;
        }
    }
    
    public void update(int i, int val) {
    	add(i+1, val-arr[i]);
        arr[i]=val;
    }

    public int sumRange(int i, int j) {
    	// i & j are array index, the result we want is 
    	// sum from 0 -> j minus sum from 0 -> i-1 
    	return sum(j+1)-sum(i);
    }
    
    // sum from 0 to i - 1 (this is array index) where
    // i is index in btree
    public int sum(int i){
        int sum=0;
        for(int j=i; j>=1; j=j-(j&(-j))){
            sum += btree[j];
        }
        return sum;
    }
    
    public static void main(String[] args) {
   	
    	System.out.println((Integer.toBinaryString(1)));
    	System.out.println((Integer.toBinaryString(-1)));
    	System.out.println((Integer.toBinaryString(2)));
    	System.out.println((Integer.toBinaryString(-2)));
    	
    	int[] arr = new int[] {1,2,3,4,5};
    	RangeSumQuery r = new RangeSumQuery(arr);
    	
    	System.out.println((Integer.toBinaryString(13)));
    }
}
