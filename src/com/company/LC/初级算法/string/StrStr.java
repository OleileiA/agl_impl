package com.company.LC.初级算法.string;

import java.util.Arrays;

/*

给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。

输入: haystack = "hello", needle = "ll"
输出: 2

当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
* */
public class StrStr {
    // kmp
    public int strStr(String haystack, String needle) {
        int i = 0;
        int j = 0;

        int[] next = getNext(needle.toCharArray(), needle.length());

        while (i < haystack.length() && j < needle.length()) {
            if (j == -1 || haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            } else j = next[j];
        }

        if (j == needle.length()) return i - j;
        else return -1;
    }

    // 获取next（前缀表）
    public int[] getNext(char[] b, int m) {
        if (m <= 0) return null;
        int[] next = new int[m];
        next[0] = -1;
        int i = 0;
        int j = -1;
        while (i < m - 1) {
            if (j == -1 || b[i] == b[j]) {
                i++;
                j++;
                next[i] = j;
            } else j = next[j];
        }
        return next;
    }

    public static void main(String[] args) {
        StrStr strStr = new StrStr();
        System.out.println(strStr.strStr("abeabcabcd", "abc"));
    }
}
