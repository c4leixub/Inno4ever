package com.zeetcode.design;

import java.util.HashSet;
import java.util.LinkedList;

public class SnakeGame {
	// private Character[][] board;
	LinkedList<int[]> snake;

	private int width;
	private int height;

	private int[][] food;
	private int score;

	/**
	 * Initialize your data structure here.
	 * 
	 * @param width
	 *            - screen width
	 * @param height
	 *            - screen height
	 * @param food
	 *            - A list of food positions E.g food = [[1,1], [1,0]] means the
	 *            first food is positioned at [1,1], the second is at [1,0].
	 */
	public SnakeGame(int width, int height, int[][] food) {
		int[] head = new int[] { 0, 0 };
		snake = new LinkedList<int[]>();
		snake.add(head);

		this.width = width;
		this.height = height;

		this.food = food;
		score = 0;
	}

	/**
	 * Moves the snake.
	 * 
	 * @param direction
	 *            - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down
	 * @return The game's score after the move. Return -1 if game over. Game
	 *         over when snake crosses the screen boundary or bites its body.
	 */
	public int move(String direction) {
		int x = snake.getFirst()[0], y = snake.getFirst()[1];
		if ("U".equals(direction)) {
			x--;
		} else if ("L".equals(direction)) {
			y--;
		} else if ("R".equals(direction)) {
			y++;
		} else if ("D".equals(direction)) {
			x++;
		}

		// check out of bound
		if (x < 0 || x >= height || y < 0 || y >= width) {
			return -1;
		}

		// check hit body
		// check from body after head to the body before tail
		for (int i = 1; i < snake.size() - 1; i++) {
			if (snake.get(i)[0] == x && snake.get(i)[1] == y) {
				return -1;
			}
		}

		int[] newHead = new int[] { x, y };
		snake.addFirst(newHead);
		if (score < food.length && x == food[score][0] && y == food[score][1]) {
			score++;
		} else {
			snake.pollLast();
		}

		return score;
	}
    
    public static void main(String[] args) {
    	int w = 3, h = 3;
    	int[][] food = new int[][] {{2,0},{0,0},{0,2},{2,2}};
    	SnakeGame obj = new SnakeGame(w, h, food);
    	
    	System.out.println(obj.move("D"));
    	System.out.println(obj.move("D"));
    	System.out.println(obj.move("R"));
    	System.out.println(obj.move("U"));
    	System.out.println(obj.move("U"));
    	System.out.println(obj.move("L"));
    	System.out.println(obj.move("D"));
    	System.out.println(obj.move("R"));
    	System.out.println(obj.move("R"));
    	System.out.println(obj.move("U"));
    	System.out.println(obj.move("L"));
    	System.out.println(obj.move("D"));

    	
    	HashSet<int[]> snake = new HashSet<int[]>();
    	snake.add(new int[] {1,2});
    	
    	System.out.println(snake.contains(new int[] {1,2}));
    }
}
