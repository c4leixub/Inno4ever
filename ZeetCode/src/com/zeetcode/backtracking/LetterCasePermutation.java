package com.zeetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string S, we can transform every letter individually to be lowercase or uppercase to create another string.  Return a list of all possible strings we could create.

Examples:
Input: S = "a1b2"
Output: ["a1b2", "a1B2", "A1b2", "A1B2"]

Input: S = "3z4"
Output: ["3z4", "3Z4"]

Input: S = "12345"
Output: ["12345"]
 */
public class LetterCasePermutation {
	
	public List<String> letterCasePermutation(String S) {
        List<String> result = new ArrayList<String>();
        StringBuilder builder = new StringBuilder();
        dfs(result, builder, S, 0);
        return result;
    }
    private void dfs(List<String> result, StringBuilder builder, String s, int i) {
        if (i == s.length()) {
            result.add(builder.toString());
            return;
        }
        
        
        builder.append(s.charAt(i));
        dfs(result, builder, s, i+1);
        builder.deleteCharAt(builder.length()-1);
          
        if (Character.isLetter(s.charAt(i))) {
            if (Character.isLowerCase(s.charAt(i))) {
                builder.append(Character.toUpperCase(s.charAt(i)));
            } else {
                builder.append(Character.toLowerCase(s.charAt(i)));
            }
            dfs(result, builder, s, i+1);
            builder.deleteCharAt(builder.length()-1);
        }
    }
}
