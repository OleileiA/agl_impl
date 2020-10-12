package com.company.LC.初级算法.string;
/*
* 编写一个函数来查找字符串数组中的最长公共前缀。
  如果不存在公共前缀，返回空字符串 ""。
  *
  *
  *
  输入: ["flower","flow","flight"]
  输出: "fl"

  输入: ["dog","racecar","car"]
  输出: ""
  解释: 输入不存在公共前缀。
* */
public class LongestCommonPrefix {
    /*
    * 我默认想到的办法: 横向扫描
    * 首先比较前两个，取公共前缀
    *
    * 然后利用功能前缀逐个和后面的元素比较，取最小的返回。如果有任何一个循环返回"", 直接返回""
    * */
    public String longestCommonPrefix(String[] strs) {
        StringBuilder res = new StringBuilder();
        int len = strs.length;
        if (len == 0) return res.toString();
        if (len == 1) return strs[0];

        int subStr1 = strs[0].length();
        int subStr2 = strs[1].length();
        for (int i = 0; i < Math.min(subStr1, subStr2); i++) {
            if (strs[0].charAt(i) == strs[1].charAt(i)) {
                res.append(strs[0].charAt(i));
            } else break;
        }

        String curStr =  "";
        if (res.toString().equals("")) return res.toString();
        else {
            curStr = res.toString();
            for (int i = 2;  i < len; i++) {
                StringBuilder temp = new StringBuilder();
                for (int j = 0; j < Math.min(curStr.length(), strs[i].length()); j++) {
                    if (curStr.charAt(j) == strs[i].charAt(j)) {
                        temp.append(curStr.charAt(j));
                    } else break;
                }
                if (temp.toString().equals("")) return "";
                if (temp.toString().length() < curStr.length()) {
                    curStr = temp.toString();
                }
            }
        }
        return curStr;
    }

    public static void main(String[] args) {
        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
        String res = longestCommonPrefix.longestCommonPrefix(new String[] {
            "know" , "knolo", "know"
        });

        System.out.println(res);
    }
}
