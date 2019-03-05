package com.abb.abb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PyrimidTransitionMatrix {
	public boolean pyramidTransition(String bottom, List<String> allowed) {
		
		// "ABC" : AB -> C
		Map<String, List<Character>> map = new HashMap<String, List<Character>>();

		char c;
		String key;
		for (String str : allowed) {
			c = str.charAt(2);
			key = str.substring(0, 2);
			map.putIfAbsent(key, new ArrayList<Character>());
			map.get(key).add(c);
		}

		return dfs(bottom, new StringBuilder(), map, 0);
	}

	public boolean dfs(String bottom, StringBuilder nextBottom, Map<String, List<Character>> map, int p) {
		if (p == bottom.length() - 1) {
			bottom = nextBottom.toString();
			nextBottom = new StringBuilder();
			p = 0;
		}
		
		if (bottom.length() == 1)
			return true;
		
		String key = bottom.substring(p, p + 2);
		if (map.containsKey(key)) {
			for (char val : map.get(key)) {
				nextBottom.append(val);
				if (dfs(bottom, nextBottom, map, p + 1))
					return true;
				nextBottom.setLength(nextBottom.length() - 1);
			}
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		PyrimidTransitionMatrix p = new PyrimidTransitionMatrix();
		
		String bottom = "XYZ";
		List<String> allowed = Arrays.asList("XYD", "YZE", "DEA", "FFF");
		System.out.println(p.pyramidTransition(bottom, allowed));
		
		bottom = "XYZ";
		allowed = Arrays.asList("XYB", "XYD", "YZE", "DEA");
		System.out.println(p.pyramidTransition(bottom, allowed));
		
		bottom = "BCFG";
		allowed = Arrays.asList("XYD", "YZE", "DEA", "FFF", "BCX", "CFY", "FGZ");
		System.out.println(p.pyramidTransition(bottom, allowed));
	}
}
