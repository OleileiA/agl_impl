package com.company.InAction.stack;

import java.util.*;

/*
* https://leetcode-cn.com/problems/valid-parentheses/
*
* 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

有效字符串需满足：

左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。
注意空字符串可被认为是有效字符串。

输入: "()"
输出: true
* */
public class IsValid {
    public boolean isValid(String s) {

        // 奇数直接排除
        int len = s.length();
        if (len % 2 == 1) return false;

        // 初始化括号对
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        Deque<Character> stacks = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                if (stacks.isEmpty() || stacks.peek() != map.get(c)) return false;
                stacks.pop();
            } else {
                stacks.push(c);
            }
        }
        return stacks.isEmpty();
    }
}
