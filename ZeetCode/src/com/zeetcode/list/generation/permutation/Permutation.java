package com.zeetcode.list.generation.permutation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Permutation {
	/**
	 * Given a collection of numbers, return all possible permutations.

	For example,
	[1,2,3] have the following permutations:
	[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
	 */
	public List<List<Integer>> permute(int[] nums) {
        return permuteHelper(nums, 0);
    }
    private List<List<Integer>> permuteHelper(int[] nums, int index) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (index == nums.length) {
            res.add(Collections.emptyList());
			return res;
        }
        
        int e = nums[index];
        List<List<Integer>> tmp = permuteHelper(nums, index+1);
		for (List<Integer> intList : tmp) {
			for (int i = 0; i < intList.size()+1; i++) {
				List<Integer> newList = new ArrayList<Integer>(intList);
				newList.add(i, e);
				res.add(newList);
			}
		}
        
        return res;
    }
    
    /**
     * Given a collection of numbers that might contain duplicates, 
     * return all possible unique permutations.

		For example, [1,1,2] have the following unique permutations:
		[1,1,2], [1,2,1], and [2,1,1].
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        return permuteUniqueHelper(nums, 0);
    }
    private List<List<Integer>> permuteUniqueHelper(int[] nums, int index) {
    		HashSet<List<Integer>> res = new HashSet<List<Integer>>();
        if (index == nums.length) {
            res.add(Collections.emptyList());
			return new ArrayList<List<Integer>>(res);
        }
        
        int e = nums[index];
        List<List<Integer>> tmp = permuteHelper(nums, index+1);
		for (List<Integer> intList : tmp) {
			for (int i = 0; i < intList.size()+1; i++) {
				List<Integer> newList = new ArrayList<Integer>(intList);
				newList.add(i, e);
				res.add(newList);
			}
		}
        
        return new ArrayList<List<Integer>>(res);
    }
    
    public static void main(String[] args) {
    		List<Integer> a = new ArrayList<Integer>();
    		a.add(1);
    		a.add(1);
    		a.add(2);
    		
    		List<Integer> b = new ArrayList<Integer>();
    		b.add(1);
    		b.add(1);
    		b.add(2);
    		
    		System.out.println(b.equals(a));
    		System.out.println(a.hashCode() == b.hashCode());
    }
}
