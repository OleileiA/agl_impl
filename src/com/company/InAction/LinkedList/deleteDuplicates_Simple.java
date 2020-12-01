package com.company.InAction.LinkedList;

/*
* https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
* 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
*
* 输入: 1->1->2
* 输出: 1->2
* */
public class deleteDuplicates_Simple {
    public ListNode deleteDuplicates(ListNode head) {

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode node = dummy;

        while (node.next != null) {
            ListNode cur = node.next;
            ListNode next = cur.next;
            while (next != null && cur.val == next.val) {
                next = next.next;
            }
            cur.next = next;
            node = cur;
        }

        return dummy.next;
    }
}
