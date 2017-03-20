package com.zeetcode.matrix.traversal;

/**
 * You are given a m x n 2D grid initialized with these three possible values.
-1 - A wall or an obstacle.
0 - A gate.
INF - Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate is less than 2147483647.
Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.
For example, given the 2D grid:
INF  -1  0  INF				3  -1   0   1
INF INF INF  -1	 =>			2   2   1  -1
INF  -1 INF  -1				1  -1   2  -1
  0  -1 INF INF				0  -1   3   4
*/
public class WallAndGate {

	private final static int WALL = -1;
	private final static int GATE = 0;
	private final static int INF = 2147483647;

	public void wallsAndGates(int[][] rooms) {
		if (rooms == null || rooms.length == 0 || rooms[0].length == 0)
			return;

		for (int i = 0; i < rooms.length; i++) {
			for (int j = 0; j < rooms[i].length; j++) {
				if (rooms[i][j] == GATE) {
					fill(rooms, i, j, 0);
				}
			}
		}
	}

	public void fill(int[][] rooms, int i, int j, int distance) {
		int m = rooms.length;
		int n = rooms[0].length;

		if (i < 0 || i >= m || j < 0 || j >= n || rooms[i][j] < distance) {
			return;
		}

		rooms[i][j] = distance;

		fill(rooms, i - 1, j, distance + 1);
		fill(rooms, i, j + 1, distance + 1);
		fill(rooms, i + 1, j, distance + 1);
		fill(rooms, i, j - 1, distance + 1);
	}

	public static void main(String[] args) {
		int[][] rooms = new int[][] { { INF, -1, 0, INF },
				{ INF, INF, INF, -1 }, { INF, -1, INF, -1 },
				{ 0, -1, INF, INF } };
		WallAndGate w = new WallAndGate();
		w.wallsAndGates(rooms);
		System.out.println("FInish");
	}
	
	public static int findMinNumSteps(int[][] maze, int rows, int columns, int exitRow, int exitCol)
	{
	    if (maze == null || rows == 0 || columns == 0) {
	        return -1;
	    }
	    if (exitRow < 0 || exitRow >= rows || exitCol < 0 || exitCol >= columns || maze[exitRow][exitCol] == 1) {
	        return -1;
	    }
        
        int[][] dis = new int[rows][columns]; 
	    for (int i = 0; i < rows; i++) {
	        for (int j = 0; j < columns; j++) {
	            if (maze[i][j] == 0) {
	                dis[i][j] = Integer.MAX_VALUE;
	            } else if (maze[i][j] == 1) {
	                dis[i][j] = -1;
	            }
	        }
	    }
	    
	    fill(dis, rows, columns, exitRow, exitCol, 0);
	    
	    if (dis[0][0] == Integer.MAX_VALUE) {
	        return -1;
	    }
	    return dis[0][0];
	}
	// METHOD SIGNATURE ENDS
	
	public static void fill(int[][] dis, int rows, int columns, int i, int j, int distance) {
	    if (i < 0 || i >= rows || j < 0 || j >= columns || dis[i][j] < distance) {
	        return;
	    }
	    
	    dis[i][j] = distance;
	    
	    fill(dis, rows, columns, i-1, j, distance+1);
	    fill(dis, rows, columns, i+1, j, distance+1);
	    fill(dis, rows, columns, i, j-1, distance+1);
	    fill(dis, rows, columns, i, j+1, distance+1);
	} 
}
