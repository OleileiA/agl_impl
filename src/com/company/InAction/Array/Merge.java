package com.company.InAction.Array;

/*
给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。

nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3
输出：[1,2,2,3,5,6]

* */
public class Merge {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index = m + n - 1;
        int index1 = m - 1;
        int index2 = n - 1;
        while (index1 >= 0 && index2 >= 0) {
            nums1[index--] = nums1[index1] >= nums2[index2] ? nums1[index1--] : nums2[index2--];
        }
        System.arraycopy(nums2, 0, nums1, 0, index2 + 1);
    }
}
