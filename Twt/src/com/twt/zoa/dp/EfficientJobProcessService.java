package com.twt.zoa.dp;

public class EfficientJobProcessService {

	public int maximumTotalWeight(int[] weights, int[] tasks, int p) {
		// task will be processed double of weight, hence halve p
		int[][] dp = new int[tasks.length + 1][p / 2 + 1]; 
		
//      for (int i = 0; i < tasks.length; i++) {
//          tasks[i] *= 2;
//      }

		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				if (j < tasks[i - 1]) {
					dp[i][j] = dp[i - 1][j];
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - tasks[i - 1]] + weights[i - 1]);
				}
			}
		}

		return dp[tasks.length][p / 2];
	}
	
	public static void main(String[] args) {
		EfficientJobProcessService e = new EfficientJobProcessService();
		
		int[] weights = new int[]{2, 4, 4, 5};
        int[] tasks = new int[]{2, 2, 3, 4};
        System.out.println(e.maximumTotalWeight(weights, tasks, 15));      // 10
	}
}
