package com.goo.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.goo.node.TreeNode;

public class AllPossibleFullBinaryTree {
	
	Map<Integer, List<TreeNode>> resultMap = new HashMap<>();

	public List<TreeNode> allPossibleFBT(int N) {
        
        if (!resultMap.containsKey(N)) {
            List<TreeNode> result = new ArrayList<>();
            
            if (N == 1) {
                result.add(new TreeNode(0));
            } else if (N % 2 == 1) {
                
                for (int i = 0; i < N; i++) {
                    int j = N - 1 - i;
                    
                    for (TreeNode left : allPossibleFBT(i)) {
                        for (TreeNode right : allPossibleFBT(j)) {
                            TreeNode newNode = new TreeNode(0);
                            newNode.left = left;
                            newNode.right = right;
                            result.add(newNode);
                        }
                    }
                } 
                
            } // if N is even, it's not possible to build such tree
            
            resultMap.put(N, result);
        }
        
        return resultMap.get(N);
    }
}
