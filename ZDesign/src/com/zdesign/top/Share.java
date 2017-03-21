package com.zdesign.top;

public class Share implements Comparable<Share> {

	private String shareUrl;
	private long timestamp;
	
	public Share(String shareUrl, long timestamp) {
		super();
		this.shareUrl = shareUrl;
		this.timestamp = timestamp;
	}
	public String getShareUrl() {
		return shareUrl;
	}
	public void setShareUrl(String shareUrl) {
		this.shareUrl = shareUrl;
	}
	public long getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
	@Override
	public int compareTo(Share o) {
		if (this.timestamp < o.getTimestamp()) {
			return -1;
		} else if (this.timestamp > o.getTimestamp()) {
			return 1;
		}
		return 0;
	}
	
	
}
