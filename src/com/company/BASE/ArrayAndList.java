package com.company.BASE;

public class ArrayAndList {
    private class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    // 翻转一个链表
    public ListNode reverse(ListNode head) {

        ListNode prev = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tmp;
        }

        return prev;
    }

    // swap nodes in pairs
    public ListNode swapNodes(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode result = dummy;

        while (dummy.next != null && dummy.next.next != null) {
            ListNode prev = dummy.next;
            ListNode cur = prev.next;
            dummy.next = cur;
            cur.next = prev;
            prev.next = cur.next;
            dummy = prev;
        }

        return result.next;
    }

    // 判断是否有环
    public boolean HasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }

}
