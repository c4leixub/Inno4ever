package com.zeetcode.integer.nested;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class NestedIntegerDepthSum {
	
	public int depthSum(List<NestedInteger> input) {
		return depthSum(input, 1);
	}
	public int depthSum(List<NestedInteger> input, int depth) {
		int sum = 0;
		for (NestedInteger i : input) {
			if (i.isInteger()) {
				sum += i.getInteger() * depth;
			} else {
				sum += depthSum(i.getList(), depth+1);
			}
		}
		
		return sum;
	}
	
	public int reverseDepthSum(List<NestedInteger> input) {
		List<List<Integer>> bucket = new ArrayList<List<Integer>>();
		reverseDepthSum(bucket, input, 1);
		
		int sum = 0;
		for (int i = 0; i < bucket.size(); i++) {
			for (Integer j : bucket.get(i)) {
				sum += j * (bucket.size()-i);
			}
		}
		
		return sum;
	}
	public void reverseDepthSum(List<List<Integer>> bucket, List<NestedInteger> input, int depth) {
		for (NestedInteger i : input) {
			if (i.isInteger()) {
				while (bucket.size() < depth) {
					bucket.add(new ArrayList<Integer>());
				}
				bucket.get(depth-1).add(i.getInteger());
			} else {
				reverseDepthSum(bucket, i.getList(), depth+1);
			}
		}
	}
	
	public int reverseDepthSumOnePass(List<NestedInteger> nestedList) {
		int sum = 0;
		int reverseDepthSum = 0;
		List<NestedInteger> cur = nestedList;
		List<NestedInteger> next = new ArrayList<NestedInteger>();
		for (NestedInteger nestedInteger : cur) {
			if (nestedInteger.isInteger()) {
				sum += nestedInteger.getInteger();
			} else {
				next.add(nestedInteger);
			}
		}
		reverseDepthSum += sum;
		cur = next;
		next = new ArrayList<NestedInteger>();
		
		while (cur.size() != 0) {
			for (NestedInteger list : cur) {
				for (NestedInteger nestedInteger : list.getList()) {
					if (nestedInteger.isInteger()) {
						sum += nestedInteger.getInteger();
					} else {
						next.add(nestedInteger);
					}
				}
			}
            reverseDepthSum += sum;
			cur = next;
			next = new ArrayList<NestedInteger>();
		}
		return reverseDepthSum;
	}
	
	public int depthSumInverse(List<NestedInteger> nestedList) {
        Map<Integer, Integer> depthToSum = new HashMap<Integer, Integer>();
        int maxDepth = depthSumInverse(nestedList, 1, depthToSum);
        
        int sum = 0, depth = 1;
        while (depth <= maxDepth) {
            if (depthToSum.containsKey(depth)) {
                sum += depthToSum.get(depth) * (maxDepth-depth+1);
            }           
            depth++;
        }
        
        return sum;
    }
    
    public int depthSumInverse(List<NestedInteger> nestedList, int depth, Map<Integer, Integer> depthToSum) {
        
        int maxDepth = depth;
        for (NestedInteger e : nestedList) {
            if (e.isInteger()) {
                if (!depthToSum.containsKey(depth)) {
                    depthToSum.put(depth, 0);
                }
                depthToSum.put(depth, depthToSum.get(depth) + e.getInteger());
            } else {
                maxDepth = Math.max(maxDepth, depthSumInverse(e.getList(), depth+1, depthToSum));
            }
        }
        
        return maxDepth;
    }
	
	
	public int reverseDepthSumQueue(List<NestedInteger> input) {
		
		int sum = 0;
		int reverseDepthSum = 0;
		
		Queue<NestedInteger> cur = new LinkedList<NestedInteger>();
		for (NestedInteger nestedInteger : input) {
			if (nestedInteger.isInteger()) {
				sum += nestedInteger.getInteger();
			} else {
				cur.add(nestedInteger);
			}
		}
		reverseDepthSum += sum;
		
		Queue<NestedInteger> next = new LinkedList<NestedInteger>();
		while (!cur.isEmpty()) {
			for (NestedInteger nestedInteger : cur.poll().getList()) {
				if (nestedInteger.isInteger()) {
					sum += nestedInteger.getInteger();
				} else {
					next.add(nestedInteger);
				}
			}
			
			if (cur.isEmpty()) {
				reverseDepthSum += sum;
				if (!next.isEmpty()) {
					cur = next;
					next = new LinkedList<NestedInteger>();
				}
			}
		}
		
		return reverseDepthSum;
	}
	
	public int depth(List<NestedInteger> input) {
		int d = 0;
		for (NestedInteger i : input) {
			if (!i.isInteger()) {
				d = Math.max(d, depth(i.getList()));
			}
		}
		
		return d+1;
	}
	
	public static void main(String[] args) {
		NestedIntegerDepthSum s = new NestedIntegerDepthSum();
		
		List<NestedInteger> input = new ArrayList<NestedInteger>();
		NestedInteger i = new NestedIntegerImpl(Arrays.asList(new NestedIntegerImpl(1), new NestedIntegerImpl(1)));
		input.add(i);
		i = new NestedIntegerImpl(2);
		input.add(i);
		i = new NestedIntegerImpl(Arrays.asList(new NestedIntegerImpl(1), new NestedIntegerImpl(1)));
		input.add(i);
		
		//System.out.println(s.depthSumInverse(input));
		
//		System.out.println(input);
//		System.out.println(s.depthSum(input));
//		System.out.println(s.reverseDepthSum(input));
//		
//		input = new ArrayList<NestedInteger>();
//		input.add(new NestedIntegerImpl(1));
//		input.add(new NestedIntegerImpl(Arrays.asList(new NestedIntegerImpl(4), new NestedIntegerImpl(Arrays.asList(new NestedIntegerImpl(6))))));
//		
//		System.out.println(input);
//		
//		System.out.println(s.reverseDepthSum(input));
		System.out.println(s.reverseDepthSumOnePass(input));
//		System.out.println(s.reverseDepthSumQueue(input));
		
	}
}
