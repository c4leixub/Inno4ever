package com.twt.ltc.math;

/**
 * A move consists of taking a point (x, y) and transforming it to either (x,
 * x+y) or (x+y, y).
 * 
 * Given a starting point (sx, sy) and a target point (tx, ty), return True if
 * and only if a sequence of moves exists to transform the point (sx, sy) to
 * (tx, ty). Otherwise, return False.
 */
public class ReachingPoints {

	// O(2^(tx+ty)), O(tx*ty) the size of call stack
	public boolean reachingPointsNaive(int sx, int sy, int tx, int ty) {

		if (sx > tx || sy > ty)
			return false;
		if (sx == tx && sy == ty)
			return true;

		return reachingPoints(sx + sy, sy, tx, ty) || reachingPoints(sx, sx + sy, tx, ty);
	}

	/*
	 * Every parent point (x, y) has two children, (x, x+y) and (x+y, y). However,
	 * every point (x, y) only has one parent candidate (x-y, y) if x >= y, else (x,
	 * y-x). This is because we never have points with negative coordinates.
	 * 
	 * Looking at previous successive parents of the target point, we can find
	 * whether the starting point was an ancestor. For example, if the target point
	 * is (19, 12), the successive parents must have been (7, 12), (7, 5), and (2,
	 * 5); so (2, 5) is a starting point of (19, 12).
	 * 
	 * O(max(tx,ty)) If say ty = 1, we could be subtracting tx times, O(1)
	 */
	public boolean reachingPointsBackWard(int sx, int sy, int tx, int ty) {
		while (tx >= sx && ty >= sy) {
			if (sx == tx && sy == ty)
				return true;
			if (tx > ty)
				tx -= ty;
			else
				ty -= tx;
		}
		return false;
	}

	/*
	 * Say tx > ty. We know that the next parent operations will be to subtract ty
	 * from tx, until such time that tx = tx % ty. When both tx > ty and ty > sy, we
	 * can perform all these parent operations in one step, replacing while tx > ty:
	 * tx -= ty with tx %= ty.
	 * 
	 * Otherwise, if say tx > ty and ty <= sy, then we know ty will not be changing
	 * (it can only decrease). Thus, only tx will change, and it can only change by
	 * subtracting by ty. Hence, (tx - sx) % ty == 0 is a necessary and sufficient
	 * condition for the problem's answer to be True.
	 * 
	 * The analysis above was for the case tx > ty, but the case ty > tx is similar.
	 * When tx == ty, no more moves can be made.
	 * 
	 * O(log(max(tx,ty))), The analysis is similar to the analysis of the Euclidean
	 * algorithm, and we assume that the modulo operation can be done in O(1)O(1)
	 * time. 
	 * 
	 * O(1)
	 */
	public boolean reachingPoints(int sx, int sy, int tx, int ty) {

		while (tx >= sx && ty >= sy) {
			if (tx == ty)
				break;
			if (tx > ty) {
				if (ty > sy)
					tx %= ty;
				else
					return (tx - sx) % ty == 0;
			} else {
				if (tx > sx)
					ty %= tx;
				else
					return (ty - sy) % tx == 0;
			}
		}

		return (tx == sx && ty == sy);
	}
}
