package com.company.dp.jumpGame;

// 45. 跳跃游戏 II
// https://leetcode-cn.com/problems/jump-game-ii/
public class JumpGame2 {
	public int jump(int[] nums) {

		int len = nums.length;

		int count = 0;
		int endIndex = 0;
		int rightMost = 0;

		// 在遍历数组时，我们不访问最后一个元素，这是因为在访问最后一个元素之前，
		// 我们的边界一定大于等于最后一个位置，否则就无法跳到最后一个位置了
		for (int i = 0; i < len - 1; i++) {
			rightMost = Math.max(rightMost, i + nums[i]);
			if (endIndex == i) {
				count++;
				endIndex = rightMost;
			}
		}

		return count;
	}
}
