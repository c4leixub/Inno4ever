package com.zeetcode.aalk.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Given two strings s and t, determine if they are isomorphic.
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 * 
For example,
Given "egg", "add", return true.
Given "foo", "bar", return false.
Given "paper", "title", return true.
 */
public class IsomorphicString {
	public boolean isIsomorphic(String s, String t) {
		if(s==null||t==null)
	        return false;
	 
	    if(s.length()!=t.length())
	        return false;
		
		char cs;
        char ct;
        HashMap<Character, Character> charMap = new HashMap<Character, Character>();
        
        for (int i = 0; i < s.length(); i++) {
            cs = s.charAt(i);
            ct = t.charAt(i);
            
            if (charMap.containsKey(cs)) {
                if (charMap.get(cs) != ct) {
                	return false;	// if not consistant with previous ones
                }
            } else {
                if (charMap.containsValue(ct)) {
                	return false;	//if ct is already being mapped
                }
                charMap.put(cs, ct);
            }
        }
        
        return true;
    }
	
	public List<List<String>> groupIsomorphic(List<String> strs) {
		List<List<String>> result = new ArrayList<List<String>>();
				
		HashMap<String, List<String>> resultMap = new HashMap<String, List<String>>();
		for (String s : strs) {
			String isoStr = getIsomorphicString(s);
			if (resultMap.containsKey(isoStr)) {
				resultMap.get(isoStr).add(s);
			} else {
				List<String> list = new ArrayList<String>();
				list.add(s);
				resultMap.put(isoStr, list);
			}
		}
		
		result.addAll(resultMap.values());
		return result;
	}
	
	public String getIsomorphicString(String s) {
		char c = 'a';
		HashMap<Character, Character> map = new HashMap<Character, Character>();
		String re = "";
		
		char cs;
		for (int i = 0; i < s.length(); i++) {
			cs = s.charAt(i);
			if (!map.containsKey(cs)) {
				map.put(cs, c);
				re += c;
				c += 1;
			}  else {
				re += map.get(cs);
			}
		}
		
		return re;
	}
	
	public static void main(String[] args) {
		IsomorphicString iso = new IsomorphicString();
		List<String> strs = new ArrayList<String>();
		strs.add("egg");
		strs.add("bar");
		strs.add("foo");
		strs.add("kit");
		strs.add("ill");
		
		System.out.println(iso.groupIsomorphic(strs));
	
		System.out.println(iso.getIsomorphicString("egg"));
		System.out.println(iso.getIsomorphicString("foo"));
		
		System.out.println(('a'-'b') % 26);
		char c = 'z';
		c += 1;
		if (c > 'z') {
			c -= 26;
		}
		
		System.out.println(canShift("eqdf", "qcpr"));
		System.out.println(getStr("eqdf"));
		
		String s = "eqdf";
		String t = "qcpr";
		for (int i = 0; i < s.length(); i++) {
			System.out.println(Math.abs(s.charAt(0) - t.charAt(0)));
		}
		
		System.out.println(2.0 == 2);
	}
	
	public static String getStr(String s) {
		char[] arr = s.toCharArray();
        if(arr.length>0){
            int diff = arr[0]-'a';
            for(int i=0; i<arr.length; i++){
                if(arr[i]-diff<'a'){
                   arr[i] = (char) (arr[i]-diff+26);
                }else{
                   arr[i] = (char) (arr[i]-diff); 
                }
 
            }
        }  
 
        return new String(arr);
	}
	
	public static boolean canShift(String s, String t) {
        int k = Math.abs(s.charAt(0) - t.charAt(0));
        System.out.println(k);
        
        char c;
        for (int i = 1; i < s.length(); i++) {
            c = s.charAt(i);
            c += k;
            if ( c > 'z') {
                c -= 26;
            }
            System.out.println("from " + s.charAt(i) + " to " + c);
            
            if (c != t.charAt(i)) {
                return false;
            }
        }
        
        return true;
    }
	
}
