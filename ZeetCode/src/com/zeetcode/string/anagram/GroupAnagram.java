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
	    List<List<String>> result = new ArrayList<List<String>>();
	 
	    HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
	    for(String str: strs){
	        char[] arr = str.toCharArray();
	        Arrays.sort(arr);
	        String ns = new String(arr);
	 
	        if(map.containsKey(ns)){
	            map.get(ns).add(str);
	        }else{
	            ArrayList<String> al = new ArrayList<String>();
	            al.add(str);
	            map.put(ns, al);
	        }
	    }
	 
	    for(Map.Entry<String, ArrayList<String>> entry: map.entrySet()){
	        Collections.sort(entry.getValue());
	    }
	 
	    result.addAll(map.values());
	 
	    return result;
	}
}
