package com.abb.abb;

import java.util.HashMap;
import java.util.Map;

public class PathSystemTrie {
	
	class TrieNode {
		Map<String, TrieNode> dirs = new HashMap<String, TrieNode>();
		String name;
		Integer value;
		Runnable callback;
		
		public TrieNode(String s, int v) {
			name = s;
			value = v;
		}
	}
	
	private TrieNode root;
	
	public PathSystemTrie() {
		root = new TrieNode("", 0);
	}
	
	private TrieNode getLastParentNode(String path) {
		TrieNode p = root;
		String[] dirs = path.split("\\/");
		int i = 1;
		while (i < dirs.length - 1) {
			String dir = dirs[i];
			if (p.dirs.containsKey(dir)) {
				p = p.dirs.get(dir);
				if (p.callback != null) {
					p.callback.run();
				}
			} else {
				return null;
			}
			i++;
		}
		
		return p;
	}
	
	public boolean create(String path, int value) {
		TrieNode p = getLastParentNode(path);
		if (p == null) {
			return false;
		}
		
		int lastSlashIndex = path.lastIndexOf("/");
		String newDir = path.substring(lastSlashIndex + 1);
		p.dirs.put(newDir, new TrieNode(newDir, value));
		return true;
	}
	
	public boolean set(String path, int value) {
		TrieNode p = getLastParentNode(path);
		
		int lastSlashIndex = path.lastIndexOf("/");
		String dir = path.substring(lastSlashIndex + 1);
		if (p == null || !p.dirs.containsKey(dir)) {
			return false;
		}
		
		TrieNode node = p.dirs.get(dir);
		node.value = value;
		
		/*	run the callback if needed	
		if (node.callback != null) {
			node.callback.run();
		} */
		
		return true;
	}
	
	public Integer get(String path) {
		TrieNode p = getLastParentNode(path);
		
		int lastSlashIndex = path.lastIndexOf("/");
		String dir = path.substring(lastSlashIndex + 1);
		if (p == null || !p.dirs.containsKey(dir)) {
			return null;
		}
		
		return p.dirs.get(dir).value;
	}
	
	public boolean watch(String path, Runnable callback) {
		TrieNode p = getLastParentNode(path);
		
		int lastSlashIndex = path.lastIndexOf("/");
		String dir = path.substring(lastSlashIndex + 1);
		if (p == null || !p.dirs.containsKey(dir)) {
			return false;
		}
		
		p.dirs.get(dir).callback = callback;
		return true;
	}
	
	public static void main(String[] args) {
		PathSystemTrie s = new PathSystemTrie();
		System.out.println(s.create("/a",1));
		System.out.println(s.get("/a"));
		System.out.println(s.create("/a/b",2));
		System.out.println(s.get("/a/b"));
		System.out.println(s.create("/c/d",1));
		System.out.println(s.get("/c"));
	}
	
}
