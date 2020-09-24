package com.company.LC.初级算法.string;


import java.util.Arrays;

/*
输入一个整数，翻转他：

输入: 123
输出: 321
*/
public class ReverseInteger {

    /*
    * 没有检测范围，错误解
    * */
    public int reverse(int x) {
        boolean flag = true;
        String str = String.valueOf(x);
        if (str.startsWith("-")) {
            str = str.substring(1);
            flag = false;
        }
        String[] strArr = str.split("");

        int len = strArr.length;
        int sum = 0;
        int i = 0;
        while (i < len) {
            if (flag) sum += Integer.parseInt(strArr[i]) * Math.pow(10, i);
            else sum -= Integer.parseInt(strArr[i]) * Math.pow(10, i);
            i++;
        }
        return sum;
    }

    // x % 10 求最后一位
    public int reverse1(int x) {
        int answer = 0;
        while (x != 0) {
            if (answer * 10 / 10 != answer) return 0; // 判断超出范围
            answer = answer * 10 + x % 10;
            x = x / 10;
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(String.valueOf(-123));
    }
}
