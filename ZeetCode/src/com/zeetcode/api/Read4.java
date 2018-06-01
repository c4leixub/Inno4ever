package com.zeetcode.api;


public class Read4 {
	public int read4(char[] buffer) {
		return 4;
	}

	private char[] buffer = new char[4];
	
	public int read(char[] buf, int n) {
		int readBytes = 0;
		boolean eof = false;
		
		while (!eof && readBytes < n) {
			int sz = read4(buffer);
			if (sz < 4)
				eof = true;
			
			int bytes = Math.min(n - readBytes, sz);
			
						// src, srcPos, dest, destPos, length
			System.arraycopy(buffer, 0, buf, readBytes, bytes);
			readBytes += bytes;
		}
		
		return readBytes;
	}
	
	private int offSet = 0;
	private int readSize = 0;
	
	public int readMultiple(char[] buf, int n) {
		int readBytes = 0;
		boolean eof = false;
		
		while (!eof && readBytes < n) {
			if (readSize == 0) {
				readSize = read4(buffer);
				if (readSize < 4) {
					eof = true;
				}
			}
			
			int bytes = Math.min(n - readBytes, readSize);
			System.arraycopy(buffer, offSet, buf, readBytes, bytes);
			
			offSet = (offSet + bytes) % 4;
			readSize -= bytes;
			
			readBytes += bytes;
		}
		return readBytes;
	}
}
