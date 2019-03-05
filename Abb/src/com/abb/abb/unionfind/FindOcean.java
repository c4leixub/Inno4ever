package com.abb.abb.unionfind;

/*
Given: An array of strings where L indicates land and W indicates water, and a coordinate marking a starting point in the middle of the ocean.
Challenge: Find and mark the ocean in the map by changing appropriate Ws to Os. An ocean coordinate is defined to be the initial coordinate if a W, and
any coordinate directly adjacent to any other ocean coordinate.
void findOcean(String[] map, int row, int column);
String[] map = new String[]{ "WWWLLLW", "WWLLLWW", "WLLLLWW"};
printMap(map);	

STDOUT:
WWWLLLW
WWLLLWW
WLLLLWW


findOcean(map, 0, 1); printMap(map);

STDOUT:
OOOLLLW
OOLLLWW
OLLLLWW
 */
public class FindOcean {
	public void findOcean(String[] map, int row, int column) {
		StringBuilder[] sbs = new StringBuilder[map.length];
		for (int i = 0; i < map.length; i++) {
			sbs[i] = new StringBuilder(map[i]);
		}
		
		dfs(sbs, row , column);
		
		for (int i = 0; i < map.length; i++) {
			map[i] = sbs[i].toString();
		}
	}
	
	private void dfs(StringBuilder[] sbs, int i, int j) {
		if (i < 0 || i >= sbs.length || j < 0 || j >= sbs[i].length()
				|| sbs[i].charAt(j) == 'O' || sbs[i].charAt(j) == 'L') {
			return;
		}
		
		sbs[i].setCharAt(j, 'O');
		
		dfs(sbs, i-1, j);
		dfs(sbs, i+1, j);
		dfs(sbs, i, j-1);
		dfs(sbs, i, j+1);
	}
	
	public static void main(String[] args) {
		FindOcean f = new FindOcean();
		String[] map = new String[]{ "WWWLLLW", "WWLLLWW", "WLLLLWW"};
		
		f.findOcean(map, 0, 1);	
		printMap(map);
	}
	
	public static void printMap(String[] map) {
		for (int i = 0; i < map.length; i++) {
			System.out.println(map[i]);
		}
	}
}
