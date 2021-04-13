package com.company.dp.uniqPath;

// 64. 最小路径和
// https://leetcode-cn.com/problems/minimum-path-sum/

public class MinPathSum {
	public int minPathSum(int[][] grid) {

		int m = grid.length;
		int n = grid[0].length;

		int[][] dp = new int[m][n];

		int sum1 = 0;
		for (int i = 0; i < m; i++) {
			dp[i][0] = sum1 += grid[i][0];
		}

		int sum2 = 0;
		for (int j = 0; j < n; j++) {
			dp[0][j] = sum2 += grid[0][j];
		}

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
			}
		}

		return dp[m - 1][n - 1];
	}
}
