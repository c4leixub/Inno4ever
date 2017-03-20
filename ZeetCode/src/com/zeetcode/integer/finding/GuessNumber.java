package com.zeetcode.integer.finding;

public class GuessNumber {
	public int n;
	public int pick;
	
	public GuessNumber(int n, int pick) {
		this.n = n;
		this.pick = pick;
	}
	
	public int guess(int i) {
		if (i < pick) return 1;
		if (i > pick) return -1;
		return 0;
	}
	
	public int guessNumber(int n) {
        int i = 1;
        int j = n;
        
        int m = i + (j - i) / 2;
        System.out.println(i + " " + j + " " + m);
        while (guess(m) != 0) {
        	if (guess(m) == 1) {
        		i = m + 1;
            } else {
            	j = m - 1;
            }
            m = i + (j - i) / 2;
            System.out.println(i + " " + j + " " + m);
        }
        
        return m;
    }
	
	public int getMoneyAmount(int n) {
        return n;
    }
	
	public static void main(String[] args) {
		GuessNumber g = new GuessNumber(10, 8);
		System.out.println(g.guessNumber(10));
	}
	
}
