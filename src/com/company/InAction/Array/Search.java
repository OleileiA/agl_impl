package com.company.InAction.Array;


/*
* https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
*
给你一个整数数组 nums ，和一个整数 target 。
该整数数组原本是按升序排列，但输入时在预先未知的某个点上进行了旋转。（例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] ）。
请你在数组中搜索 target ，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。

输入：nums = [4,5,6,7,0,1,2], target = 0
输出：4
* */
public class Search {
    /*
    * 使用二分查找方法
    * 一个旋转过后的数组其实就是两个有序的数组
    * */
    public int search(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) return -1;
        if (len == 1) return nums[0] == target ? 0 : -1;

        int left = 0;
        int right = len - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[0] <= nums[mid]) { // mid在旋转数组的左边
                if (target >= nums[0] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left  = mid + 1;
                }
            } else { // mid在旋转数组的右边
                if (target <= nums[len - 1] && target > nums[mid]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
