package com.twt.design;

import java.util.*;

public class Twitter {

	int time = 0;

	Map<Integer, LinkedList<Integer[]>> idToTweets;
	Map<Integer, Set<Integer>> idToFollowees; // key follows value

	/** Initialize your data structure here. */
	public Twitter() {
		idToTweets = new HashMap<>();
		idToFollowees = new HashMap<>();
	}

	/** Compose a new tweet. */
	public void postTweet(int userId, int tweetId) {
		LinkedList<Integer[]> tweets = this.idToTweets.get(userId);
		if (tweets == null) {
			tweets = new LinkedList<>();
			this.idToTweets.put(userId, tweets);
		}
		tweets.addFirst(new Integer[] { tweetId, time });
		time++;
	}

	class Node {
		public Integer[] val;
		public Iterator<Integer[]> itr;

		public Node(Integer[] val, Iterator<Integer[]> itr) {
			this.val = val;
			this.itr = itr;
		}
	}

	/**
	 * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in
	 * the news feed must be posted by users who the user followed or by the user
	 * herself. Tweets must be ordered from most recent to least recent.
	 */
	public List<Integer> getNewsFeed(int userId) {
		List<Integer> result = new ArrayList<>();

		PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> Integer.compare(b.val[1], a.val[1]));

		LinkedList<Integer[]> tweets;
		Iterator<Integer[]> itr;
		Integer[] val;

		// create a Node for tweets of given userId
		tweets = idToTweets.get(userId);
		if (tweets != null && !tweets.isEmpty()) {
			itr = tweets.iterator();
			val = itr.next();
			pq.add(new Node(val, itr));
		}

		// add Nodes for tweets of given userId's followees
		Set<Integer> followee = this.idToFollowees.get(userId);
		if (followee != null) {
			for (Integer e : followee) {
				tweets = idToTweets.get(e);
				if (tweets != null && !tweets.isEmpty()) {
					itr = tweets.iterator();
					val = itr.next();
					pq.add(new Node(val, itr));
				}
			}
		}

		// merge to get the recent 10
		Node node;
		while (!pq.isEmpty() && result.size() < 10) {
			node = pq.poll();
			result.add(node.val[0]);
			if (node.itr.hasNext()) {
				node.val = node.itr.next();
				pq.add(node);
			}
		}

		return result;
	}

	/**
	 * Follower follows a followee. If the operation is invalid, it should be a
	 * no-op.
	 */
	public void follow(int followerId, int followeeId) {
		Set<Integer> followee = this.idToFollowees.get(followerId);
		if (followee == null) {
			followee = new HashSet<>();
			this.idToFollowees.put(followerId, followee);
		}
		followee.add(followeeId);
	}

	/**
	 * Follower unfollows a followee. If the operation is invalid, it should be a
	 * no-op.
	 */
	public void unfollow(int followerId, int followeeId) {
		Set<Integer> followee = this.idToFollowees.get(followerId);
		if (followee != null) {
			followee.remove(followeeId);
		}
	}
}
