package com.company.LC.初级算法;

import java.lang.reflect.Array;
import java.util.Arrays;

/*
    给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
    不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。

    示例：
    给定数组 nums = [1,1,2],
    函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
    你不需要考虑数组中超出新长度后面的元素。
* */
public class _arr_1_RemoveDuplicates {

    /*-- 我的这种实现保证不了顺序 --*/
    public int removeDuplicates(int[] nums) {
        int supNum = 1;
        for (int i = 0; i < nums.length - supNum; i++) {
            int j = i - 1;
            while (j >= 0) {
                if (nums[i] == nums[j]) {
                    exch(nums, i, nums.length - supNum);
                    supNum++;
                    i--;
                }
                j--;
            }
        }
        return supNum;
    }
    private void exch(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /* -- 官方实现, 双指针 -- */
    public int removeDuplicates2(int[] nums) {
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) nums[++i] = nums[j];
        }
        return i + 1;
    }

    public static void main(String[] args) {
        _arr_1_RemoveDuplicates removeDuplicates = new _arr_1_RemoveDuplicates();
        System.out.println(removeDuplicates.removeDuplicates(new int[] { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 }));
    }


    /*
    * 双指针的一个应用，我在一开始写的时候根本想不到，只想到了交换。
    * */
}
