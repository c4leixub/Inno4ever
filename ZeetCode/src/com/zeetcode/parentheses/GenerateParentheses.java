package com.zeetcode.parentheses;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
	
	public List<String> generateParentheses(int n) {
		List<String> result = new ArrayList<String>();
		helper(result, "", n, n);
		return result;
	}
	
	public void helper(List<String> result, String s, int left, int right) {
		if (left > right) {
			return;		// to avoid cases like )(
		}
		
		if (left == 0 && right == 0) {
			result.add(s);
			return;
		}
		
		if (left > 0) {
			helper(result, s+"(", left - 1, right);
		}
		if (right > 0) {
			helper(result, s+")", left, right-1);
		}
	}
	
	public static void main(String[] args) {
		GenerateParentheses g = new GenerateParentheses();
		System.out.println(g.generateParentheses(2));
	}
}
