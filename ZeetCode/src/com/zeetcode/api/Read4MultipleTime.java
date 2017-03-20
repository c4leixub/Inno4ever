package com.zeetcode.api;

public class Read4MultipleTime {
	public int read4(char[] buffer) {
		return 4;
	}

	private char[] buffer = new char[4];
	private int offSet = 0;
	private int readSize = 0;

	public int read(char[] buf, int n) {
		int readByteCount = 0;
		boolean eof = false;
		
		while (readByteCount < n && !eof) {
			if (readSize == 0) {
				readSize = read4(buffer);
				if (readSize < 4) {
					eof = true;
				}
			}
			
			int bytes = Math.min(n - readByteCount, readSize);
			System.arraycopy(buffer, offSet, buf, readByteCount, bytes);
			
			offSet = (offSet + bytes) % 4;
			readSize -= bytes;
			
			readByteCount += bytes;
		}
		return readByteCount;
	}
}
