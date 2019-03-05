package com.abb.abb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TextJustify {
	
	public String print(List<String> input) {
		StringBuilder res = new StringBuilder();
		
		int max = Integer.MIN_VALUE;
		for (String s : input) {
			max = Math.max(max, s.length());
		}
		
		StringBuilder border = new StringBuilder();
		border.append(('+'));
		border.append(new String(new char[max]).replace('\0', '-'));
		border.append(('+'));
		border.append(('\n'));
		
		res.append(border.toString());
		
		for (String s : input) {
			res.append('|');
			res.append(s);
			res.append(new String(new char[max-s.length()]).replace('\0', ' '));
			res.append('|');
			res.append(('\n'));
			res.append(border.toString());
		}
		
		return res.toString();
	}
	
	public String print(List<String> input, int width) {
		StringBuilder res = new StringBuilder();
		
		StringBuilder border = new StringBuilder();
		border.append(('+'));
		border.append(new String(new char[width]).replace('\0', '-'));
		border.append(('+'));
		border.append(('\n'));
		
		res.append(border.toString());
		
		StringBuilder sb = new StringBuilder();
		for (String s : input) {
			
			String[] tmp = s.split(" ");
			int i = 0;
			while (i < tmp.length) {
				if (sb.length() == 0 || sb.length() + 1 + tmp[i].length() <= width) {
					sb.append(tmp[i]);
					sb.append(' ');
					i++;
				} else {
					res.append('|');
					res.append(sb.toString());
					res.append(new String(new char[width-sb.length()]).replace('\0', ' '));
					res.append('|');
					res.append(('\n'));
					
					sb.setLength(0);
				}
			}
			
			if (sb.length() > 0) {
				res.append('|');
				res.append(sb.toString());
				res.append(new String(new char[width-sb.length()]).replace('\0', ' '));
				res.append('|');
				res.append(('\n'));
				
				sb.setLength(0);
			}
			
			res.append(border.toString());
		}
		
		return res.toString();
	}
	
	public static void main(String[] args) {
		TextJustify t = new TextJustify();
		List<String> input = Arrays.asList("first word", "my second sentence", "now it's third");
		
		System.out.println(t.print(input));
		System.out.println();
		
		System.out.println(t.print(input, 16));
		System.out.println();
	}
}
