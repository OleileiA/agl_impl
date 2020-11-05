package com.company.InAction.LinkedList;


import java.util.List;

/*
* https://leetcode-cn.com/problems/reverse-linked-list/
*
* 反转一个单链表。
*
* 输入: 1->2->3->4->5->NULL
  输出: 5->4->3->2->1->NULL

* */
public class ReverseList {
    // 遍历方式
    public ListNode reverseList(ListNode head) {
        ListNode fir = null, sec = head;
        while (sec != null) {
            ListNode node = sec.next;
            sec.next = fir;
            fir = sec;
            sec = node;
        }
        return fir;
    }

    // 递归方式
    public ListNode reverseList2(ListNode head) {
        ListNode fir = null;
        return reverse(fir, head);
    }

    private ListNode reverse(ListNode fir, ListNode sec) {
        if (sec == null) return fir;
        ListNode node = sec.next;
        sec.next = fir;
        fir = sec;
        sec = node;
        return reverse(fir, sec);
    }
}
