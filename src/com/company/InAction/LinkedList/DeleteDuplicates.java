package com.company.InAction.LinkedList;


/*

  给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。

  输入: 1->2->3->3->4->4->5
  输出: 1->2->5

* */
public class DeleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode cur = dummy;

        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                ListNode temp = cur.next;
                while (temp.next != null && temp.val == temp.next.val ) {
                    temp = temp.next;
                }
                cur.next = temp.next;
            } else cur = cur.next;
        }
        return dummy.next;
    }
}
