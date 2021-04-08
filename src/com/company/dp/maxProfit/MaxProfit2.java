package com.company.dp.maxProfit;

/*
* 买卖股票的最佳时机2
* https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
*/
public class MaxProfit2 {
	public int maxProfit(int[] prices) {

		int len = prices.length;
		if (len == 0) return 0;

		int dp_i_0 = 0;
		int dp_i_1 = -prices[0];

		for (int i = 1; i < len; i++) {
			dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
			dp_i_1 = Math.max(dp_i_1, dp_i_0 - prices[i]);
		}
		return dp_i_0;
	}
}
