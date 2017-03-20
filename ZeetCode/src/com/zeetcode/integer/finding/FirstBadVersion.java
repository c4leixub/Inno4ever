package com.zeetcode.integer.finding;

/**
 * Suppose you have n versions [1, 2, ..., n] and 
 * you want to find out the first bad one (assume at least
 * one bad version, which causes all the following ones to be bad.
 * 
 * Given an API bool isBadVersion(version) which will return 
 * whether version is bad. 
 */
public class FirstBadVersion {
	
	// mock isBadVersion API
	private int hiddenEnd = 100;
	private int badVersion = 1;
	public FirstBadVersion(int badVersion, int hiddenEnd) {
		super();
		this.hiddenEnd = hiddenEnd;
		this.badVersion = badVersion;
	}
	public boolean isBadVersion(int n) {	
		if (n >= this.badVersion) {
			return true;
		}
		return false;
	}
	public boolean isBadVersionWithoutBoundary(int n) throws Exception {	
		if (n > hiddenEnd) throw new Exception("");
		return isBadVersion(n);
	}
	// mock isBadVersion API end
	
	public int firstBadVersion(int n) {
        int s = 1;
        int e = n;
        int mid;
        
        while (s < e) {
            mid = s + (e - s) / 2;
            if (isBadVersion(mid)) {
                e = mid;
            } else {
              s = mid + 1;  
            } 
        }
        
        if (isBadVersion(s)) {
            return s;
        }
 
        return e;
    }
	
	public int firstBadVersion_Recursive(int n) {
		return firstBadVersionHelper(1, n);
	}
	public int firstBadVersionHelper(int i, int j) {
		if (i >= j) {
			return i;
		}
		
		int mid = i + (j - i) / 2;
		if (isBadVersion(mid)) {
			return firstBadVersionHelper(i, mid);
		} else {
			return firstBadVersionHelper(mid+1, j);
		}
	}
	
	public int firstBadVersion_WithoutBoundary() {
		int i = 1;
		int j = 1000;
		int window = 1000;
		int result = 0;
		while (result == 0 || !isBadVersion(result)) {
			while (overBoundary(j)) {
				j -= window;
				window = window / 2;
				j += window;
			}
			result = firstBadVersionHelper(i, j);
			i += window;
			j += window;
		}
		
		return result;
	}
	
	public boolean overBoundary(int n) {
		try {
			isBadVersionWithoutBoundary(n);
		} catch (Exception e) {
			return true;
		}
		
		return false;
	}
	
	
	public static void main(String args[]) {
		// all good version, the return value will be last element
		FirstBadVersion a = new FirstBadVersion(Integer.MAX_VALUE, 2000);	
		System.out.println(a.firstBadVersion(20));
		System.out.println(a.firstBadVersion_Recursive(20));
	}
}
