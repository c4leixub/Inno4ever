package com.lkin.string.converter;

import java.util.HashMap;

public class RomanConverter {

	public int romanToInt(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}

		HashMap<Character, Integer> m = new HashMap<Character, Integer>();
		m.put('I', 1);
		m.put('V', 5);
		m.put('X', 10);
		m.put('L', 50);
		m.put('C', 100);
		m.put('D', 500);
		m.put('M', 1000);

		int length = s.length();
		int result = m.get(s.charAt(length - 1));
		for (int i = length - 2; i >= 0; i--) {
			if (m.get(s.charAt(i + 1)) <= m.get(s.charAt(i))) {
				result += m.get(s.charAt(i));
			} else {
				result -= m.get(s.charAt(i));
			}
		}
		return result;
	}

	public String intToRoman(int num) {
		if (num <= 0) {
			return "";
		}
		
		int[] nums = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
		String[] symbols = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X",
				"IX", "V", "IV", "I" };
        
        
        StringBuilder res = new StringBuilder();
		int i = 0;
		while (num > 0) {
            int times = num / nums[i];
            num = num - times * nums[i];
            
            while (times > 0) {
                res.append(symbols[i]);
                times--;
            }
            i++;
        }
        
        return res.toString();
	}
}
