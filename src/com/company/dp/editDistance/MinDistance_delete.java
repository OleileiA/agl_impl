package com.company.dp.editDistance;

/*
* https://leetcode-cn.com/problems/delete-operation-for-two-strings/
* 两个字符串的删除操作
* */
public class MinDistance_delete {
	public int minDistance(String word1, String word2) {

		int m = word1.length();
		int n = word2.length();

		int[][] dp = new int[m + 1][n + 1];

		for (int i = 1; i <= m; i++) dp[i][0] = i;
		for (int j = 1; j <= n; j++) dp[0][j] = j;

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1];
				} else {
					dp[i][j] = Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1);
				}
			}
		}
		return dp[m][n];
	}
}
