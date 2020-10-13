package com.company.LC.初级算法.LinkedNode;

/*
输入: 1->2->3->4->5->NULL
输出: 5->4->3->2->1->NULL

你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
* */
public class ReverseList {

    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    // 将已经交换完毕的元素列表保存头尾，不停的与下一个交换到头前面成为新的头。
    public ListNode reverseList(ListNode head) {
        ListNode subHead = head;
        ListNode subEnd = head;
        while (head != null && head.next != null) {
            head = head.next;
            subEnd.next = head.next;
            head.next = subHead;
            subHead = head;
            head = subEnd;
        }
        return subHead;
    }
}
