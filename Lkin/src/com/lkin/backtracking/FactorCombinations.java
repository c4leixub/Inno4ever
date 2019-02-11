package com.lkin.backtracking;

import java.util.ArrayList;
import java.util.List;

public class FactorCombinations {
	
	public List<List<Integer>> getFactors(int n) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (n == 1) {
			return res;
		}
        
        dfs(res, new ArrayList<Integer>(), n, 1, 2);
		return res;
    }
	
	public void dfs(List<List<Integer>> res, List<Integer> list, int n, int product, int s) {
		if (product == n) {
			res.add(new ArrayList<Integer>(list));
			return;
		} else if (product > n) {
            return;
        }
		
		for (int i = s; i <= n / 2; i++) {
            if(i * product > n) {
                break;
            }
            
            if (n % i == 0) {
                list.add(i);
                dfs(res, list, n, product * i, i);
                list.remove(list.size()-1);
            } 
            
        }
	}
}
