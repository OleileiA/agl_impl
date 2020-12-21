package com.company.BASE;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class StackAndQueue {

    // 判断字符串的括号是否成对匹配
    // '[][]{[]}'
    public boolean ifPair(String s) {

        int len = s.length();
        if (len % 2 == 1) return false;

        // 初始化map
        Map<Character, Character> map = new HashMap<Character, Character>() {{
            put('}', '{');
            put(']', '[');
            put(')', '(');
        }};

        // 栈
        Deque<Character> stack = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                if (stack.isEmpty() || map.get(c) != stack.peek()) return false;
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
