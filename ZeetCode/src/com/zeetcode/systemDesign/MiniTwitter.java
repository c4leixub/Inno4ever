package com.zeetcode.systemDesign;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class MiniTwitter {

	public class TweetNode {
		public long timestamp;
		public Tweet tweet;
		public TweetNode next;
	}

	private Map<Integer, TweetNode> idToTweets;

	private Map<Integer, Set<Integer>> idToFollows;
	private Map<Integer, Set<Integer>> idToFollower;

	public MiniTwitter() {
		idToTweets = new HashMap<Integer, TweetNode>();

		idToFollows = new HashMap<Integer, Set<Integer>>();
		idToFollower = new HashMap<Integer, Set<Integer>>();
	}

	/*
	 * @param user_id: An integer
	 * 
	 * @param tweet_text: a string
	 * 
	 * @return: a tweet
	 */
	public Tweet postTweet(int user_id, String tweet_text) {
		TweetNode node = new TweetNode();
		node.timestamp = System.currentTimeMillis();
		node.tweet = Tweet.create(user_id, tweet_text);
		
		if (idToTweets.containsKey(user_id)) {
			node.next = idToTweets.get(user_id);
		}
		idToTweets.put(user_id, node);

		return node.tweet;
	}

	/*
	 * @param user_id: An integer
	 * 
	 * @return: a list of 10 new feeds recently and sort by timeline
	 */
	public List<Tweet> getNewsFeed(int user_id) {
		List<Tweet> newsFeed = new ArrayList<Tweet>();
		PriorityQueue<TweetNode> queue = new PriorityQueue<TweetNode>(new Comparator<TweetNode>() {

			@Override
			public int compare(TweetNode o1, TweetNode o2) {
				if (o1.timestamp > o2.timestamp) {
					return -1;
				} else if (o1.timestamp < o2.timestamp) {
					return 1;
				}
				
				return 0;
			}
		});
		
		Set<Integer> follows = idToFollows.get(user_id);
		if (follows == null || follows.isEmpty()) {
			return newsFeed;
		}
		
		for (Integer userId : follows) {
			queue.add(idToTweets.get(userId));
		}
		
		TweetNode node;
		while (newsFeed.size() < 10 && !queue.isEmpty()) {
			node = queue.poll();
			newsFeed.add(node.tweet);
			queue.add(node.next);
		}
		
		return newsFeed;
	}

	/*
	 * @param user_id: An integer
	 * 
	 * @return: a list of 10 new posts recently and sort by timeline
	 */
	public List<Tweet> getTimeline(int user_id) {
		List<Tweet> timeline = new ArrayList<Tweet>();
		TweetNode node = idToTweets.get(user_id);
		
		while (timeline.size() < 10 && node != null) {
			timeline.add(node.tweet);
			node = node.next;
		}
		
		return timeline;
	}

	/*
	 * @param from_user_id: An integer
	 * 
	 * @param to_user_id: An integer
	 * 
	 * @return: nothing
	 */
	public void follow(int from_user_id, int to_user_id) {
		if (!idToFollows.containsKey(from_user_id)) {
			idToFollows.put(from_user_id, new HashSet<Integer>());
		}
		idToFollows.get(from_user_id).add(to_user_id);

//		if (!idToFollower.containsKey(to_user_id)) {
//			idToFollower.put(to_user_id, new HashSet<Integer>());
//		}
//		idToFollower.get(to_user_id).add(from_user_id);
	}

	/*
	 * @param from_user_id: An integer
	 * 
	 * @param to_user_id: An integer
	 * 
	 * @return: nothing
	 */
	public void unfollow(int from_user_id, int to_user_id) {
		if (idToFollows.containsKey(from_user_id)) {
			idToFollows.get(from_user_id).remove(to_user_id);
		}
		// if (idToFollower.containsKey(to_user_id)) {
		// idToFollower.get(to_user_id).remove(from_user_id);
		// }
	}

	public static void main(String[] args) {
		PriorityQueue<Integer> p = new PriorityQueue<Integer>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1 - o2;
			}
		});
		p.add(2);
		p.add(3);
		p.add(1);
		System.out.println(p);
		System.out.println(p.poll());
	}
}
