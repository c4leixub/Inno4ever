package com.lkin.tree.serialization;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NaryTreeSerialization {

	public String serialize(Node root) {
		StringBuilder sb = new StringBuilder();
		if (root == null) {
			return sb.toString();
		}

		sb.append(root.val);

		List<Node> children = root.children;
		if (children == null || children.isEmpty()) {
			return sb.toString();
		}

		sb.append("[");
		String ch;
		Node child;
		for (int i = 0; i < children.size(); i++) {
			child = children.get(i);
			ch = serialize(child);

			sb.append(ch);
			if (i != children.size() - 1) {
				sb.append(" ");
			}
		}
		sb.append("]");
		return sb.toString();
	}

	public Node deserialize(String data) {
		if (data.isEmpty()) {
			return null;
		}

		Stack<Node> stack = new Stack<Node>();
		Node node;
		int i = 0, num = 0;
		char c;
		while (i < data.length()) {
			c = data.charAt(i);
			if (Character.isDigit(c)) {
				num = num * 10 + (c - '0');
			} else {
				if (Character.isDigit(data.charAt(i - 1))) {
					node = new Node(num, new ArrayList<Node>());
					num = 0;
					stack.add(node);
				}

				if (c == '[') {
					// do nothing
				} else if (c == ']' || c == ' ') {
					node = stack.pop();
					stack.peek().children.add(node);
				}
			}

			i++;
		}

		if (stack.isEmpty()) {
			return new Node(num, new ArrayList<Node>());
		}

		return stack.pop();
	}

	public static void main(String[] args) {
		Node one = new Node(1, new ArrayList<Node>());

		Node three = new Node(3, new ArrayList<Node>());
		three.children.add(new Node(5, null));
		three.children.add(new Node(6, null));

		one.children.add(three);
		one.children.add(new Node(2, null));
		one.children.add(new Node(4, null));

		NaryTreeSerialization n = new NaryTreeSerialization();
		String data = n.serialize(one);
		System.out.println(data);

		Node newRoot = n.deserialize(data);
		System.out.println(n.serialize(newRoot));
	}

	public static void print(Node node) {

	}
}
