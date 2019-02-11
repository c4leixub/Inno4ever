package com.abb.abb;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TravelBuddy {

	class Buddy implements Comparable<Buddy> {
		String name;
		int similarity;
		Set<String> wishList;

		public Buddy(String name, int similarity, Set<String> wishList) {
			super();
			this.name = name;
			this.similarity = similarity;
			this.wishList = wishList;
		}

		@Override
		public int compareTo(Buddy o) {
			return this.similarity - o.similarity;
		}
	}

	private List<Buddy> buddies;
	private Set<String> myWishList;

	public TravelBuddy(Set<String> myWishList, Map<String, Set<String>> friendsWishList) {
		this.buddies = new ArrayList<>();
		this.myWishList = myWishList;
		for (String name : friendsWishList.keySet()) {
			// compute the common wish places
			Set<String> wishList = friendsWishList.get(name);
			Set<String> intersection = new HashSet<>(wishList);
			intersection.retainAll(myWishList);

			int similarity = intersection.size();
			if (similarity >= wishList.size() / 2) {
				buddies.add(new Buddy(name, similarity, wishList));
			}
		}
	}

	/*
	 * 每个人都有一些想去的city，如果你想去的city和另一个人想去的city的相似度高于 50%的话你们就 是travel
	 * buddy，叫你ouput一个list of travel buddy按相似度从高往低排序
	 */
	public List<Buddy> getSortedBuddies() {
		Collections.sort(buddies);
		return new ArrayList<>(buddies);
	}

	/*
	 * 是给了一个k值，找出你的buddy的wishlist里不在你的wishlist里的最多max个城市 
	 * 根据buddy和你的重合程度来排序
	 */
	public List<String> getRecommentCities(int k) {
		List<String> res = new ArrayList<String>();
		List<Buddy> budiess = getSortedBuddies();

		int i = 0;
		while (res.size() < k && i < budiess.size()) {
			Set<String> diff = new HashSet<>(buddies.get(i).wishList);
			diff.removeAll(myWishList);

			if (res.size() + diff.size() <= k) {
				res.addAll(diff);
				i++;
			} else {
				for (String wish : diff) {
					res.add(wish);
					if (res.size() == k)
						break;
				}
			}
		}

		return res;
	}

}
