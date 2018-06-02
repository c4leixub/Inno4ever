package com.zeetcode.string.anagram;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given an array of strings, group anagrams together.

For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], 
Return:

[ ["ate", "eat","tea"], ["nat","tan"], ["bat"] ]
 */
public class GroupAnagram {
	public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        String key;
        for (String s : strs) {
            key = getKey(s);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<String>());
            }
            map.get(key).add(s);
        }
        
        List<List<String>> res = new ArrayList<List<String>>();
        for (String k : map.keySet()) {
            res.add(map.get(k));
        }
        return res;
    }
    
    private String getKey(String str) {
        char[] c = str.toCharArray();
        Arrays.sort(c);
        return new String(c);
    }
}
