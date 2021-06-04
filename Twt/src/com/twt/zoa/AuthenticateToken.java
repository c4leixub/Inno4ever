package com.twt.zoa;

import java.util.*;
import java.util.Map.Entry;

public class AuthenticateToken {

	private static final int GET_TOKEN = 0;

	public int numberOfToken(int expiryLimit, int[][] commands) {

		Map<Integer, Integer> map = new HashMap<>(); // tokenId -> expireTime
		for (int[] command : commands) {
			if (command[0] == GET_TOKEN) {
				map.put(command[1], command[2] + expiryLimit);
			} else {
				// RESET TOKEN
				Integer expireTime = map.get(command[1]);
				if (expireTime != null) {
					if (expireTime.intValue() >= command[2]) {
						map.put(command[1], command[2] + expiryLimit);
					} else {
						map.remove(command[1]);
					}
				}
			}
		}

		int max = commands[commands.length - 1][2];
		for (Entry<Integer, Integer> e : map.entrySet()) {
			if (e.getValue() < max) {
				map.remove(e.getKey());
			}
		}

		return map.size();
	}

	public static void main(String[] args) {

		AuthenticateToken a = new AuthenticateToken();
		int[][] commands = { { 0, 1, 1 }, { 0, 2, 2 }, { 1, 1, 5 }, { 1, 2, 7 } };

		System.out.println(a.numberOfToken(4, commands));
	}
}
