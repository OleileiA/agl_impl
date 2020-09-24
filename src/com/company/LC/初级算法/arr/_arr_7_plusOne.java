package com.company.LC.初级算法.arr;

import java.util.Arrays;

public class _arr_7_plusOne {

/*

    给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
    最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
    你可以假设除了整数 0 之外，这个整数不会以零开头。

    输入: [4,3,2,1]
    输出: [4,3,2,2]
    解释: 输入数组表示数字 4321。

    输入: [1,2,3]
    输出: [1,2,4]
    解释: 输入数组表示数字 123。

*/

    /*
    * 递归相加的的方法，我自己写的
    * */
    public int[] plusOne(int[] digits) {

        int len = digits.length;
        // 用来返回的长度+1数组
        int[] arr = new int[len + 1];

        // 赋值
        while (len > 0) {
            arr[len] = digits[len - 1];
            len--;
        }
        // 开始增加
        arrPlus(arr, digits.length);

        // 根据是否进位返回数组
        if (arr[0] == 0) return Arrays.copyOfRange(arr, 1, digits.length + 1);
        else return arr;
    }
    private void arrPlus(int [] arr, int index) {
        int num = arr[index] + 1;
        if (num == 10) {
            arr[index] = 0;
            arrPlus(arr, index - 1);
        } else {
            arr[index] = num;
        }
    }
}
