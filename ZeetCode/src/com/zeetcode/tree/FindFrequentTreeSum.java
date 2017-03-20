package com.zeetcode.tree;

import java.util.HashMap;
import java.util.Map;

import com.zeetcode.node.TreeNode;

public class FindFrequentTreeSum {
	
	public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer, Integer> sumCount = new HashMap<Integer, Integer>();
        sum(root, sumCount);
        
        int max = Integer.MIN_VALUE;
        for (Integer key : sumCount.keySet()) {
            max = Math.max(max, sumCount.get(key));
        }
        
        int count = 0;
        for (Integer key : sumCount.keySet()) {
            if (sumCount.get(key) == max) {
                count++;
            }
        }
        
        int i = 0;
        int[] re = new int[count];
        for (Integer key : sumCount.keySet()) {
            if (sumCount.get(key) == max) {
                re[i] = key;
                i++;
            }
        }
        
        return re;
    }
    
    public int sum(TreeNode root, Map<Integer, Integer> sumCount) {
        if (root == null) {
            return 0;
        }
        
        int leftSum = sum(root.left, sumCount);
        int rightSum = sum(root.right, sumCount);
        
//        if (root.left != null)
//            sumCount.put(leftSum, sumCount.getOrDefault(leftSum, 0) + 1);
//        
//        if (root.right != null)
//            sumCount.put(rightSum, sumCount.getOrDefault(rightSum, 0) + 1);
        
        int sum = root.val + leftSum + rightSum;
        sumCount.put(sum, sumCount.getOrDefault(sum, 0) + 1);
        
        return sum;
    }

    public static void main(String[] args) {
    	
    	TreeNode root = new TreeNode(5);
		root.left = new TreeNode(2);
		root.right = new TreeNode(-3);
		
		FindFrequentTreeSum f = new FindFrequentTreeSum();
		f.findFrequentTreeSum(root);
    }
}
