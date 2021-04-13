package com.company.dp.uniqPath;

// 62. 不同路径
// https://leetcode-cn.com/problems/unique-paths/


/*
*
* 定义 f[i][j] 为到达位置 (i,j) 的不同路径数量。

那么 f[n-1][m-1] 就是我们最终的答案，而 f[0][0] = 1 是一个显而易见的起始条件。

由于题目限定了我们只能 往下 或者 往右 移动，因此我们按照当前可选方向进行分析：

当前位置只能 往下 移动，即有 f[i][j] = f[i-1][j]

当前位置只能 往右 移动，即有 f[i][j] = f[i][j-1]

当前位置即能 往下 也能 往右 移动，即有 f[i][j] = f[i][j-1] + f[i-1][j]
* */
public class UniquePaths {
	public int uniquePaths(int m, int n) {
		int[][] dp = new int[m][n];
		for (int i = 0; i < m; i++)
			dp[i][0] = 1;
		for (int j = 0; j < n; j++)
			dp[0][j] = 1;

		for (int i = 1; i < m; i++)
			for (int j = 1; j < n; j++)
				dp[i][j] = dp[i - 1][j] + dp[i][j - 1];

		return dp[m - 1][n - 1];
	}
}
