package com.abb.abb;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
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
			return o.similarity - this.similarity;
		}
		
		public String toString() {
			return name;
		}
	}

	private List<Buddy> buddies;
	private Set<String> myWishList;

	/**
	 * Everyone has a wish list of cities, if the cities you wish and other's wish cities match 50% 
	 * then the other is your travel buddy.
	 * @param myWishList
	 * @param friendsWishList
	 */
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
	 * followup: recommend at most k cities
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
	
	public static void main(String[] args) {
		Set<String> myWishList = new HashSet<>();
		myWishList.add("a");
		myWishList.add("b");
		myWishList.add("c");
		myWishList.add("d");
		
		Set<String> wishList;
		Map<String, Set<String>> friendsWishList = new HashMap<String, Set<String>>();
		
		wishList = new HashSet<>();
		wishList.add("a");
		wishList.add("b");
		wishList.add("e");
		wishList.add("f");
		friendsWishList.put("B1", wishList);
		
		wishList = new HashSet<>();
		wishList.add("a");
		wishList.add("c");
		wishList.add("d");
		wishList.add("g");
		friendsWishList.put("B2", wishList);
		
		TravelBuddy t = new TravelBuddy(myWishList, friendsWishList);
		System.out.println(t.getSortedBuddies());
		
		System.out.println(t.getRecommentCities(10));
	}

}
