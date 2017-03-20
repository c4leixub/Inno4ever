package com.zeetcode.math;

import java.util.HashMap;
import java.util.Map;

public class FrationToDecimal {

	public String fractionToDecimal(int numerator, int denominator) {
		if (numerator == 0)
			return "0";
		if (denominator == 0)
			return "";

		StringBuilder result = new StringBuilder();
		if ((numerator > 0 && denominator < 0)
				 || (numerator < 0 && denominator > 0) ){
			result.append("-");
		}

		long num = numerator, den = denominator;
		num = Math.abs(num);
		den = Math.abs(den);

		result.append(num / den);

		long r = num % den;
		if (r == 0) {
			return result.toString();
		}

		result.append('.');
		
		Map<Long, Integer> map = new HashMap<Long, Integer>();
		while (r != 0) {
			if (map.containsKey(r)) {
				// if we see the remainder again, the repeat start
				
				int beg = map.get(r);
				
				String p1 = result.substring(0, beg);
				String p2 = result.substring(beg, result.length());
				return p1 + "(" + p2 + ")";
			}
			
			map.put(r, result.length());
			result.append(r * 10 / den);
			r = r * 10 % den;
		}


		return result.toString();
	}

	public static void main(String[] args) {
		FrationToDecimal f = new FrationToDecimal();
		System.out.println(f.fractionToDecimal(1, 99));

	}

}
