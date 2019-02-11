package com.lkin.nestedlist;

import java.util.ArrayList;
import java.util.List;

public class NestedIntegerImpl implements NestedInteger {

	private Integer value = null;
	private List<NestedInteger> values = null;

	public NestedIntegerImpl() {
		values = new ArrayList<NestedInteger>();
	}

	public NestedIntegerImpl(Integer value) {
		super();
		if (value == null)
			values = new ArrayList<NestedInteger>();
		else
			this.value = value;
	}

	public NestedIntegerImpl(List<NestedInteger> values) {
		super();
		this.values = values;
	}

	@Override
	public boolean isInteger() {
		return value != null;
	}

	@Override
	public Integer getInteger() {
		return value;
	}

	@Override
	public List<NestedInteger> getList() {
		return values;
	}

	public String toString() {
		if (isInteger()) return value.toString();
		
		StringBuffer sb = new StringBuffer("{");
		for (NestedInteger e : values) {
			sb.append(e.toString());
			sb.append(",");
		}
		if (sb.length() > 1)	sb.deleteCharAt(sb.length()-1);
		sb.append("}");
		
		return sb.toString();
	}

	@Override
	public void setInteger(int value) {
		this.value = value;
		
	}

	@Override
	public void add(NestedInteger ni) {
		values.add(ni);
	}

}
