package com.company.dp.maxProfit;

// 剑指 Offer 63. 股票的最大利润
// https://leetcode-cn.com/problems/gu-piao-de-zui-da-li-run-lcof/
public class MaxProfit_offer {
	public int maxProfit(int[] prices) {

		int len = prices.length;
		if (len <= 1) return 0;

		int dp_i_0 = 0;
		int dp_i_1 = -prices[0];

		for (int i = 1; i < len; i++) {
			dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
			dp_i_1 = Math.max(dp_i_1, -prices[i]);
		}

		return dp_i_0;
	}
}
