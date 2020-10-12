package com.company.LC.初级算法.string;
public class CountAndSay {

/*
给定一个正整数 n（1 ≤ n ≤ 30），输出外观数列的第 n 项。
描述前一项，这个数是 1 即 “一个 1 ”，记作 11
描述前一项，这个数是 11 即 “两个 1 ” ，记作 21
描述前一项，这个数是 21 即 “一个 2 一个 1 ” ，记作 12 11
描述前一项，这个数是 1211 即 “一个 1 一个 2 两个 1 ” ，记作 11 12 21
* */
    public String countAndSay(int n) {
        String str = "1";
        int curNum = 1;
        return makeStr(str, curNum, n);
    }

    private String makeStr(String str, int curNum, int num) {
        if (curNum == num) return str;
        else {
            str = getStrSay(str);
            return makeStr(str, ++curNum, num);
        }
    }

    public String getStrSay(String str) {

        StringBuilder builder = new StringBuilder();


        int fir = 0;
        int sec = 0;
        while (sec < str.length()) {
            sec++;
            if (sec == str.length()) break;
            else {
                if (str.charAt(sec) != str.charAt(fir)) {
                    int len = sec - fir;
                    builder.append(len);
                    builder.append(str.charAt(fir));
                    fir = sec;
                }
            }
        }
        builder.append(sec - fir);
        builder.append(str.charAt(fir));
        return builder.toString();
    }

    public static void main(String[] args) {
        CountAndSay countAndSay = new CountAndSay();
        System.out.println(countAndSay.countAndSay(3));
//        System.out.println(countAndSay.getStrSay("21"));
    }
}
