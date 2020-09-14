package com.company.Recursive;

public class Cell {

    // 1 个细胞的生命周期是 3 小时，1 小时分裂一次。求 n 小时后，容器内有多少细胞？
    // 请你用已经学过的递归时间复杂度的分析方法，分析一下这个递归问题的时间复杂度。

    /*
    * f(0) = 1
    * f(1) = 2
    * f(2) = 4
    * f(3) = 8 - 1
    * f(4) = 14 - 2
    * f(5) = 24 - 4
    * */

    public int genCell(int hour) {
        if (hour == 0) return 1;
        if (hour == 1) return 2;
        if (hour == 2) return 4;
        return 2 * genCell(hour - 1) - genCell(hour - 3);
    }

    public static void main(String[] args) {
        Cell cell = new Cell();
        System.out.println(cell.genCell(10));
    }
}
