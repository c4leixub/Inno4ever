package com.twt.zoa;

import java.util.*;

public class GameEvent {

	class Event implements Comparable<Event> {
		public String teamName;
		public String playerName;
		public String timeString;
		public int actualTime;
		public String substituteName;
		public Character eventType;
		public boolean isFirstHalf;

		public Event(String teamName, String playerName, String timeString, int actualTime, String substituteName,
				Character eventType, boolean isFirstHalf) {
			this.teamName = teamName;
			this.playerName = playerName;
			this.timeString = timeString;
			this.actualTime = actualTime;
			this.substituteName = substituteName;
			this.eventType = eventType;
			this.isFirstHalf = isFirstHalf;
		}

		@Override
		public String toString() {
			return "Event [teamName=" + teamName + ", playerName=" + playerName + ", timeString=" + timeString
					+ ", actualTime=" + actualTime + ", substituteName=" + substituteName + ", eventType=" + eventType
					+ ", isFirstHalf=" + isFirstHalf + "]";
		}

		public String getOutputString() {
			return this.teamName + " " + this.playerName + " " + this.timeString + " " + this.eventType
					+ ((this.substituteName != null && !this.substituteName.isEmpty()) ? " " + this.substituteName
							: "");
		}

		@Override
		public int compareTo(Event o) {
			if (this.isFirstHalf == true && o.isFirstHalf == false) {
				return -1;
			}
			if (this.isFirstHalf == false && o.isFirstHalf == true) {
				return 1;
			}

			if (this.actualTime != o.actualTime) {
				return this.actualTime - o.actualTime;
			}
			if (EVENT_MAP.get(eventType) != EVENT_MAP.get(o.eventType)) {
				return EVENT_MAP.get(eventType) - EVENT_MAP.get(o.eventType);
			}

			if (!this.teamName.equals(o.teamName)) {
				return this.teamName.compareTo(o.teamName);
			}
			return this.playerName.compareTo(o.playerName);
		}
	}

	private static Map<Character, Integer> EVENT_MAP = new HashMap<>();
	static {
		EVENT_MAP.put('G', 1);
		EVENT_MAP.put('Y', 2);
		EVENT_MAP.put('R', 3);
		EVENT_MAP.put('S', 4);
	}

	public List<String> getEventsOrder(String team1, String team2, List<String> events1, List<String> events2) {
		List<Event> events = new ArrayList<>();

		for (String e1 : events1) {
			events.add(this.parseString(e1, team1));
		}

		for (String e2 : events2) {
			events.add(this.parseString(e2, team2));
		}

		Collections.sort(events);
		List<String> ans = new ArrayList<>();
		for (Event e : events) {
			ans.add(e.getOutputString().trim());
		}

		return ans;
	}

	private Event parseString(String str, String teamName) {
		String[] words = str.split(" ");

		int timeIndex = 0;
		String playerName = "";
		for (int i = 0; i < words.length; i++) {
			if (words[i].charAt(0) >= '0' && words[i].charAt(0) <= '9') {
				timeIndex = i;
				break;
			} else {
				playerName += " " + words[i];
			}
		}
		playerName.trim();

		String substituteName = null;
		char event = words[timeIndex + 1].charAt(0);
		if (event == 'S') {
			substituteName = "";
			for (int i = timeIndex + 2; i < words.length; i++) {
				substituteName += " " + words[i];
			}
			substituteName.trim();
		}

		int actualTime = 0;
		boolean isFirstHalf = false;
		if (words[timeIndex].contains("+")) {
			String[] timeAndExtra = words[timeIndex].split("\\+");
			actualTime += Integer.parseInt(timeAndExtra[0]);
			isFirstHalf = actualTime <= 45;
			actualTime += Integer.parseInt(timeAndExtra[1]);
		} else {
			actualTime += Integer.parseInt(words[timeIndex]);
			isFirstHalf = actualTime <= 45;
		}

		return new Event(teamName, playerName, words[timeIndex], actualTime, substituteName, event, isFirstHalf);
	}

	public static void main(String[] args) {
		GameEvent g = new GameEvent();

		String team1 = "EDC", team2 = "CDE";
		List<String> events1 = Arrays.asList("Name1 12 G", "FirstName LastName 43 Y");
		List<String> events2 = Arrays.asList("Name3 45+1 S SubName", "CDE Name4 46 G");

		List<String> ans = g.getEventsOrder(team2, team1, events2, events1);
		System.out.println(ans);
	}
}
