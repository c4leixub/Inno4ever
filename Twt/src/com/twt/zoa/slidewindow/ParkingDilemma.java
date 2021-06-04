package com.twt.zoa.slidewindow;

import java.util.Arrays;

/**
 * There are many cars parked in the parking lot. The parking is a straight very
 * long line and a parking slot for every single meter. There are cars parked
 * currently and you want to cover them from the rain by building a roof. The
 * requirement is that at least k cars are covered by the roof.What's the minium
 * length of the roof that would cover k cars?
 * 
 * Example: Input: cars: [2, 10, 8, 17] k: 3 output: 9 Explanation:
 * 
 * a roof of length 9 covering all parking slots from the 2nd one
 * to the 10th one, so covering 3 cars at slots 2, 10, 8, there are no shorter
 * roof that can cover 3 cars, so the answer is 9
 *
 */
public class ParkingDilemma {
	/**
	 * @param cars: integer array of length denoting the parking slots where cars
	 *              are parked
	 * @param k:    integer denoting the number of cars that have to be covered by
	 *              the roof
	 * @return: return the minium length of the roof that would cover k cars
	 */
	public int minRoofLength(int[] cars, int k) {
		Arrays.sort(cars);
		int min = Integer.MAX_VALUE;
		for (int i = 0; i + k - 1 < cars.length; i++) {
			min = Math.min(min, cars[i + k - 1] - cars[i] + 1);
		}
		return min;
	}
}
