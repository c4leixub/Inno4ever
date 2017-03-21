package com.zdesign.top;

import java.util.List;

public interface TopService {
	
	public void post(String url);
	public List<String> getTop(int size);
}
