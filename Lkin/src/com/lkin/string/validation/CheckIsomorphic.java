package com.lkin.string.validation;

import java.util.HashMap;
import java.util.Map;

public class CheckIsomorphic {
	public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }
        
        Map<Character, Character> map = new HashMap<Character, Character>();
        char cs, ct;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            cs = s.charAt(i);
            ct = t.charAt(i);
            
            if (map.containsKey(cs)) {
                if (map.get(cs) != ct) {
                    return false;
                }
            } else {
                if (map.containsValue(ct)) {
                    return false;
                }
                map.put(cs, ct);
            }
        }
        
        return true;
    }
}
