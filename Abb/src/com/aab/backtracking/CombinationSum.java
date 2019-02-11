package com.aab.backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
	
	public List<List<Integer>> combinationSum1(int[] candidates, int target) {

		List<List<Integer>> result = new ArrayList<List<Integer>>();
		dfs1(result, new ArrayList<Integer>(), candidates, 0, target);
		return result;
	}
	private void dfs1(List<List<Integer>> result, List<Integer> list, int[] candidates, int s, int target) {
		if (target == 0) {
			result.add(new ArrayList<Integer>(list));
			return;
		} else if (target < 0) {
			return;
		}

		for (int i = s; i < candidates.length; i++) {
			list.add(candidates[i]);
			dfs1(result, list, candidates, i, target - candidates[i]);
			list.remove(list.size() - 1);
		}
	}
	
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        dfs2(result, new ArrayList<Integer>(), candidates, 0, target);
        return result;
    }
    private void dfs2(List<List<Integer>> result, List<Integer> list, int[] candidates, int s, int target) {
        if (target == 0) {
            result.add(new ArrayList<Integer>(list));
            return;
        } else if (target < 0) {
            return;
        }
        
        for (int i = s; i < candidates.length; i++) {
            list.add(candidates[i]);
            dfs2(result, list, candidates, i, target-candidates[i]);
            list.remove(list.size()-1);
        }
    }
    
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        dfs3(result, new ArrayList<Integer>(), k, n, 1);
        return result;
    }
    private void dfs3(List<List<Integer>> result, List<Integer> list, int k, int n, int s) {
        if (list.size() > k) {
            return;
        }
        
        if (n == 0) {
            if (list.size() == k) {
                result.add(new ArrayList<Integer>(list));
            }
            return;
        }
        
        
        for (int i = s; i <= 9; i++) {
            if (n - i < 0) break;
            
            list.add(i);
            dfs3(result, list, k, n - i, i+1);
            list.remove(list.size()-1);
        }
    }
}
