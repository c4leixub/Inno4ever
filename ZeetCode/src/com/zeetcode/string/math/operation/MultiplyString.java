package com.zeetcode.string.math.operation;

import java.util.ArrayList;
import java.util.List;

public class MultiplyString {
	public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";
        
        int d1, d2; 
        List<Integer> list = new ArrayList<Integer>();
        int start = 0;
        for (int j = num2.length()-1; j >=0; j--) {
            d2 = num2.charAt(j) - '0';
            
            int k = start, sz = list.size();
            for (int i = num1.length()-1; i >=0; i--) {
                d1 = num1.charAt(i) - '0';
                if (k < sz) {
                    list.set(k, list.get(k) + d1 * d2);
                    k++;
                } else {
                    list.add(d1 * d2); 
                }
            }
            start++;
        }
        
        int sum, carry = 0, r;
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sum = list.get(i) + carry;
            r = sum % 10;
            carry = sum / 10;
            
            res.append(r);
        }
        
        while (carry != 0) {
            r = carry % 10;
            carry = carry / 10;
            res.append(r);
        }
        
        res.reverse();
        return res.toString();
    }
}
