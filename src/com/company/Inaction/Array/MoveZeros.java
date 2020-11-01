package com.company.Inaction.Array;

/*
* 给定一个数组 nums，编写一个函数将所有0移动到数组的末尾，同时保持非零元素的相对顺序。
* 输入: [0,1,0,3,12]
  输出: [1,3,12,0,0]

  说明：
  1. 必须在原数组上操作，不能拷贝额外的数组。
  2. 尽量减少操作次数。
* */
public class MoveZeros {
    public void moveZeroes(int[] nums) {
        // j再循环的时候同步下标，如果发现等于0的地方j将停留
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                if (i != j) nums[i] = 0;
                j++;
            }
        }
    }
}
