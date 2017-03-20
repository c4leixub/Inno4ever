package com.zeetcode.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class EvaluateDivision {
	public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
		
		Map<String, Map<String, Double>> map = new HashMap<String, Map<String, Double>>();
		for (int i = 0; i < equations.length; i++) {
			if (!map.containsKey(equations[i][0])) {
				map.put(equations[i][0], new HashMap<String, Double>());
			}
			map.get(equations[i][0]).put(equations[i][1], values[i]);
			
			if (!map.containsKey(equations[i][1])) {
				map.put(equations[i][1], new HashMap<String, Double>());
			}
			map.get(equations[i][1]).put(equations[i][0], 1.0 / values[i]);
		}
		
		double[] result = new double[queries.length];
		for (int i = 0; i < queries.length; i++) {
			String[] query = queries[i];
			if (map.containsKey(query[0]) && map.containsKey(query[1])) {
			    if (query[0].equals(query[1])) {
			    	result[i] = 1.0;
			    } else {
			    	result[i] = eval(query[0], query[1], map, 1.0, new HashSet<String>());
			    	if (result[i] != -1.0) {
			    		map.get(query[0]).put(query[1], result[i]);
			    		map.get(query[1]).put(query[0], 1.0 / result[i]);
			    	}
			    }
		    } else {
		        result[i] = -1.0;
		    }
		}

		return result;
	}
	
	
	public double eval(String s, String e, Map<String, Map<String, Double>> map, double val, Set<String> visited) {
		if (visited.contains(s))	return -1.0;
		
		Map<String, Double> mapS =  map.get(s);
		if (mapS.containsKey(e)) {
			return val * mapS.get(e);
		} else {
			visited.add(s);
			
			for (String d : mapS.keySet()) {
				double r = eval(d, e, map, val * mapS.get(d), visited);
				if (r != -1.0) {
					return r;
				}
			}
		}
		
		return -1.0;
	}
	
	public static void main(String[] args) {
		String[][] equations = new String[][] {{"a", "b"}, {"b", "c"}};
		//equations = new String[][] {{"x1","x2"},{"x2","x3"},{"x3","x4"},{"x4","x5"}};
		
		double[] values = new double[] {2.0, 3.0 };
		//values = new double[] {3.0, 4.0, 5.0, 6.0};
		
		String[][] queries = new String[][] {{"a", "c"}, {"b", "a"}, {"a", "e"}, {"a", "a"}, {"x", "x"} };
		//queries = new String[][] {{"x1", "x5"}, {"x5", "x2"}};
		
		EvaluateDivision e = new EvaluateDivision();
		for (double v : e.calcEquation(equations, values, queries)) {
			System.out.print(v + ", ");
		}
	}
}
