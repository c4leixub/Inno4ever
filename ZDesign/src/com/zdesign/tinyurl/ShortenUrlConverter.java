package com.zdesign.tinyurl;


public class ShortenUrlConverter {

	public int shortUrlLength = 6;

	private static final String CHARS = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

	public String toShortUrl(long id) {
		StringBuilder res = new StringBuilder();
		while (id > 0) {
			int digit = (int) (id % 62);
			res.append(CHARS.charAt(digit));
			id /= 62;
		}

		while (res.length() < shortUrlLength) {
			res.append('0');
		}

		return res.reverse().toString();
	}

	public long toId(String shortUrl) {
		long id = 0;
		char c;
		for (int i = 0; i < shortUrl.length(); i++) {
			c = shortUrl.charAt(i);
			if ('0' <= c && c <= '9') {
				id = id * 62 + (c - '0');
			}
			
			if ('a' <= c && c <= 'z') {
				id = id * 62 + (c - 'a') + 10;
			}
			
			if ('A' <= c && c <= 'Z') {
				id = id * 62 + (c - 'A') + 36;
			}
		}
		return id;
	}
	
	public static void main(String[] args) {
		ShortenUrlConverter service = new ShortenUrlConverter();
		
		String shortUrl = service.toShortUrl(1343);
		System.out.println(shortUrl);
		
		System.out.println(service.toId(shortUrl));
		
		System.out.println(Long.MAX_VALUE);
		System.out.println(Math.pow(62, 6) > Long.MAX_VALUE);
	}
}
