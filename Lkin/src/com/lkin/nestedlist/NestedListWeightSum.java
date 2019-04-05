package com.lkin.nestedlist;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NestedListWeightSum {

	/**
	 * The algorithm takes O(N) time, where N is the total number of nested elements
	 * in the input list. For example, the list [ [[[[1]]]], 2 ] contains 4 nested
	 * lists and 2 nested integers (11 and 22), so N=6.
	 * 
	 * In terms of space, at most O(D) recursive calls are placed on the stack,
	 * where D is the maximum level of nesting in the input. For example, D=2 for
	 * the input [[1,1],2,[1,1]], and D=3 for the input [1,[4,[6]]].
	 */
	public int depthSum(List<NestedInteger> nestedList) {
		return depthSum(nestedList, 1);
	}

	private int depthSum(List<NestedInteger> nestedList, int depth) {
		int sum = 0;
		for (int i = 0; i < nestedList.size(); i++) {
			if (nestedList.get(i).isInteger()) {
				sum += nestedList.get(i).getInteger() * depth;
			} else {
				sum += depthSum(nestedList.get(i).getList(), depth + 1);
			}
		}

		return sum;
	}

	public int depthSumInverse(List<NestedInteger> nestedList) {
		return depthSumInverse(nestedList, 0);
	}

	private int depthSumInverse(List<NestedInteger> nestedList, int preSum) {
		int curSum = preSum;
		List<NestedInteger> next = new ArrayList<NestedInteger>();

		for (int i = 0; i < nestedList.size(); i++) {
			if (nestedList.get(i).isInteger()) {
				curSum += nestedList.get(i).getInteger();
			} else {
				next.addAll(nestedList.get(i).getList());
			}
		}

		int listSum = next.isEmpty() ? 0 : depthSumInverse(next, curSum);

		return listSum + curSum;
	}

	private int maxDepth(List<NestedInteger> nestedList, Map<Integer, Integer> depthToSum, int depth) {
		int d = 0;
		for (NestedInteger e : nestedList) {
			if (e.isInteger()) {
				depthToSum.put(depth, depthToSum.getOrDefault(depth, 0) + e.getInteger());
			} else {
				d = Math.max(d, maxDepth(e.getList(), depthToSum, depth + 1));
			}
		}

		return d + 1;
	}
	public int depthInverseWithBucket(List<NestedInteger> nestedList) {
		Map<Integer, Integer> depthToSum = new HashMap<Integer, Integer>();

		int sum = 0;
		int max = maxDepth(nestedList, depthToSum, 1);
		for (int i = max; i >= 1; i--) {
			if (depthToSum.containsKey(i)) {
				sum += (depthToSum.get(i) * (max - i + 1));
			}
		}

		return sum;
	}

	public static void main(String[] args) {

		NestedListWeightSum n = new NestedListWeightSum();
		List<NestedInteger> nestedList = new ArrayList<NestedInteger>();

		List<NestedInteger> tmp = new ArrayList<NestedInteger>();
		tmp.add(new NestedIntegerImpl(1));
		tmp.add(new NestedIntegerImpl(1));
		NestedInteger one = new NestedIntegerImpl(tmp);

		NestedInteger two = new NestedIntegerImpl(2);

		tmp = new ArrayList<NestedInteger>();
		tmp.add(new NestedIntegerImpl(1));
		tmp.add(new NestedIntegerImpl(1));
		NestedInteger three = new NestedIntegerImpl(tmp);

		nestedList.add(one);
		nestedList.add(two);
		nestedList.add(three);

		System.out.println(n.depthInverseWithBucket(nestedList));

	}
}
