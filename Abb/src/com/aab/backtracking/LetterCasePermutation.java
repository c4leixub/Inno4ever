package com.aab.backtracking;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {
	public List<String> letterCasePermutation(String S) {
        List<String> result = new ArrayList<String>();
        dfs(result, new StringBuilder(), S, 0);
        return result;
    }
    
    private void dfs(List<String> result, StringBuilder sb, String s, int i) {
        if (sb.length() == s.length()) {
            result.add(sb.toString());
            return;
        }
        
        if (Character.isLetter(s.charAt(i))) {
            
            sb.append(Character.toLowerCase(s.charAt(i)));
            dfs(result, sb, s, i+1);
            sb.deleteCharAt(sb.length() - 1);
            
            sb.append(Character.toUpperCase(s.charAt(i)));
            dfs(result, sb, s, i+1);
            sb.deleteCharAt(sb.length() - 1);
        } else {
            sb.append(s.charAt(i));
            dfs(result, sb, s, i+1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
