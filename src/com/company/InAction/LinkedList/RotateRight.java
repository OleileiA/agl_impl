package com.company.InAction.LinkedList;

/*
给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。

输入: 1->2->3->4->5->NULL, k = 2
输出: 4->5->1->2->3->NULL

解释:
向右旋转 1 步: 5->1->2->3->4->NULL
向右旋转 2 步: 4->5->1->2->3->NULL

* */
public class RotateRight {
    public ListNode rotateRight(ListNode head, int k) {

        if (head == null) return null;
        if (head.next == null) return head;

        ListNode tail = head;
        int len = 1;
        while (tail.next != null) {
            tail = tail.next;
            len++;
        }
        k %= len;

        if (k == 0) return head;
        ListNode p = head;
        while (k > 1) {
            p = p.next;
            k--;
        }
        ListNode result = p.next;
        p.next = null;
        tail.next = head;
        return result;
    }

    public ListNode rotateRight2(ListNode head, int k) {
        // base cases
        if (head == null) return null;
        if (head.next == null) return head;


        // 头尾相连
        ListNode old_tail = head;
        int n;
        for(n = 1; old_tail.next != null; n++) {
            old_tail = old_tail.next;
        }
        old_tail.next = head;

        // find new tail : (n - k % n - 1)th node
        // and new head : (n - k % n)th node
        ListNode new_tail = head;
        for (int i = 0; i < n - k % n - 1; i++) {
            new_tail = new_tail.next;
        }

        ListNode new_head = new_tail.next;

        // break the ring
        new_tail.next = null;

        return new_head;
    }
}
