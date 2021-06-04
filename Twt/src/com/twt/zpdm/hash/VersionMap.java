package com.twt.zpdm.hash;

import java.util.*;

public class VersionMap<Key, Value> {
	
	Map<Key, List<Value>> map;
	
	public VersionMap() {
		map = new HashMap<>();
	}
	
	public Value get(Key key) {
		List<Value> vals = map.get(key);
		if (vals == null || vals.size() == 0) {
			return null;
		}
		return vals.get(vals.size()-1);
	}
	
	public void put(Key key, Value val) {
		List<Value> vals = map.get(key);
		if (vals == null) {
			vals = new ArrayList<>();
			map.put(key, vals);
		}
		vals.add(val);
	}
	
	public Value getAtVersion(Key key, int version) {
		List<Value> vals = map.get(key);
		if (vals == null || vals.size() == 0 || version >= vals.size()) {
			return null;
		}
		return vals.get(version);
	}
}
