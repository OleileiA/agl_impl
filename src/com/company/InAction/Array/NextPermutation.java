package com.company.InAction.Array;

import java.util.Arrays;

/*

实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
必须 原地 修改，只允许使用额外常数空间。


输入：nums = [1,2,3]
输出：[1,3,2]
* */
public class NextPermutation {

    /*
    * 思路：
    * 1. [3, 2, 1]这样的就已经是这三个数字组成的最大排列了
    * 2. [1, 5, 2, 4, 3, 2]想将这样的一个排序调大一点
    *     应该从右向左，寻找元素比右邻居小的, 交换
    *    [1, 5, 3, 4, 2, 2]
    *    但是后面三位还能调换，再小一点，[1, 5, 3, 2, 2, 4]
    * */
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        int i = len - 1;
        int j;
        boolean flag = false;
        for (; i >= 1; i--) {
            j =  i - 1;
            if (nums[j] < nums[i]) {
                // 在后面找到一个最接近的nums[j]的数字，但是要大于nums[j]
                int m = len - 1;
                while (nums[m] <= nums[j]) m--;
                swap(nums, j, m);
                reverse(nums, j + 1, len - 1);
                flag = true;
                break;
            }
        }
        if (!flag) Arrays.sort(nums);
    }

    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
            left++;
            right--;
        }
    }

    private void swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }

}
