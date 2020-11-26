package com.company.InAction.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
https://leetcode-cn.com/problems/4sum/

给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，
使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。


给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
满足要求的四元组集合为：
[
  [-1,  0, 0, 1],
  [-2, -1, 1, 2],
  [-2,  0, 0, 2]
]
* */

public class FourSum {
    /*
    * 时间复杂度O(n^3)
    * 基本原理就是两层嵌套的循环搞定前两个指针
    * 最里面包裹一个循环搞定双指针
    * */
    public List<List<Integer>> fourSum(int[] nums,int target) {

        List<List<Integer>> result=new ArrayList<>();

        if(nums == null || nums.length < 4) return result;

        Arrays.sort(nums);

        int length = nums.length;

        /* 定义4个指针k，i，j，h
        k从0开始遍历，i从k+1开始遍历，留下j和h，
        j指向i+1，h指向数组最大值*/

        for(int k = 0; k < length - 3; k++){

            /*当k的值与前面的值相等时忽略*/
            if(k > 0 && nums[k] == nums[k - 1]) continue;

            /* 获取当前最小值，如果最小值比目标值大，说明后面越来越大的值根本没戏 */
            int min1 = nums[k] + nums[k + 1] + nums[k + 2] + nums[k + 3];
            if(min1 > target) break;

            /*获取当前最大值，如果最大值比目标值小，说明后面越来越小的值根本没戏，忽略*/
            int max1 = nums[k] + nums[length - 1] + nums[length - 2] + nums[length - 3];
            if(max1 < target) continue;


            /*第二层循环i，初始值指向k+1*/
            for(int i = k + 1; i < length - 2; i++) {

                /*当i的值与前面的值相等时忽略*/
                if(i > k + 1 && nums[i] == nums[i - 1]) continue;

                /*定义指针j指向i+1*/
                int j = i + 1;

                /*定义指针h指向数组末尾*/
                int h = length - 1;

                /*获取当前最小值，如果最小值比目标值大，说明后面越来越大的值根本没戏*/
                int min = nums[k] + nums[i] + nums[j] + nums[j + 1];
                if(min > target) break;

                /*获取当前最大值，如果最大值比目标值小，说明后面越来越小的值根本没戏，忽略*/
                int max = nums[k] + nums[i] + nums[h] + nums[h - 1];
                if(max < target) continue;

                /*开始j指针和h指针的表演，计算当前和，如果等于目标值，j++并去重，h--并去重，当当前和大于目标值时h--，当当前和小于目标值时j++*/
                while (j < h) {
                    int curr = nums[k] + nums[i] + nums[j] + nums[h];
                    if (curr == target) {
                        result.add(Arrays.asList(nums[k], nums[i], nums[j], nums[h]));
                        j++;
                        while(j < h && nums[j] == nums[j - 1]) j++;
                        h--;
                        while(j < h && i < h && nums[h] == nums[h + 1]) h--;
                    } else if (curr > target) {
                        h--;
                    } else {
                        j++;
                    }
                }
            }
        }
        return result;
    }
}
