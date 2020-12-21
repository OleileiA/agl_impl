package com.company.BASE;


// https://leetcode-cn.com/problems/implement-queue-using-stacks/

import java.util.Deque;
import java.util.LinkedList;

public class MyQueue {

    private Deque<Integer> inputStack;

    private Deque<Integer> outputStack;

    public MyQueue() {
        inputStack = new LinkedList<>();
        outputStack = new LinkedList<>();
    }

    public void push(int x) {
        inputStack.push(x);
    }

    public int pop() {
        // 注意  必须是output为空的时候才移动，否则顺序会错
        if (outputStack.isEmpty()) {
            while (!inputStack.isEmpty()) {
                outputStack.push(inputStack.pop());
            }
        }
        return outputStack.pop();
    }

    public int peek() {
        if (outputStack.isEmpty()) {
            while (!inputStack.isEmpty()) {
                outputStack.push(inputStack.pop());
            }
        }
        return outputStack.peek();
    }

    public boolean empty() {
        return outputStack.isEmpty() && inputStack.isEmpty();
    }

}
