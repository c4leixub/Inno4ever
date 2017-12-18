package com.zeetcode.airbnb;

import java.util.ArrayList;
import java.util.List;

/*
John,Smith,john.smith@gmail.com,Los Angeles,1
Jane,Roberts,janer@msn.com,"San Francisco, CA",0
"Alexandra ""Alex""",Menendez,alex.menendez@gmail.com,Miami,1
"""Alexandra Alex"""
John|Smith|john.smith@gmail.com|Los Angeles|1
Jane|Roberts|janer@msn.com|San Francisco, CA|0
Alexandra "Alex"|Menendez|alex.menendez@gmail.com|Miami|1
"Alexandra Alex"

Understand the problem:
For this problem, there are several cases need to consider:
1. For comma, transform to |
2. If comma is inside a quote, don't treat the comma as separated. 
Remove the comma and print the entire token. e.g. "San Francisco, CA" => San Francisco, CA
3. If there are double quotes, remove one. e.g. "Alexandra ""Alex""" => Alexandra "Alex". 
Note that """Alexandra Alex""" becomes "Alexandra Alex" because we first remove the outer-most quote,
and then remove one quote of the double quote.
*/
public class ParseCSV {

	public String parseCSV(String s) {
		if (s == null || s.length() == 0) {
			return "";
		}

		List<String> result = new ArrayList<String>();
		boolean inQuote = false;
		StringBuffer sb = new StringBuffer();

		for (int i = 0; i < s.length(); i++) {
			if (inQuote) {
				if (s.charAt(i) == '"') {
					if (i == s.length() - 1) {
						result.add(sb.toString());
						return printStr(result);
					} else if (s.charAt(i + 1) == '"') {
						sb.append('"');
						i++;
					} else {
						result.add(sb.toString());
						sb.setLength(0);
						inQuote = false;
						i++;
					}
				} else {
					sb.append(s.charAt(i));
				}
			} else {
				if (s.charAt(i) == '"') {
					inQuote = true;
				} else if (s.charAt(i) == ',') {
					result.add(sb.toString());
					sb.setLength(0);
				} else {
					sb.append(s.charAt(i));
				}
			}
		}

		if (sb.length() > 0) {
			result.add(sb.toString());
		}

		return printStr(result);
	}

	private static String printStr(List<String> input) {
		if (input == null || input.size() == 0) {
			return "";
		}

		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < input.size(); i++) {
			sb.append(input.get(i));
			if (i == input.size() - 1) {
				break;
			}
			sb.append("|");
		}
		
		return sb.toString();
	}
	
	public static void main(String[] args) {
		int i = '9' - '0';
		System.out.println(i);
		
//		String s = "John,Smith,john.smith@gmail.com,Los Angeles,1\n"
//				+ "Jane,Roberts,janer@msn.com,\"San Francisco, CA\",0\n"
//				+ "\"Alexandra \"\"Alex\"\"\",Menendez,alex.menendez@gmail.com,Miami,1\n"
//				+ "\"\"\"Alexandra Alex\"\"\"";
//		
//		ParseCSV p = new ParseCSV();
//		
//		System.out.println(p.parseCSV(s));
//		
//		s = "aa,bb,\"aa\",\"aa,bb\",\"aa\"\"aa\"\"\"";
//		System.out.println(p.parseCSV(s));
	}
}
