package com.zeetcode.string.number;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
 */
public class StrobogrammaticNumber {
	public boolean isStrobogrammatic(String num) {
		if (num == null || num.length() == 0) {
			return false;
		}
		
		int i = 0;
		int j = num.length() - 1;
		while (i <= j) {
			if ((num.charAt(i) == '6' && num.charAt(j) == '9')
					|| (num.charAt(i) == '9' && num.charAt(j) == '6')
					|| (num.charAt(i) == '8' && num.charAt(j) == '8')
					|| (num.charAt(i) == '0' && num.charAt(i) == num.charAt(j))
					|| (num.charAt(i) == '1' && num.charAt(i) == num.charAt(j))) {

				i++;
				j--;
			} else {
				return false;
			}
		}

		return true;
	}
	
	int[][] digits = new int[][] {{0, 0}, {1, 1}, {6, 9}, {8, 8}, {9, 6}};
    
    public List<String> findStrobogrammatic(int n) {
        if (n < 0) {
            return new ArrayList<String>();
        }
        
        return findStrobogrammatic(n, false);
    }
    
    public List<String> findStrobogrammatic(int n, boolean addZero) {
        if (n == 0) {
            return Arrays.asList("");
        } else if (n == 1) {
            return Arrays.asList("0", "1", "8");
        }
        
        List<String> pre = findStrobogrammatic(n-2, true);
        List<String> result = new ArrayList<String>();
        StringBuilder sb;
        for (String s : pre) {
            for (int i = addZero ? 0 : 1; i < digits.length; i++) {
                sb = new StringBuilder();
                sb.append(digits[i][0]);
                sb.append(s);
                sb.append(digits[i][1]);
                result.add(sb.toString());
            }
        }
        
        return result;
    }
}
