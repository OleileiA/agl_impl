package com.company.InAction.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class LargestRectangleArea {
    public int largestRectangleArea(int[] heights) {

        // 记录最大面积
        int res = 0;

        // 单调栈
        Deque<Integer> stack = new ArrayDeque<>();

        // 声明保存高度的数组
        // 前后各多出一个空位
        int[] new_heights = new int[heights.length + 2];

        // 赋值
        for (int i = 1; i < heights.length + 1; i++) {
            new_heights[i] = heights[i - 1];
        }


        for (int i = 0; i < new_heights.length; i++) {

            // 如果栈不为空 && 栈顶所代表的高度大于当前元素就遍历
            // 因为当前栈是单调栈
            // stack.peek() 可作为左边，不可能在向左扩展
            // 进入循环的i就是比栈顶小，所以不可能向右扩展
            while (!stack.isEmpty() && new_heights[stack.peek()] > new_heights[i]) {
                int cur = stack.pop();
                int l = stack.peek();
                int r = i;
                res = Math.max(res, (r - l - 1) * new_heights[cur]);
            }

            // 栈内存放下标
            stack.push(i);
        }


        return res;
    }
}
