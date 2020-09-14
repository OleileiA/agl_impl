package com.company.Recursive;

public class PrintPermutations {
    public void print(int[] data, int n , int k) {
        if (k == 1) {
            for (int i = 0; i < n; ++i) {
                System.out.print(data[i] + " ");
            }
            System.out.println();
        }

        for (int i = 0; i < k; ++i) {
            int tmp = data[i];
            data[i] = data[k - 1];
            data[k - 1] = tmp;

            print(data, n, k - 1);

            tmp = data[i];
            data[i] = data[k - 1];
            data[k - 1] = tmp;
        }
    }

    public static void main(String[] args) {
        /*
          2 3 1
          3 2 1
          3 1 2
          1 3 2
          2 1 3
          1 2 3
        */
        PrintPermutations printPermutations = new PrintPermutations();
        int[] arr = { 1, 2, 3 };
        printPermutations.print(arr, 3, 3);
    }
}
