package com.company.LC.初级算法.arr;

public class _arr_11_rotateMatrix {

/*
给定一个 n × n 的二维矩阵表示一个图像。
将图像顺时针旋转 90 度。

说明：
你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。

给定 matrix =
[
  [1,2,3],
  [4,5,6],
  [7,8,9]
],

原地旋转输入矩阵，使其变为:
[
  [7,4,1],
  [8,5,2],
  [9,6,3]
]
*/

    // 出去四个角的旋转算法
    public void rotate(int[][] matrix) {
        int start = 0;
        int end = matrix.length - 1;
        minus(matrix, start, end);
    }
    private void minus(int[][] matrix, int start, int end) {
        if (start >= end) return;
        moveConner(matrix, start, end);
        moveBorder(matrix, start, end);
        minus(matrix, start + 1, end - 1);
    }
    private void moveConner(int[][] matrix, int start, int end) {

        int tempConner = matrix[start][end];
        matrix[start][end] = matrix[start][start];

        int tempConner2 = matrix[end][end];
        matrix[end][end] = tempConner;

        tempConner = matrix[end][start];
        matrix[end][start] = tempConner2;
        matrix[start][start] = tempConner;
    }
    private void moveBorder(int[][] matrix, int start, int end) {

        int[] tempArr = new int[end - start - 1];
        int[] tempArr2 = new int[end - start - 1];
        int len = tempArr.length;

        int count = 0;
        int i = start + 1;
        while (i <= end - 1) {
            tempArr[count++] = matrix[i][end];
            matrix[i][end] = matrix[start][i];
            i++;
        }

        int count1 = 0;
        int i1 = start + 1;
        while ( i1 <= end - 1) {
            tempArr2[count1] = matrix[end][i1];
            matrix[end][i1] = tempArr[len - 1 - count1];
            count1++;
            i1++;
        }

        int i2 = start + 1;
        int count2 = 0;
        while (i2 <= end - 1) {
            tempArr[count2] = matrix[i2][start];
            matrix[i2][start] = tempArr2[count2];
            count2++;
            i2++;
        }

        int i3 = start + 1;
        int count3 = 0;
        while (i3 <= end -1) {
            matrix[start][i3] = tempArr[len - 1 - count3];
            count3++;
            i3++;
        }
    }
}
