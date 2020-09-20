package com.company.LC.初级算法;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// 判断一个数组中是否存在重复的元素
public class _arr_4_containsDuplicate {


    // 利用hashset
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<Integer>(nums.length);
        for (int a : nums) {
            if (!set.add(a)) return true;
        }
        return false;
    }

    // 利用hashmap
    public boolean containsDuplicate2(int[] nums) {
        Map<Integer, Boolean> map = new HashMap<>();
        for (int a : nums) {
            if (map.containsKey(a)) return true;
            map.put(a, true);
        }
        return false;
    }
}
