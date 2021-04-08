package com.company.dp.editDistance;

// 编辑距离问题
// https://leetcode-cn.com/problems/edit-distance/
// 题解：https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247484731&idx=3&sn=aa642cbf670feee73e20428775dff0b5&chksm=9bd7fb33aca0722568ab71ead8d23e3a9422515800f0587ff7c6ef93ad45b91b9e9920d8728e&scene=21#wechat_redirect

/*
dp(i, j - 1) + 1，  # 插入

# 我直接在 s1[i] 插入一个和 s2[j] 一样的字符
# 那么 s2[j] 就被匹配了，前移 j，继续跟 i 对比
# 别忘了操作数加一


dp(i - 1, j) + 1,    # 删除

# 解释：
# 我直接把 s[i] 这个字符删掉
# 前移 i，继续跟 j 对比
# 操作数加一

dp(i - 1, j - 1) + 1 # 替换
# 解释：
# 我直接把 s1[i] 替换成 s2[j]，这样它俩就匹配了
# 同时前移 i，j 继续对比
# 操作数加一

* */

public class MinDistance {
	public int minDistance(String word1, String word2) {
		int m = word1.length();
		int n = word2.length();

		int[][] dp = new int[m + 1][n + 1];
		for (int i = 1; i <= m; i++) dp[i][0] = i;
		for (int j = 1; j <= n; j++) dp[0][j] = j;

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1];
				} else {
					dp[i][j] = min(dp[i][j - 1] + 1,
							dp[i - 1][j] + 1,
							dp[i - 1][j - 1] + 1);
				}
			}
		}
		return dp[m][n];
	}
	private int min(int a, int b, int c) {
		return Math.min(a, Math.min(b, c));
	}
}
