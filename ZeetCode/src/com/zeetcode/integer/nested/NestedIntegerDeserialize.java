package com.zeetcode.integer.nested;

import java.util.List;
import java.util.Stack;

public class NestedIntegerDeserialize {
	public NestedInteger deserialize(String s) {

		Stack<String> stack = new Stack<String>();
		Stack<NestedInteger> nestedIntStack = new Stack<NestedInteger>();

		NestedInteger root = new NestedIntegerImpl();
		stack.add(s);
		nestedIntStack.add(root);

		String top;
		NestedInteger nestedInt;
		while (!stack.isEmpty()) {
			top = stack.pop();
			nestedInt = nestedIntStack.pop();

			if (top.charAt(0) == '[' && top.charAt(top.length() - 1) == ']') {
				String[] e = top.substring(1, top.length() - 1).split(",");

				for (int i = 0; i < e.length; i++) {
					nestedInt.add(new NestedIntegerImpl());
				}

				List<NestedInteger> list = nestedInt.getList();
				for (int i = list.size() - 1; i >= 0; i--) {
					nestedIntStack.push(list.get(i));
					stack.push(e[i]);
				}

			} else {
				nestedInt.setInteger(Integer.parseInt(top));
			}
		}

		return root;
	}
	
	public static void main(String[] args) {
		String s = "[123,[456,[789]]]";
		NestedIntegerDeserialize d = new NestedIntegerDeserialize();
		d.deserialize(s);
	}
}
