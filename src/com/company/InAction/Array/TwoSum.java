package com.company.InAction.Array;

import java.util.HashMap;
import java.util.Map;

/*

https://leetcode-cn.com/problems/two-sum/

定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
给定 nums = [2, 7, 11, 15], target = 9

因为 nums[0] + nums[1] = 2 + 7 = 9
所以返回 [0, 1]


 * */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int num = target - nums[i];
            if (map.containsKey(num)) {
                res[0] = i;
                res[1] = map.get(num);
            }
            map.put(nums[i], i);
        }
        return res;
    }
}
