package com.company.dp.maxProfit;

/*
 买卖股票的最佳时机1
 https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/#/description


 dp[i][k][0]
 dp[i][k][1]

 i: 表示天数
 k: 表示交易次数
 0 / 1： 表示未持有和持有两个状态

 dp[i][1][0] = max(dp[i - 1][1][0], dp[i - 1][1][1] + price[i]);
 dp[i][1][1] = max(dp[i - 1][1][1], dp[i - 1][0][0] - price[i]);

*/
public class MaxProfit1 {

	// 数组实现
	public int maxProfit(int[] prices) {
		int len = prices.length;
		if (len == 0) return 0;

		int[][] dp = new int[len][2];
		dp[0][0] = 0;
		dp[0][1] = -prices[0];

		for (int i = 1; i < len; i++) {
			dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
			dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
		}
		return dp[len - 1][0];
	}

	// 变量实现
	public int maxProfit2(int[] prices) {
		int len = prices.length;
		if (len == 0) return 0;

		int dp_i_0 = 0;
		int dp_i_1 = -prices[0];

		for (int i = 1; i < len; i++) {
			dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
			dp_i_1 = Math.max(dp_i_1, -prices[i]);
		}
		return dp_i_0;
	}
}
