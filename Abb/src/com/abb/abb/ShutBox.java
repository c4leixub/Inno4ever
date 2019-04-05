package com.abb.abb;

import java.util.Random;

public class ShutBox {
	
	private Random dice1;
	private Random dice2;
	
	private boolean[] isTileFliped;
	private int tileSum;
	
	public ShutBox() {
		dice1 = new Random();
		dice2 = new Random();
		
		isTileFliped = new boolean[10]; // do not access isTileFliped[10]
		tileSum = 45;
	}
	
	private boolean hasWon() {
		/*for (int i = 0; i < tiles.length; i++) {
			if (tiles[i] == 0) {
				return false;
			}
		}
		return true;	// all equal to 1, someone win */
		return tileSum == 0;
	}
	
	public boolean play() {
		int d1 = (dice1.nextInt(9) + 1), d2 = (dice2.nextInt(9) + 1);
		int sum = d1 + d2;
		
		if (sum % 2 != 0) {
			d1 = sum / 2;
			d2 = sum / 2 + 1;
		} else {
			d1 = sum / 2;
			d2 = sum / 2;
		}
		
		while (1 <= d1 && d2 <= 9) {
			if (!isTileFliped[d1] && !isTileFliped[d2]) {
				flip(d1, d2);
				return true;
			}
			d1--;
			d2++;
		}
		
		return false;
	}
	
	private void flip(int i, int j) {
		if (i == j) {
			isTileFliped[i] = true;
			tileSum -= i;
		} else {
			isTileFliped[i] = true;
			isTileFliped[j] = true;
			tileSum -= (i+j);
		}
	}
	
	public void similuate(int player) {
		
		int num;
		while (true) {
			for (int i = 0; i < player; i++) {
				num = (i % player + 1);
				if (play()) {
					System.out.println("Player " + num + " flips.");
				} else {
					System.out.println("Player " + num + " idle.");
				}
				
				if (hasWon()) {
					System.out.println("Player " + num + " win.");
					return;
				}
			}
		}
	}
	
	public void dfs() {
		
		
	}
	
	public static void main(String[] args) {
		ShutBox box = new ShutBox();
		box.similuate(2);
	}
}
