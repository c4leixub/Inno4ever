package com.zeetcode.binarysearch;


public class SmallestRecEncloseBlackPixels {
	
	public int minArea(char[][] image, int x, int y) {
		 int x1 = x, y1 = y, x2 = x, y2 = y;
		 for (int i = 0; i < image.length; i++) {
			 for (int j = 0; j < image[0].length; j++) {
				 if (image[i][j] == '1') {
					 x1 = Math.min(x1, i);
					 y1 = Math.min(y1, j);
			
					 x2 = Math.max(x2, i);
					 y2 = Math.max(y2, j);
				 }
			 }
		 }

		return (x2 - x1 + 1) * (y2 - y1 + 1);
	}
	
	public int minAreaBinary(char[][] image, int x, int y) {
		if (image == null || image.length == 0) {
			return 0;
		}

		int row = image.length, col = image[0].length;

		int left = binarySearch(image, 0, y, 0, row, true, true);

		int right = binarySearch(image, y + 1, col, 0, row, true, false);

		int top = binarySearch(image, 0, x, left, right, false, true);

		int bottom = binarySearch(image, x + 1, row, left, right, false, false);

		return (right - left) * (bottom - top);


		
//		int left = binarySearchStart(image, 0, y, 0, row, true);
//		int right = binarySearchEnd(image, y, col-1, 0, row, true);
//		int top = binarySearchStart(image, 0, x, left, right+1, false);
//		int bottom = binarySearchEnd(image, x, row-1, left, right+1, false);
//		return (right - left + 1) * (bottom - top + 1);
	}

	private int binarySearch(char[][] image, int s, int e, int min, int max,
			boolean isColumnSearch, boolean opt) {
		while (s < e) {
			int m = s + (e - s) / 2;

			boolean hasBlackPixel = false;
			for (int k = min; k < max; k++) {
				if ((isColumnSearch && image[k][m] == '1')
						|| (!isColumnSearch && image[m][k] == '1')) {
					hasBlackPixel = true;
					break;
				}
			}

			if (hasBlackPixel == opt) {
				e = m;
			} else {
				s = m + 1;
			}
		}

		return s;
	}

	private int binarySearchStart(char[][] image, int s, int e, int min, int max,
			boolean isColumnSearch) {
		while (s < e) {
			int m = s + (e - s) / 2;

			boolean hasBlackPixel = false;
			for (int k = min; k < max; k++) {
				if ((isColumnSearch && image[k][m] == '1')
						|| (!isColumnSearch && image[m][k] == '1')) {
					hasBlackPixel = true;
					break;
				}
			}

			if (hasBlackPixel) {
				e = m;
			} else {
				s = m + 1;
			}
		}

		return s;
	}

	private int binarySearchEnd(char[][] image, int s, int e, int min, int max,
			boolean isColumnSearch) {
		while (s + 1 < e) {
			int m = s + (e - s) / 2;

			boolean hasBlackPixel = false;
			for (int k = min; k < max; k++) {
				if ((isColumnSearch && image[k][m] == '1')
						|| (!isColumnSearch && image[m][k] == '1')) {
					hasBlackPixel = true;
					break;
				}
			}

			if (hasBlackPixel) {
				s = m;
			} else {
				e = m - 1;
			}
		}

		boolean hasBlackPixel = false;
		for (int k = min; k < max; k++) {
			if ((isColumnSearch && image[k][e] == '1')
					|| (!isColumnSearch && image[e][k] == '1')) {
				hasBlackPixel = true;
				break;
			}
		}

		if (hasBlackPixel)
			return e;
		return s;
	}

	public static void main(String[] args) {
		char[][] image = new char[][] { "0010".toCharArray(),
				"0110".toCharArray(), "0100".toCharArray() };
		int x = 0, y = 2;
		SmallestRecEncloseBlackPixels s = new SmallestRecEncloseBlackPixels();
		System.out.println(s.minArea(image, x, y));

	}

}
