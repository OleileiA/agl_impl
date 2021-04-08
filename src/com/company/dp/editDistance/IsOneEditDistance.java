package com.company.dp.editDistance;


/*
* 相隔为 1 的编辑距离
* https://leetcode-cn.com/problems/one-edit-distance/
* */
public class IsOneEditDistance {
	public boolean isOneEditDistance(String s, String t) {

		int m = s.length();
		int n = t.length();

		int[][] dp = new int[m + 1][n + 1];
		for (int i = 1; i <= m; i++) dp[i][0] = i;
		for (int j = 1; j <= n; j++) dp[0][j] = j;

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (s.charAt(i - 1) == t.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1];
				} else {
					dp[i][j] = min(dp[i - 1][j] + 1,
							dp[i][j - 1] + 1,
							dp[i - 1][j - 1] + 1);
				}
			}
		}
		return dp[m][n] == 1;
	}
	private int min(int a, int b, int c) {
		return Math.min(a, Math.min(b, c));
	}
}
