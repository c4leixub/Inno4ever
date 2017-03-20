package com.zeetcode.list.generation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalTriangle {
	public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (numRows == 0) return result;
        
        List<Integer> pre;
        List<Integer> tmp = new ArrayList<Integer>();
        tmp.add(1);
        result.add(tmp);
        
        
        for (int i = 1; i < numRows; i++) {
            pre = result.get(result.size()-1);
            tmp = new ArrayList<Integer>();
            
            tmp.add(1);
            for (int j = 0; j < pre.size()-1; j++) {
                tmp.add(pre.get(j)+pre.get(j+1));
            }
            tmp.add(1);
            
            result.add(tmp);
        }
        
        return result;
    }
	
	public List<Integer> getRow(int rowIndex) {
        if (rowIndex < 0) return null;
        
        if (rowIndex == 0) {
        		return Arrays.asList(new Integer[]{1});
        }
        
        List<Integer> pre = getRow(rowIndex - 1);
        List<Integer> tmp = new ArrayList<Integer>();
        
        tmp.add(1);
        for (int j = 0; j < pre.size()-1; j++) {
            tmp.add(pre.get(j)+pre.get(j+1));
        }
        tmp.add(1);
        
        return tmp;
    }
}
