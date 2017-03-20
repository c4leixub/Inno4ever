package com.zeetcode.design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class Twitter {

	public class Tweet implements Comparable<Tweet> {
				
		public int userId;
		public int tweetId;
		public int timestamp;

		public Tweet(int userId, int tweetId, int timestamp) {
			this.userId = userId;
			this.tweetId = tweetId;
			this.timestamp = timestamp;
		}

		@Override
		public int compareTo(Tweet o) {
			if (this.timestamp > o.timestamp)
				return -1;
			if (this.timestamp < o.timestamp)
				return 1;

			return 0;
		}
	}

	private HashMap<Integer, List<Tweet>> userIdToTweets;
	private HashMap<Integer, Set<Integer>> userFollows;
	private int time = 0;

	/** Initialize your data structure here. */
	public Twitter() {
		userIdToTweets = new HashMap<Integer, List<Tweet>>();
		userFollows = new HashMap<Integer, Set<Integer>>();
	}

	/** Compose a new tweet. */
	public void postTweet(int userId, int tweetId) {
		if (userIdToTweets.containsKey(userId)) {
			userIdToTweets.get(userId).add(new Tweet(userId, tweetId, time++));
		} else {
			List<Tweet> newTweets = new ArrayList<Tweet>();
			newTweets.add(new Tweet(userId, tweetId, time++));
			userIdToTweets.put(userId, newTweets);
		}
	}

	/**
	 * Retrieve the 10 most recent tweet ids in the user's news feed. Each item
	 * in the news feed must be posted by users who the user followed or by the
	 * user herself. Tweets must be ordered from most recent to least recent.
	 */
	public List<Integer> getNewsFeed(int userId) {
		List<Integer> result = new ArrayList<Integer>();

		PriorityQueue<Tweet> q = new PriorityQueue<Tweet>();
		HashMap<Integer, Integer> idToIndex = new HashMap<Integer, Integer>();

		if (userFollows.containsKey(userId)) {
			Set<Integer> follows = userFollows.get(userId);

			for (Integer id : follows) {
				List<Tweet> tweets = userIdToTweets.get(id);
				if (tweets != null && tweets.size() != 0) {
					idToIndex.put(id, tweets.size() - 1);
					q.add(tweets.get(tweets.size() - 1));
				}
			}
		}

		List<Tweet> tweets = userIdToTweets.get(userId);
		if (tweets != null && tweets.size() != 0) {
			idToIndex.put(userId, tweets.size() - 1);
			q.add(tweets.get(tweets.size() - 1));
		}

		while (!q.isEmpty() && result.size() != 10) {
			Tweet tweet = q.poll();
			result.add(tweet.tweetId);

			int index = idToIndex.get(tweet.userId) - 1;
			if (index >= 0) {
				idToIndex.put(tweet.userId, index);
				q.add(userIdToTweets.get(tweet.userId).get(index));
			} else {
				idToIndex.remove(tweet.userId);
			}
		}

		return result;
	}

	/**
	 * Follower follows a followee. If the operation is invalid, it should be a
	 * no-op.
	 */
	public void follow(int followerId, int followeeId) {
		if (followerId == followeeId)
			return;

		if (userFollows.containsKey(followerId)) {
			userFollows.get(followerId).add(followeeId);
		} else {
			Set<Integer> follows = new HashSet<Integer>();
			follows.add(followeeId);
			userFollows.put(followerId, follows);
		}
	}

	/**
	 * Follower unfollows a followee. If the operation is invalid, it should be
	 * a no-op.
	 */
	public void unfollow(int followerId, int followeeId) {
		if (followerId == followeeId)
			return;

		if (userFollows.containsKey(followerId)) {
			userFollows.get(followerId).remove(followeeId);
		}
	}
	
	public static void main(String[] args) {
		Twitter t = new Twitter();
		t.postTweet(1, 5);
		t.follow(1, 2);
		t.follow(2, 1);
		System.out.println(t.getNewsFeed(2));
		t.postTweet(2, 6);
		System.out.println(t.getNewsFeed(1));
		System.out.println(t.getNewsFeed(2));

	}
}

/**
 * Your Twitter object will be instantiated and called as such: Twitter obj =
 * new Twitter(); obj.postTweet(userId,tweetId); List<Integer> param_2 =
 * obj.getNewsFeed(userId); obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
