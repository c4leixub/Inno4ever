package com.zeetcode.binarysearch;

import java.util.HashSet;
import java.util.Set;

public class Heaters {
	public int findRadius(int[] houses, int[] heaters) {
        if (houses == null || houses.length == 0 || heaters == null || heaters.length == 0) {
            return 0;
        }
        
        int radius = 0;
        if (houses[0] < heaters[0]) {
            radius = heaters[0] - houses[0];
        }
        
        Set<Integer> houseSet = new HashSet<Integer>();
        for (int h : houses) {
            houseSet.add(h);
        }
        
        int i = 1;
        while (i < heaters.length) {
            int r = getRadius(heaters[i-1],heaters[i],-1*heaters[i-1],houseSet);
            radius = Math.max(radius, r);
        }
        
        if (houses[houses.length-1] > heaters[heaters.length-1]) {
            radius = Math.max(radius, houses[houses.length-1] - heaters[heaters.length-1]);
        }
        
        return radius;
    }
    
    public int getRadius(int s, int e, int p, Set<Integer> houseSet) {
        if (s > e) return 0;
        
        int m = s + (e - s) / 2;
        if (houseSet.contains(m)) {
            if (p > 0) {
                return p - m;
            }
            return m + p;
        }
        
        return Math.max(getRadius(s, m-1, -s, houseSet), getRadius(m+1, e, e, houseSet));
    }
    
    public static void main(String[] args) {
    	int[] houses = new int[] {1,2,3,4};
    	int[] heaters = new int[] {1,4};
    	
    	Heaters h = new Heaters();
    	System.out.println(h.findRadius(houses, heaters));
    }
}
