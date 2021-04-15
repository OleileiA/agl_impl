package com.company.dp.uniqPath;

// 931. 下降路径最小和
// https://leetcode-cn.com/problems/minimum-falling-path-sum/
public class MinFallingPathSum {
	public int minFallingPathSum(int[][] matrix) {

		int m = matrix.length;
		int n = matrix[0].length;

		int[][] dp = new int[m][n];

		for (int i = 0; i < n; i++) {
			dp[0][i] = matrix[0][i];
		}

		for (int i = 1; i < m; i++) {
			for (int j = 0; j < n; j++) {
				int val = matrix[i][j];
				if (j == 0) dp[i][j] = Math.min(dp[i - 1][j] + val, dp[i - 1][j + 1] + val);
				else if (j == n - 1) dp[i][j] = Math.min(dp[i - 1][j - 1] + val, dp[i - 1][j] + val);
				else dp[i][j] = min(dp[i - 1][j - 1] + val, dp[i - 1][j] + val, dp[i - 1][j + 1] + val);
			}
		}

		int result = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			result = Math.min(result, dp[m - 1][i]);
		}

		return result;
	}
	private int min(int a, int b, int c) {
		return Math.min(a, Math.min(b, c));
	}
}
