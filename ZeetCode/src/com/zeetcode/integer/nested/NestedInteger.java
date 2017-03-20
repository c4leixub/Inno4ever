package com.zeetcode.integer.nested;

import java.util.List;

public interface NestedInteger {
	public boolean isInteger();
	public Integer getInteger();
	public void setInteger(int value);
	public List<NestedInteger> getList();
	public void add(NestedInteger ni);
}
