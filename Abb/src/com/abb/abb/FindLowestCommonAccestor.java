package com.abb.abb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * input是
 * [['earth', 'north america', 'south america'],
 * ['south america','brazil', 'arginta'], ['north america', 'united states', 'canada'],
 * ['united states', 'california', 'new york'], ['california', 'San francisco','Oakland']]
 * 意思是对于每一row 第一项是后几位的parent 然后给你这个map 和两个城市 找到他们的LCA example: 'new
 * york' 和 'oakland' 就是 united states

 */
public class FindLowestCommonAccestor {

	Map<String, String> childToParent;

	public FindLowestCommonAccestor(List<List<String>> lists) {
		this.childToParent = new HashMap<String, String>();
		if (lists == null || lists.size() == 0) {
			return;
		}
		for (List<String> list : lists) {
			String par = list.get(0);
			String s1 = list.get(1);
			String s2 = list.get(2);
			childToParent.put(s1, par);
			childToParent.put(s2, par);
		}
	}

	public String getLCA(String s1, String s2) {
		if (s1 == null || s2 == null) {
			return null;
		}

		String p = s1;
		Set<String> ancesstor = new HashSet<String>();
		while (childToParent.get(p) != null) {
			ancesstor.add(p);
			p = childToParent.get(p);
		}
		ancesstor.add(p);

		p = s2;
		while (!ancesstor.contains(p)) {
			p = childToParent.get(p);
			if (p == null) {
				return null;
			}
		}

		return p;
	}

	public static void main(String[] args) {
		List<List<String>> lists = new ArrayList();
		lists.add(Arrays.asList(new String[] { "earth", "north america", "south america" }));
		lists.add(Arrays.asList(new String[] { "south america", "brazil", "arginta" }));
		lists.add(Arrays.asList(new String[] { "north america", "united states", "canada" }));
		lists.add(Arrays.asList(new String[] { "united states", "california", "new york" }));
		lists.add(Arrays.asList(new String[] { "california", "san francisco", "oakland" }));

		FindLowestCommonAccestor fca = new FindLowestCommonAccestor(lists);
		System.out.println(fca.getLCA("new york", "brazil"));
	}
}
