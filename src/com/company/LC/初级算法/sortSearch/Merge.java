package com.company.LC.初级算法.sortSearch;


/*
给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。

1. 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
2. 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。


输入：
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3

输出：[1,2,2,3,5,6]
* */
public class Merge {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p = nums1.length - 1;
        int p1 = m - 1;
        int p2 = n - 1;

        while (p1 >= 0 && p2 >= 0) {
            if (nums1[p1] < nums2[p2]) {
                nums1[p--] = nums2[p2--];
            } else {
                nums1[p--] =  nums1[p1--];
            }
        }

        // 根据上面的 判断 条件，循环结束之后，可能只是其中一个数组遍历完成
        // 如果输数组2还有元素没有遍历，直接复制过去就可以了。
        System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
    }
}
