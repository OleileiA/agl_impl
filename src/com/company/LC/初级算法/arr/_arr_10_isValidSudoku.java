package com.company.LC.初级算法.arr;

import java.util.HashSet;
import java.util.Set;

public class _arr_10_isValidSudoku {
    /*
    * 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。

    数字 1-9 在每一行只能出现一次。
    数字 1-9 在每一列只能出现一次。
    数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
*
*
*
输入:

[
  ["5","3",".",  ".","7",".",  ".",".","."],
  ["6",".",".",  "1","9","5",  ".",".","."],
  [".","9","8",  ".",".",".",  ".","6","."],

  ["8",".",".",  ".","6",".",  ".",".","3"],
  ["4",".",".",  "8",".","3",  ".",".","1"],
  ["7",".",".",  ".","2",".",  ".",".","6"],

  [".","6",".",  ".",".",".",  "2","8","."],
  [".",".",".",  "4","1","9",  ".",".","5"],
  [".",".",".",  ".","8",".",  ".","7","9"]
]

输出: true
*/

    // 暴力法
    // 求 3 * 3的小方块是第几个的算法：(row / 3) * 3 + (columns / 3)
    // char '3' - '0' = 3是最方便的抓换方式。
    public boolean isValidSudoku(char[][] board) {

        int row[][] = new int[9][10]; // 下标是9的话，需要数组长度是10
        int column[][] = new int[9][10];
        int box[][] = new int[9][10];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j]== '.'){
                    continue;
                }
                int num = board[i][j] - '0';
                if (row[i][num] == 1) return false;
                if (column[j][num] == 1) return false;
                if (box[(i / 3) * 3 + j / 3][num] == 1) return false;
                row[i][num] = 1;
                column[j][num] = 1;
                box[(i / 3) * 3 + j / 3][num] = 1;
            }
        }
        return true;
    }

}
