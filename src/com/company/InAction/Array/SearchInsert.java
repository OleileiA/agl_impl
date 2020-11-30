package com.company.InAction.Array;

/*
* https://leetcode-cn.com/problems/search-insert-position/
*
* 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
* 输入: [1,3,5,6], 5
* 输出: 2
*
* */
public class SearchInsert {

    // 看起来就是一个改版的二分查找
    public int searchInsert(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] >= target) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

}
