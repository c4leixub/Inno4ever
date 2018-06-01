package com.zeetcode.string.math.operation;

public class AddBinary {
	public String addBinary(String a, String b) {
		StringBuilder res = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1;
        int sum = 0, carry = 0;
        while (i >= 0 && j >= 0) {
            sum = (a.charAt(i) - '0') + (b.charAt(j) - '0') + carry;
            res.append(sum % 2);
            carry = sum / 2;
            
            i--;
            j--;
        }
        
        while (i >= 0) {
            sum = (a.charAt(i) - '0') + carry;
            res.append(sum % 2);
            carry = sum / 2;
            i--;
        }
        
        while (j >= 0) {
            sum = (b.charAt(j) - '0') + carry;
            res.append(sum % 2);
            carry = sum / 2;
            j--;
        }
        
        if (carry > 0) {
            res.append(carry);
        }
        
        res.reverse();
        return res.toString();
	}
}
