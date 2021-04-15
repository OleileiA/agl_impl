package com.company.dp.uniqPath;

import java.util.List;

// 120. 三角形最小路径和
// https://leetcode-cn.com/problems/triangle/

/*
输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
输出：11
解释：如下面简图所示：
   2
  3 4
 6 5 7
4 1 8 3
自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）
*  */

// 需要注意的是这个问题绝对不能使用贪心思想，因为上一层选择最小，可能会导致下一层的最小无法选择。
public class MinimumTotal {
	/*
	* 最基本的思想:
	* 每一行 i 具有 i+1 个数字
    * 只要不是第一列（j!=0）位置上的数，都能通过「左上方」转移过来
    * 只要不是每行最后一列（j!=i）位置上的数，都能通过「上方」转移而来
	* */
	public int minimumTotal(List<List<Integer>> triangle) {

		int n = triangle.size();
		int[][] dp = new int[n][n];
		dp[0][0] = triangle.get(0).get(0);

		for (int i = 1; i < n; i++) {
			for (int j = 0; j <= i; j++) {
				int val = triangle.get(i).get(j);
				dp[i][j] = Integer.MAX_VALUE;
				if (j != 0) dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1] + val);
				if (j != i) dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + val);
			}
		}
		int result = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			result = Math.min(result, dp[n - 1][i]);
		}
		return result;
	}

	/*
	* 仔细观察可以发现，i只和i - 1有关
	* 可以利用滚动数组优化
	* 二维数组的长度改为2
	* 在所有i下标处&1取奇偶
	* */
	public int minimumTotal2(List<List<Integer>> triangle) {

		int n = triangle.size();
		int[][] dp = new int[2][n];
		dp[0][0] = triangle.get(0).get(0);

		for (int i = 1; i < n; i++) {
			for (int j = 0; j <= i; j++) {
				int val = triangle.get(i).get(j);
				dp[i & 1][j] = Integer.MAX_VALUE;
				if (j != 0) dp[i & 1][j] = Math.min(dp[i & 1][j], dp[(i - 1) & 1][j - 1] + val);
				if (j != i) dp[i & 1][j] = Math.min(dp[i & 1][j], dp[(i - 1) & 1][j] + val);
			}
		}
		int result = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			result = Math.min(result, dp[(n - 1) & 1][i]);
		}
		return result;
	}


}
