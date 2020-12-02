package com.company.InAction.LinkedList;

/*

反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。

说明:
1 ≤ m ≤ n ≤ 链表长度。

示例:
输入: 1->2->3->4->5->NULL, m = 2, n = 4
输出: 1->4->3->2->5->NULL

* */
public class ReverseBetween {

    public ListNode reverseBetween(ListNode head, int m, int n) {

        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode g = dummyHead;
        ListNode p = dummyHead.next;

        /* 找到m节点的前一个和当前直接绑定 */
        int step = 0;
        while (step < m - 1) {
            g = g.next;
            p = p.next;
            step++;
        }

        /* 翻转链表的一个方法，头插法 */
        /* p不断的向后，将后面的节点挪动到g后面，完成翻转 */
        for (int i = 0; i < n - m; i++) {
            ListNode removed = p.next;
            p.next = p.next.next;
            removed.next = g.next;
            g.next = removed;
        }

        return dummyHead.next;
    }
}
