package com.zeetcode.tree.verify;

import java.util.Stack;

/**
 * One way to serialize a binary tree is to use pre-order traversal. When we encounter a non-null node, we record the node's value. If it is a null node, we record using a sentinel value such as #.

     _9_
    /   \
   3     2
  / \   / \
 4   1  #  6
/ \ / \   / \
# # # #   # #	serialize as "9,3,4,#,#,1,#,#,2,#,6,#,#"
Ex.

Example 1:
"9,3,4,#,#,1,#,#,2,#,6,#,#"
Return true

Example 2:
"1,#"
Return false

Example 3:
"9,#,#,1"
Return false
 */
public class VerifyPreorderSerializationOfBinaryTree {
	public boolean isValidSerialization(String preorder) {
		Stack<String> stack = new Stack<String>();
		String[] vals = preorder.split(",");
		
		int i = 0;
		String s;
		while (i < vals.length) {
			s = vals[i];
			stack.add(s);
			
			while (stack.size() >= 3
					&& "#".equals(stack.get(stack.size()-1))
					&& "#".equals(stack.get(stack.size()-2))
					&& !"#".equals(stack.get(stack.size()-3)))	{
				
				stack.pop();
				stack.pop();
				stack.pop();
				stack.push("#");
			}
			i++;
		}
		
		return stack.size() == 1 && "#".equals(stack.peek());
	}
	
	public static void main(String[] args) {
		String preorder = "9,3,4,#,#,1,#,#,2,#,6,#,#";
		VerifyPreorderSerializationOfBinaryTree v = new VerifyPreorderSerializationOfBinaryTree();
		System.out.println(v.isValidSerialization(preorder));
	}
}
