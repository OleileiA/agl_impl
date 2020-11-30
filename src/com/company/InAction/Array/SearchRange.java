package com.company.InAction.Array;

/*

给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
你的算法时间复杂度必须是 O(log n) 级别。
如果数组中不存在目标值，返回 [-1, -1]。

输入: nums = [5,7,7,8,8,10], target = 8
输出: [3,4]

* */
public class SearchRange {

    // 我自己的实现，二分查找配合单方向的遍历
    public int[] searchRange(int[] nums, int target) {

        int[] result = { -1, -1 };

        boolean flag = false;
        int len = nums.length;
        int left = 0;
        int right = len - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                right = right - 1;
                flag = true;
            } else if (nums[mid] > target) {
                right = right - 1;
            } else {
                left = left + 1;
            }
        }

        if (flag) {
            result[0] = left;
            while (left < len && nums[left] == target) left++;
            result[1] = left - 1;
        }
        return result;
    }

    // 官方答案
    // 其实就是两次二分查找，分别确定左右index
    public int[] searchRange2(int[] nums, int target) {
        int[] targetRange = {-1, -1};

        int leftIdx = extremeInsertionIndex(nums, target, true);

        // assert that `leftIdx` is within the array bounds and that `target`
        // is actually in `nums`.
        if (leftIdx == nums.length || nums[leftIdx] != target) {
            return targetRange;
        }

        targetRange[0] = leftIdx;
        targetRange[1] = extremeInsertionIndex(nums, target, false) - 1;

        return targetRange;
    }
    private int extremeInsertionIndex(int[] nums, int target, boolean left) {
        int lo = 0;
        int hi = nums.length;

        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] > target || (left && target == nums[mid])) {
                hi = mid;
            }
            else {
                lo = mid + 1;
            }
        }

        return lo;
    }
}
