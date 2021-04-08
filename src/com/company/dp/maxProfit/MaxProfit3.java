package com.company.dp.maxProfit;

/*
* 买卖股票的最佳时机 III
* https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/
*/
public class MaxProfit3 {
	public int maxProfit(int[] prices) {

		int len = prices.length;
		if (len == 0) return 0;

		int dp_i_1_1 = -prices[0];
		int dp_i_1_0 = 0;

		int dp_i_2_1 = -prices[0];
		int dp_i_2_0 = 0;

		for (int i = 1; i < len; i++) {
			dp_i_1_1 = Math.max(dp_i_1_1, -prices[i]);
			dp_i_1_0 = Math.max(dp_i_1_0, dp_i_1_1 + prices[i]);
			dp_i_2_1 = Math.max(dp_i_2_1, dp_i_1_0 - prices[i]);
			dp_i_2_0 = Math.max(dp_i_2_0, dp_i_2_1 + prices[i]);
		}
		return dp_i_2_0;
	}
	public int maxProfit2(int[] prices) {
		int len = prices.length;
		if (len == 0) return 0;

		int sell1 = 0;
		int sell2 = 0;
		int buy1 = -prices[0];
		int buy2 = -prices[0];

		for (int i = 1; i < len; i++) {
			buy1 = Math.max(buy1, -prices[i]);
			sell1 = Math.max(sell1, buy1 + prices[i]);
			buy2 = Math.max(buy2, sell1 - prices[i]);
			sell2 = Math.max(sell2, buy2 + prices[i]);
		}
		return sell2;
	}
}
