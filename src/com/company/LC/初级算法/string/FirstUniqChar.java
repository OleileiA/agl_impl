package com.company.LC.初级算法.string;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqChar {
    /*
    * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
    *
    * s = "leetcode" 返回 0
      s = "loveleetcode" 返回 2
      *
      * "leetcode"
      * "loveleetcode"
    * */
    public int firstUniqChar(String s) {
        char[] chars = s.toCharArray();
        if (chars.length == 0) {
            return -1;
        }
        int[] map = new int[256];
        for (char aChar : chars) {
            map[aChar] += 1;
        }
        for (int i = 0; i < chars.length; i++) {
            if (map[chars[i]] == 1) {
                return i;
            }
        }
        return -1;
    }
}
