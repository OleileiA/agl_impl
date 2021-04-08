package com.company.dp.senior_dp;


// 完全平方数
// https://leetcode-cn.com/problems/perfect-squares/

public class NumSquares {
	public int numSquares(int n) {

		// dp数组表示，当前数字的对应完全平方数
		int[] dp = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			dp[i] = i; // 当前数字是4，初始化为4：那么相当于1+1+1+1，初始化最大
			for (int j = 1; i - j * j >= 0; j++) {
				dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
			}
		}
		return dp[n];
	}
}
