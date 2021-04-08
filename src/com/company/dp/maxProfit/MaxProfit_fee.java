package com.company.dp.maxProfit;

// 买卖股票的最佳时机含手续费
// https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/

public class MaxProfit_fee {
	public int maxProfit(int[] prices, int fee) {

		int len = prices.length;
		if (len == 0) return 0;

		int dp_i_0 = 0;
		int dp_i_1 = -prices[0];

		for (int i = 1; i < len; i++) {
			dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i] - fee);
			dp_i_1 = Math.max(dp_i_1, dp_i_0 - prices[i]);
		}
		return dp_i_0;
	}
}
