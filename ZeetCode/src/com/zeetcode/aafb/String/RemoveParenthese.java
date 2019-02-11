package com.zeetcode.aafb.String;

import java.util.ArrayList;
import java.util.List;

public class RemoveParenthese {
	public List<String> removeInvalidParentheses(String s) {
        int count1 = 0, count2 = 0;
        char c;
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            
            count1 = c == '(' ? count1 + 1 : count1;
            
            if (count1 == 0) {
                count2 = c == ')' ? count2 + 1 : count2;
            } else {
                count1 = c == ')' ? count1 - 1 : count1;
            }
        }
        
        List<String> result = new ArrayList<String>();
        dfs(s, 0, count1, count2, result);
        
        return result;
    }
    
    private void dfs(String s, int start, int count1, int count2, List<String> result) {
        if (count1 == 0 && count2 == 0) {
            if (isValid(s)) {
                result.add(s);
            }
            return;
        }
        
        for (int i = start; i < s.length(); i++) {
            if (i != start && s.charAt(i) == s.charAt(i-1)) continue;
            
            if (count1 > 0 && s.charAt(i) == '(') {
                dfs(s.substring(0, i) + s.substring(i+1), i, count1-1, count2, result);
            }
            
            if (count2 > 0 && s.charAt(i) == ')') {
                dfs(s.substring(0, i) + s.substring(i+1), i, count1, count2-1, result);
            }
        }
    }
    
    private boolean isValid(String t) {
        int cnt = 0;
        for (int i = 0; i < t.length(); ++i) {
            if (t.charAt(i) == '(') ++cnt;
            else if (t.charAt(i) == ')' && --cnt < 0) return false;
        }
        return cnt == 0;
    }
    
    public static void main(String[] args) {
    	String s = "()())()";
    	RemoveParenthese r = new RemoveParenthese();
    	r.removeInvalidParentheses(s);
    }
}
