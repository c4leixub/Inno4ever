package com.zeetcode.design;

import java.util.HashMap;
import java.util.Map;

public class Logger {

	private static final int MSG_DELAY_TIME = 10;
	private Map<String, Integer> msgToTime;

	/** Initialize your data structure here. */
	public Logger() {
		msgToTime = new HashMap<String, Integer>();
	}

	/**
	 * Returns true if the message should be printed in the given timestamp,
	 * otherwise returns false. If this method returns false, the message will
	 * not be printed. The timestamp is in seconds granularity.
	 */
	public boolean shouldPrintMessage(int timestamp, String message) {
		if (msgToTime.containsKey(message)) {
			if (timestamp < msgToTime.get(message)) {
				return false;
			}
		}

		msgToTime.put(message, timestamp + MSG_DELAY_TIME);
		return true;
	}
}
