package com.company.LC.初级算法;


// 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
/*
* 输入: [2,2,1]
  输出: 1
* */
public class _arr_5_singleNumber {

    public int singleNumber(int[] nums) {
        int single = 0;
        for (int a : nums) {
            single ^= a;
        }
        return single;
    }
}


/*
1. 任何数和 00 做异或运算，结果仍然是原来的数。
2. 任何数和其自身做异或运算，结果是 00。
3. 异或运算满足交换律和结合律。
*/
