package com.company.LC.初级算法.LinkedNode;

/*
* 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
* 给定一个链表: 1->2->3->4->5, 和 n = 2.
* 当删除了倒数第二个节点后，链表变为 1->2->3->5.
*
*
* */
public class RemoveNthFromEnd {

    private class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    // 这里需要注意，和直接删除非末尾节点不同
    // 这里必须保存前一个节点
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode beforeHead = new ListNode(0, head);
        ListNode prev = beforeHead;
        ListNode fir = head;
        ListNode sec = head;
        int i = 1;
        while (i < n) {
            i++;
            fir = fir.next;
        }
        while (fir.next != null) {
            prev = prev.next;
            fir = fir.next;
            sec = sec.next;
        }
        prev.next = sec.next;
        return beforeHead.next;
    }
}
