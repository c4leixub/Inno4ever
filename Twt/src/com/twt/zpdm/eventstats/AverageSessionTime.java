package com.twt.zpdm.eventstats;

import java.util.*;

public class AverageSessionTime {
	
	enum Action {
		LOGIN, LOGOFF
	}
	
	class Event {
		String userId;
		long timestamp;
		Action action;
	}
	
	long sessionCount = 0L;
	long totalSessionTime = 0L;
	
	Map<String, Long> userIdToLogin = new HashMap<>();	// userId -> login timestamp
	Map<String, Long[]> userIdToCT = new HashMap<>();	// userId -> how many finished session and total time
	
	public void init(List<Event> events) {
		long sessionTime;
		for (Event e : events) {
			if (Action.LOGIN.equals(e.action)) {
				userIdToLogin.put(e.userId, e.timestamp);
			} else {	// logout
				Long[] countAndTime = userIdToCT.get(e.userId);
				if (countAndTime == null) {
					countAndTime = new Long[] {0L, 0L};
					userIdToCT.put(e.userId, countAndTime);
				}
				
				sessionTime = e.timestamp - userIdToLogin.get(e.userId);
				
				countAndTime[0]++;
				countAndTime[1] += sessionTime;
				
				sessionCount++;
				totalSessionTime += sessionTime;
			}
		}
	}
	
	public long averageSessionTime() {
		return totalSessionTime / sessionCount;
	}
	
	public long averageSessionTime(String userId) {
		Long[] countAndTime = userIdToCT.get(userId);
		return countAndTime == null ? 0L : (countAndTime[1] / countAndTime[0]);
	}
	
	public Map<String, Long> averageSessionTimes() {
		
		Map<String, Long> res = new HashMap<>();
		for (Map.Entry<String, Long[]> entry : userIdToCT.entrySet()) {
			res.put(entry.getKey(), entry.getValue()[1] / entry.getValue()[0]);
		}
		
		return res;
	}
	
	
}
