package com.company.LC.初级算法.string;

import java.util.Arrays;

/*
* 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。(估计是字母相同就行，位置无所谓)
* 输入: s = "anagram", t = "nagaram"
  输出: true
* */
public class IsAnagram {

    public boolean isAnagram(String s, String t) {
        int len1 = s.length();
        int len2 = t.length();
        if (len1 != len2) return false;
        int[] arr = new int[26];
        for (int i = 0; i < len1; i++) {
            char a = s.charAt(i);
            char b = t.charAt(i);
            arr[a - 'a']++;
            arr[b - 'a']--;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        IsAnagram isAnagram = new IsAnagram();
        isAnagram.isAnagram("", "");
    }
}
