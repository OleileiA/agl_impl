package com.company.dp.uniqPath;

// 1289. 下降路径最小和  II
// https://leetcode-cn.com/problems/minimum-falling-path-sum-ii/

public class MinFallingPathSum2 {
	public int minFallingPathSum(int[][] arr) {

		int m = arr.length;
		int n = arr[0].length;

		int[][] dp = new int[m][n];
		System.arraycopy(arr[0], 0, dp[0], 0, n);

		for (int i = 1; i < m; i++) {
			for (int j = 0; j < n; j++) {
				dp[i][j] = findMin(dp[i - 1], j) + arr[i][j];
			}
		}

		int result = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			result = Math.min(dp[m - 1][i], result);
		}
		return result;
	}

	private int findMin(int[] arr, int index) {
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < arr.length; i++) {
			if (i == index) continue;
			min = Math.min(arr[i], min);
		}
		return min;
	}
}
