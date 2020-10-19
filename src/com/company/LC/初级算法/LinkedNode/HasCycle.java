package com.company.LC.初级算法.LinkedNode;

public class HasCycle {

    /*
    * 给定一个链表，判断链表中是否有环。
    *  */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) return true;
        }
        return false;
    }
}
