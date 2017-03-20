package com.zeetcode.string;

public class PrintJson {
	
	public void printJson(String s) {
		String t = "";
		int indentation = 0;
		
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '{') {
				printTab(indentation);
				System.out.println(s.charAt(i));
				indentation++;
			} else if (s.charAt(i) == '[') {
				if (!t.isEmpty()) {
					printTab(indentation);
					System.out.print(t);
					t = "";
				}
				System.out.println(s.charAt(i));
				indentation++;
			} else if (s.charAt(i) == '}' || s.charAt(i) == ']') {
				if (!t.isEmpty()) {
					printTab(indentation);
					System.out.println(t);
					t = "";
				}
				indentation--;
				printTab(indentation);
				System.out.println(s.charAt(i));
			} else if (s.charAt(i) != ' ') {
				t += s.charAt(i);
				if (s.charAt(i) == ',') {
					printTab(indentation);
					System.out.println(t);
					t = "";
				}
			}
		}
	}
	
	public void formatJson(String s) {
		int indentation = 0;
		char c;
		for (int i = 0; i < s.length(); i++) {
			c = s.charAt(i);
			
			if (c != ' ' && c != '}' && c != ']')	System.out.print(c);
			
			
			if (c == '{' || c == '[') {
				System.out.println();
				indentation++;
				printTab(indentation);
			} else if (c == '}' || c == ']') {
				System.out.println();
				indentation--;
				printTab(indentation);
				System.out.print(c);
			} else if (c == ',') {
				System.out.println();
				printTab(indentation);
			}
		}
	}
	
	public void printTab(int n) {
		for (int i = 0; i < n; i++) {
			System.out.print("  ");
		}
	}
	
	public static void main(String[] args) {
		//String k = "\"";
		String s = "[1, 2, {\"a\" : \"asdf\", \"b\":[23, 45]}]";
		PrintJson a = new PrintJson();
		a.formatJson(s);
	}
}
