package com.company.LC.初级算法;

/*
    给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
    你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍

    给定 nums = [2, 7, 11, 15], target = 9
    因为 nums[0] + nums[1] = 2 + 7 = 9
    所以返回 [0, 1]
*/

import java.util.HashMap;
import java.util.Map;

// 标签：数组，哈希表
public class _arr_9_TwoSum {
    public int[] solution(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) return new int[] { map.get(target - nums[i]), i };
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("no pair");
    }
}

/*
* TODO： 解体思路：
* 没什么特别的，用一个map装起来遍历过的值，循环的时候和当前的值计算target。
* 满足要求的就是对应的下标了。
* */
