package com.company.dp_maxProfit;

/*
* 买卖股票的最佳时机 IV
* https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv/
**/
public class MaxProfit4 {
	public int maxProfit(int K, int[] prices) {
		int n = prices.length;
		if(n <= 1) return 0;

		//因为一次交易至少涉及两天，所以如果k大于总天数的一半，就直接取天数一半即可，多余的交易次数是无意义的
		K = Math.min(K, n / 2);

		/*dp定义：dp[i][j][k]代表 第i天交易了k次时的最大利润，其中j代表当天是否持有股票，0不持有，1持有*/
		int[][][] dp = new int[n][K + 1][2];
		for(int k = 0; k <= K; k++){
			dp[0][k][0] = 0;
			dp[0][k][1] = -prices[0];
		}

        /*状态方程：
        dp[i][0][k]，当天不持有股票时，看前一天的股票持有情况
        dp[i][1][k]，当天持有股票时，看前一天的股票持有情况*/
		for(int i = 1; i < n; i++){
			for(int k = 1;k <= K; k++){
				dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
				dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i]);
			}
		}
		return dp[n - 1][K][0];
	}
}
