package com.company.LC.初级算法.arr;

import java.util.Arrays;
import java.util.Comparator;

public class _arr_8_moveZeroes {

    // 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
    // 输入: [0, 1, 0, 3, 12]
    // 输出: [1, 3, 12, 0, 0]

    // 要求：
    // 1. 必须在原数组上操作，不能拷贝额外的数组。
    // 2. 尽量减少操作次数。


    // 我的遍历实现, 速度100%
    public void moveZeroes(int[] nums) {
        int len = nums.length;
        int count = 0;
        for (int i = 0; i < len; i++) {
            int num = nums[i];
            if (num == 0) count++;
            else nums[i - count] = num;
        }
        while (count > 0) {
            nums[len - 1] = 0;
            count--;
            len--;
        }
    }
}
