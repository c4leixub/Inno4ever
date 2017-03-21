package com.zdesign.top;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class TopServiceByTimeImpl implements TopService {

	public static final long FIVE_MINS = 300000;
	
	private long period;
	
	private Queue<Share> shares;
	private Map<String, Integer> urlToCount;
	
	public TopServiceByTimeImpl(long period) {
		this.period = period;
		shares = new LinkedList<Share>();
		
		urlToCount = new HashMap<String, Integer>();
	}
	
	@Override
	public void post(String url) {
		Share head = shares.peek();
		if (head.getTimestamp() + period < System.currentTimeMillis()) {
			shares.poll();
			
			int count = urlToCount.get(head.getShareUrl()) - 1; 
			if (count != 0) {
				urlToCount.put(head.getShareUrl(), count);
			} else {
				urlToCount.remove(head.getShareUrl());
			}
		}
		
		shares.add(new Share(url, System.currentTimeMillis()));
		if (!urlToCount.containsKey(url)) {
			urlToCount.put(url, urlToCount.get(url)+1);
		} else {
			urlToCount.put(url, 1);
		}
		
	}

	@Override
	public List<String> getTop(int size) {
		while (!shares.isEmpty()) {
			Share head = shares.peek();
			if (head.getTimestamp() + period < System.currentTimeMillis()) {
				shares.poll();
				
				int count = urlToCount.get(head.getShareUrl()) - 1; 
				if (count != 0) {
					urlToCount.put(head.getShareUrl(), count);
				} else {
					urlToCount.remove(head.getShareUrl());
				}
			} else {
				break;
			}
		}
		
		PriorityQueue<String> queue = new PriorityQueue<String>(size, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return urlToCount.get(o1) - urlToCount.get(o2);
			}
		});
		
		for (String url : urlToCount.keySet()) {
			if (queue.size() == size) {
				queue.poll();
			}
			queue.add(url);
		}
		
		
		List<String> result = new ArrayList<String>(queue);
		Collections.reverse(result);
		return result;
	}

}
