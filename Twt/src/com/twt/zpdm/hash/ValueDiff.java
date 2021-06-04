package com.twt.zpdm.hash;

public class ValueDiff<T> {
	T left;
	T right;

	public ValueDiff(T left, T right) {
		this.left = left;
		this.right = right;
	}

	public T getLeft() {
		return left;
	}

	public T getRight() {
		return right;
	}
}
