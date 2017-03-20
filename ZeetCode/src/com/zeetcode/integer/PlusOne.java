package com.zeetcode.integer;

import java.util.ArrayList;
import java.util.Arrays;

public class PlusOne {
	public int[] plusOne(int[] digits) {
        int i = digits.length -1;
        int plus = (digits[i] + 1) / 10;
        digits[i] = (digits[i] + 1) % 10;
        if (plus == 0) {
            return digits;
        }
        i--;
        
        int tmp;
        while (i >= 0) {
            tmp = (digits[i] + plus) / 10;
            digits[i] = (digits[i] + plus) % 10;
            plus = tmp;
            if (plus == 0) {
                return digits;
            }
            i--;
        }
        
        if (plus != 0) {
            int[] re = new int[digits.length+1];
            re[0] = plus;
            for (int j = 0; j < digits.length; j++) {
                re[j+1] = digits[j];
            }
            return re;
        }
        
        return digits;
    }
	
	public int[] plusONE(int[] digits) {
		if (digits == null)	return null;
		
		boolean isAllNine = true;
		for (int i = 0; i < digits.length; i++) {
			if (digits[i] != 9) {
				isAllNine = false;
				break;
			}
		}
		
		if (isAllNine) {
			int[] re = new int[digits.length+1];
			re[0] = 1;
			return re;
		}
		
		int i = digits.length -1;
        digits[i] = digits[i] + 1;
        
        while (digits[i] / 10 != 0) {
        	digits[i-1] = digits[i-1] + (digits[i] / 10);
        	digits[i] = digits[i] % 10;
        	i--;
        }
       
		
		return digits;
	}
	
	public static ArrayList<Integer> incrementArrayInt(ArrayList<Integer> array) {
	    if (array == null) {
	        return null;
	    }
	          
	    if (array.size() == 0) {
	        array.add(new Integer(1));
	        return array;
	    }
	      
	    int i = 0;
	    array.set(i, array.get(i)+1);
	      
	    while ((array.get(i) / 10) != 0) {
	    	if (i+1 < array.size()) {
	            array.set(i+1, array.get(i+1)+ ((array.get(i) / 10)));
	        } else if ((array.get(i) / 10) > 0) {
	            array.add((array.get(i) / 10));
	        }
	    	
	        array.set(i, array.get(i)%10);
	        i++;
	    }
	    
	      
	    return array;
	  }
	
	private static final ArrayList<Integer> ZERO = new ArrayList<Integer>(Arrays.asList(new Integer(0)));
	
	public static void main(String[] args) {
		ArrayList<Integer> array = new ArrayList<Integer>();
		array.add(9);
		array.add(9);
		System.out.println(incrementArrayInt(array));
	}
	

}
