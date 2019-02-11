package com.zeetcode.matrix.traversal;

import java.util.HashSet;
import java.util.Set;

public class RobotCleaner {

	interface Robot {
		// Returns true if the cell in front is open and robot moves into the cell.
		// Returns false if the cell in front is blocked and robot stays in the current cell.
		public boolean move();

		// Robot will stay in the same cell after calling turnLeft/turnRight.
		// Each turn will be 90 degrees.
		public void turnLeft();
		public void turnRight();

		// Clean the current cell.
		public void clean();
	}
	
	private int x = 0, y = 0;
	private Set<String> visited = new HashSet<String>();
	private int[][] dirs = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
	int dir = 0;

	public void cleanRoom(Robot robot) {
		String hcode = x + ":" + y;

		if (visited.contains(hcode)) {
			return;
		}

		visited.add(hcode);

		robot.clean();

		for (int i = 0; i < dirs.length; i++) {
			if (robot.move()) {
				x += dirs[dir][0];
				y += dirs[dir][1];
				cleanRoom(robot);

				robot.turnLeft();
				robot.turnLeft();
				robot.move();
				robot.turnRight();
				robot.turnRight();

				x -= dirs[dir][0];
				y -= dirs[dir][1];
			}

			robot.turnRight();
			dir = (dir + 1) % 4;
		}
	}
}
