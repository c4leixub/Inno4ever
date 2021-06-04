package com.twt.zoa.array;

public class AutoScalePolicy {
	
	private static final double LIMIT = Math.pow(10, 8);

	public int finalInstances(int instances, int[] averageUtils) {
		
		for (int avgUtil : averageUtils) {
			if (avgUtil < 25) {
				if (instances > 1) {
					//instances = (int) Math.ceil(instances / 2.0);
					instances = instances % 2 == 0 ? instances / 2 : instances / 2 + 1; 
				}
			} else if (avgUtil > 60) {
				if (instances * 2 <= 2 * LIMIT) {
					instances *= 2;
				}
			}
		}
		return instances;
	}
	
	public static void main(String[] args) {
		
		AutoScalePolicy a = new AutoScalePolicy();
		int instances = 2;
		int[] averageUtils = new int[] {
			25,23,1,2,3,4,5,6,7,8,9,10,76,80
		};
		
		System.out.println(a.finalInstances(instances, averageUtils));
	}
}
