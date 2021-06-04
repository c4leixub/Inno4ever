package com.twt.design;

import java.util.NoSuchElementException;

public class Vector2D {
	int[][] vec;
	int i;
	int j;

	public Vector2D(int[][] vec) {
		this.vec = vec;
		i = 0;
		j = 0;
	}

	public int next() {
		if (!hasNext())
			throw new NoSuchElementException();

		int val = vec[i][j];
		j++;
		return val;
	}

	public boolean hasNext() {
		while (i < vec.length && j >= vec[i].length) {
			j = 0;
			i++;
		}

		return i < vec.length;
	}
}
