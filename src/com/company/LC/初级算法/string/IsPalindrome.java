package com.company.LC.初级算法.string;

/*
* 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
* 说明：本题中，我们将空字符串定义为有效的回文串。
* 输入: "A man, a plan, a canal: Panama"
  输出: true
* */
public class IsPalindrome {

    // 双指针
    public boolean isPalindrome(String s) {
        String s1 = s.toLowerCase();
        char [] charArr = s1.toCharArray();

        int start = 0;
        int end = charArr.length - 1;

        while (start < end) {
            while (start < end && !Character.isLetterOrDigit(charArr[start])) start++;
            while (start < end && !Character.isLetterOrDigit(charArr[end])) end--;
            if (start < end) {
                if (charArr[start++] != charArr[end--]) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        IsPalindrome isPalindrome = new IsPalindrome();
        Boolean ANS = isPalindrome.isPalindrome("0P");
        System.out.println(ANS);
    }
}
