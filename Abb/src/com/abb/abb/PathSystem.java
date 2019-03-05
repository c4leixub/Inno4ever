package com.abb.abb;

import java.util.HashMap;
import java.util.Map;

/**
 * Implement two functions, create and get, with following behaviour
 * create("/a",1), return true;
 * get("/a"), return 1;
 * create("/a/b",2), return true;
 * get("/a/b"), return 2;
 * create("/c/d",1), return false, '/c' not exist
 * get("/c"), return null, '/c' not exist
 */
public class PathSystem {

	Map<String, Integer> pathMap;
	Map<String, Runnable> callbackMap;

	public PathSystem() {
		pathMap = new HashMap<>();
		pathMap.put("", 0);
		
		callbackMap = new HashMap<>();
	}

	public boolean create(String path, int value) {
		if (pathMap.containsKey(path)) {
			return false;
		}

		int lastSlashIndex = path.lastIndexOf("/");
		String prePath = path.substring(0, lastSlashIndex);
		if (!pathMap.containsKey(prePath)) {
			return false;
		}
		
		triggerCallback(path);

		pathMap.put(path, value);
		return true;
	}

	public boolean set(String path, int value) {
		if (!pathMap.containsKey(path)) {
			return false;
		}
		
		triggerCallback(path);

		pathMap.put(path, value);
		return true;
	}

	public Integer get(String path) {
		return pathMap.get(path);
	}
	
	private void triggerCallback(String path) {
		// trigger callback
		String curPath = path;
		while (curPath.length() > 0) {
			if (callbackMap.containsKey(curPath)) {
				callbackMap.get(curPath).run();
			}
			
			int lastSlashIndex = path.lastIndexOf("/");
			curPath = curPath.substring(0, lastSlashIndex);
		}
	}

	// follow up: 
	public boolean watch(String path, Runnable callback) {
		if (!pathMap.containsKey(path)) {
			return false;
		}

		callbackMap.put(path, callback);
		return true;
	}
	
	
}
