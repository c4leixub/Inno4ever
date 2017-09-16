package com.zeetcode.integer.nested;

import java.util.List;
import java.util.Stack;

public class NestedIntegerDeserialize {
	public NestedInteger deserialize(String s) {

		Stack<NestedInteger> stack = new Stack<NestedInteger>();
		String temp = "";

		for (char c : s.toCharArray()) {
			if (c == '[') {
				stack.push(new NestedIntegerImpl());
			} else if (c == ']') {
				if (!temp.equals("")) {
					// add NI to parent
					stack.peek().add(new NestedIntegerImpl(Integer.parseInt(temp)));
					temp = "";
				}

				NestedInteger top = stack.pop();
				if (!stack.empty()) {
					stack.peek().add(top);
				} else {
					return top;
				}

			} else if (c == ',') {
				if (!temp.equals("")) {
					// add NI to parent
					stack.peek().add(new NestedIntegerImpl(Integer.parseInt(temp)));
					temp = "";
				}

			} else {
				temp += c;
			}
		}

		// cases when String is just a integer
		if (!temp.equals("")) {
			return new NestedIntegerImpl(Integer.parseInt(temp));
		}
		
		return null;
	}

	public static void main(String[] args) {
		String s = "[123,[456,[789]]]";
		NestedIntegerDeserialize d = new NestedIntegerDeserialize();
		d.deserialize(s);
	}
}
