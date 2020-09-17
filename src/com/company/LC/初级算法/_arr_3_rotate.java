package com.company.LC.初级算法;

public class _arr_3_rotate {

    /*
    *   给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
        输入: [-1,-100,3,99] 和 k = 2
        输出: [3,99,-1,-100]
        解释:
        向右旋转 1 步: [99,-1,-100,3]
        向右旋转 2 步: [3,99,-1,-100]

        1. 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
        2. 要求使用空间复杂度为 O(1) 的 原地 算法。
    * */

    // 暴力法
    // 时间复杂度：O(n*k)O(n∗k) 。每个元素都被移动 1 步（O(n)O(n)） k次（O(k)O(k)） 。
    // 空间复杂度：O(1)O(1) 。没有额外空间被使用。
    public void rotate1(int[] nums, int k) {
        int n = 0;
        int len = nums.length;
        k = k % len;
        while (n < k) {
            int temp = nums[len - 1];
            for (int i = len - 1; i > 0; i--) {
                nums[i] = nums[i - 1];
            }
            nums[0] = temp;
            n++;
        }
    }
}
