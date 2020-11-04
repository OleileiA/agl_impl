package com.company.InAction.Array;


/*
* https://leetcode-cn.com/problems/container-with-most-water/
*
* 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
* 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
* 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
*
* */
public class MaxArea {

    // 双指针实现，i和j判断的条件其实就是挑小的先走
    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int max = 0;
        while (i < j) {
            max = Math.max(max, Math.min(height[i], height[j]) * (j - i));
            if (height[j]  < height[i]) j--;
            else i++;
        }
        return max;
    }

    // 更好的实现，帮助指针更快的移动
    public int maxArea2(int[] height) {
        int max = 0, left = 0, right = height.length - 1;
        while (left < right) {
            int h = Math.min(height[left], height[right]);
            max = Math.max(max, (right - left) * h);

            while (height[left] <= h && left < right) left++;
            while (height[right] <= h && left < right) right--;
        }
        return max;
    }
}
