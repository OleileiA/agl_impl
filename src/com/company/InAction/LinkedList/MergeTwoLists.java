package com.company.InAction.LinkedList;

/*
* https://leetcode-cn.com/problems/merge-two-sorted-lists/
*
* 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
*
 * */
public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode preHead = new ListNode(-1);
        ListNode result = preHead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                preHead.next = l1;
                l1 = l1.next;
            } else {
                preHead.next = l2;
                l2 = l2.next;
            }
            preHead = preHead.next;
        }
        preHead.next = l1 == null ? l2 : l1;
        return result.next;
    }
}
