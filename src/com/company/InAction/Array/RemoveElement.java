package com.company.InAction.Array;

import java.util.Arrays;

/*

https://leetcode-cn.com/problems/remove-element/


给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。

* */
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        Arrays.sort(nums);
        int n = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                n++;
            }
            if (nums[i] > val) {
                nums[i - n] = nums[i];
            }
        }
        return nums.length - n;
    }
}
