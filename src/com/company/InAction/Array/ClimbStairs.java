package com.company.InAction.Array;


import java.util.HashMap;
import java.util.Map;

/*

https://leetcode-cn.com/problems/climbing-stairs/

* 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
  每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
*
* 输入： 2
输出： 2
解释： 有两种方法可以爬到楼顶。
1.  1 阶 + 1 阶
2.  2 阶
*
*
*
* 输入： 3
  输出： 3
解释： 有三种方法可以爬到楼顶。
1.  1 阶 + 1 阶 + 1 阶
2.  1 阶 + 2 阶
3.  2 阶 + 1 阶


输入：4
1. 1 + 1 + 1 + 1
2. 1 + 1 + 2
3. 1 + 2 + 1
4. 2 + 1 + 1
5. 2 + 2
* */

/*
* 本质就是斐波那契数列，但是使用递归会超时。
* 应该使用动态规划
* */
public class ClimbStairs {

    //  这里的思路是保存三个数字引用，循环叠加
    public int climbStairs(int n) {
        int last = 0, mid = 0, next = 1;
        for (int i = 1; i <= n; i++) {
            last = mid;
            mid = next;
            next = last + mid;
        }
        return next;
    }
}
