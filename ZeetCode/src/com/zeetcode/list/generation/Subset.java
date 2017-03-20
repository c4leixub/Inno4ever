package com.zeetcode.list.generation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Subset {
	/**
	 * Given a set of distinct integers, S, return all possible subsets.
	 */
	public List<List<Integer>> subsets(int[] nums) {
        if (nums.length == 0) return null;
        
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> tmp = new ArrayList<Integer>();
        result.add(tmp);
        
        List<List<Integer>> newToResult;
        for (int i = 0; i < nums.length; i++) {
            
            newToResult = new ArrayList<List<Integer>>();
            for (List<Integer> list : result) {
                tmp = new ArrayList<Integer>();
                tmp.addAll(list);
                tmp.add(nums[i]);
                newToResult.add(tmp);
            }
            
            result.addAll(newToResult);
        }
        
        return result;
    }
	
	/**
	 * Given a collection of integers that might contain duplicates,
	 * num, return all possible subsets.
	 */
	public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
		if (num == null)
			return null;
	 
		Arrays.sort(num);
	 
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		ArrayList<ArrayList<Integer>> prev = new ArrayList<ArrayList<Integer>>();
	 
		for (int i = num.length-1; i >= 0; i--) {
	 
			//get existing sets
			if (i == num.length - 1 || num[i] != num[i + 1] || prev.size() == 0) {
				prev = new ArrayList<ArrayList<Integer>>();
				for (int j = 0; j < result.size(); j++) {
					prev.add(new ArrayList<Integer>(result.get(j)));
				}
			}
	 
			//add current number to each element of the set
			for (ArrayList<Integer> temp : prev) {
				temp.add(0, num[i]);
			}
	 
			//add each single number as a set, only if current element is different with previous
			if (i == num.length - 1 || num[i] != num[i + 1]) {
				ArrayList<Integer> temp = new ArrayList<Integer>();
				temp.add(num[i]);
				prev.add(temp);
			}
	 
			//add all set created in this iteration
			for (ArrayList<Integer> temp : prev) {
				result.add(new ArrayList<Integer>(temp));
			}
		}
	 
		//add empty set
		result.add(new ArrayList<Integer>());
	 
		return result;
	}
	
	public List<List<Integer>> subsetsWithDup2(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        Arrays.sort(nums);
        
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> tmp = new ArrayList<Integer>();
        result.add(tmp);
        
        List<List<Integer>> newToResult;
        for (int i = 0; i < nums.length; i++) {
            
            newToResult = new ArrayList<List<Integer>>();
            for (List<Integer> list : result) {
                tmp = new ArrayList<Integer>();
                tmp.addAll(list);
                tmp.add(nums[i]);
                if (!result.contains(tmp)) {
                		newToResult.add(tmp);
                }
            }
            
            result.addAll(newToResult);
        }
        
        return result;
}
	
	public static void main(String[] args) {
		int[] num = new int[] {1,2,2};
		Subset s = new Subset();
		//System.out.println(s.subsets(num));
		System.out.println(s.subsetsWithDup(num));
		System.out.println(s.subsetsWithDup2(num));
		
		num = new int[] {1,2,3};
		System.out.println(s.subsets(num));
		
	}
}
