package com.twt.string;

public class MaskPhoneOrEmail {
	public String maskPII(String s) {

		int atIndex = s.indexOf("@");
		if (atIndex >= 0) { // email
			return s.substring(0, 1).toLowerCase() + "*****" + s.substring(atIndex - 1).toLowerCase();
		} else { // phone
			
			
			String digits = s.replaceAll("\\D+", "");	// remove non-digit chars
			String local = "***-***-" + digits.substring(digits.length() - 4);
			
			if (digits.length() == 10)
				return local;
			
			String ans = "+";
			for (int i = 0; i < digits.length() - 10; ++i)
				ans += "*";
			
			return ans + "-" + local;
		}
	}
	
	public static void main(String[] args) {
		String s = "86-(10)12345678";
		MaskPhoneOrEmail m = new MaskPhoneOrEmail();
		m.maskPII(s);
	}
}
