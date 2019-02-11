package com.lkin.string.validation;

public class ValidIPAddress {
	public String validIPAddress(String IP) {
		if (IP == null || IP.isEmpty()) {
			return "Neither";
		}

		if (IP.contains(":")) {
			return validIPV6(IP) ? "IPv6" : "Neither";
		}

		return validIPV4(IP) ? "IPv4" : "Neither";
	}

	private boolean validIPV6(String IP) {
		String[] arr = IP.split(":");
		if (arr.length != 8) {
			return false;
		}
		
		char c;
		for (String s : arr) {
			if (s.isEmpty() || s.length() > 4) {
				return false;
			}
			
			long num = 0, base;
			for (int i = 0; i < s.length(); i++) {
				c = s.charAt(i);
				if (Character.isDigit(c)) {
					base = (c - '0');
				} else if (Character.isLetter(c) && 'a' <= c && c <= 'f') {
					base = 10 + (c - 'a');
				} else if (Character.isLetter(c) && 'A' <= c && c <= 'F') {
					base = 10 + (c - 'A');
				} else {
					return false;
				}
				
				num = num * 16 + base;
			}
			
			if (0 > num || num > Integer.MAX_VALUE) {
				return false;
			}
		}
		
		return true;
	}

	private boolean validIPV4(String IP) {
		String[] arr = IP.split("\\.");
		if (arr.length != 4) {
			return false;
		}

		char c;
		for (String s : arr) {
			if (s.isEmpty()) {
				return false;
			} else if (s.charAt(0) == '0' && s.length() > 1) {
				return false;
			}

			int num = 0;
			for (int i = 0; i < s.length(); i++) {
				c = s.charAt(i);
				if (Character.isDigit(c)) {
					num = num * 10 + (c - '0');
				} else {
					return false;
				}
			}

			if (num > 255) {
				return false;
			}
		}

		return true;
	}
	
	public static void main(String[] args) {
		String IP = "172.16.254.1";
		ValidIPAddress v = new ValidIPAddress();
		//System.out.println(v.validIPAddress(IP));
		
		IP = "2001:db8:85a3:0:0:8A2E:0370:7334";
		System.out.println(v.validIPAddress(IP));
		
		IP = "2001:0db8:85a3:0:0:8A2E:0370:7334:";
		System.out.println(v.validIPAddress(IP));
	}
}
