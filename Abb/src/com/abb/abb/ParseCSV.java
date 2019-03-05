package com.abb.abb;

import java.util.ArrayList;
import java.util.List;

/*
John,Smith,john.smith@gmail.com,Los Angeles,1
Jane,Roberts,janer@msn.com,"San Francisco, CA",0
"Alexandra ""Alex""",Menendez,alex.menendez@gmail.com,Miami,1
"""Alexandra Alex"""

become

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

	public String parseCSV(String str) {
		List<String> res = new ArrayList<>();
		boolean inQuote = false;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			if (inQuote) {
				if (str.charAt(i) == '\"') {
					if (i < str.length() - 1 && str.charAt(i + 1) == '\"') {	// combine "" to "
						sb.append("\"");
						i++;
					} else {
						inQuote = false;
					}
				} else {
					sb.append(str.charAt(i));
				}
			} else {
				if (str.charAt(i) == '\"') {
					inQuote = true;
				} else if (str.charAt(i) == ',') {
					res.add(sb.toString());
					sb.setLength(0);
				} else {
					sb.append(str.charAt(i));
				}
			}
		}
		if (sb.length() > 0) {
			res.add(sb.toString());
		}

		return String.join("|", res);
	}

	public static void main(String[] args) {

		String s = "John,Smith,john.smith@gmail.com,Los Angeles,1\n"
				+ "Jane,Roberts,janer@msn.com,\"San Francisco, CA\"a,0\n"
				+ "\"Alexandra \"\"Alex\"\"\",Menendez,alex.menendez@gmail.com,Miami,1\n"
				+ " \"Alexandra \"\"\"Alex\"\"\"\" ";

		ParseCSV p = new ParseCSV();

		System.out.println(p.parseCSV(s));

		s = "aa,bb,\"aa\",\"aa,bb\",\"aa\"\"aa\"\"\"";
		System.out.println(p.parseCSV(s));
		
		System.out.println(" \"Alexandra \"\"Alex\"\"\" ");
		System.out.println(" \"Alexandra \"\"\"\"Alex\"\"\"\"\" ");
		
		System.out.println(p.parseCSV(" \"Alexandra \"\"\"\"Alex\"\"\"\"\" "));
	}
}
