package com.company.LC.初级算法.LinkedNode;
/*
* 请判断一个链表是否为回文链表。
* 输入: 1->2
* 输出: false
*
* 输入: 1->2->2->1
* 输出: true
*
* 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
* */
public class IsPalindrome {

    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode mid = getMiddleNode(head);
        ListNode subHead = reverse(mid);
        while (subHead != null) {
            if (subHead.val != head.val) return false;
            subHead = subHead.next;
            head = head.next;
        }
        return true;
    }

    private ListNode getMiddleNode(ListNode node) {
        ListNode fast = node;
        ListNode slow = node;
        while (fast != null && fast.next != null)  {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    private ListNode reverse(ListNode node) {
        ListNode pre = null;
        ListNode cur =  node;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }
}
