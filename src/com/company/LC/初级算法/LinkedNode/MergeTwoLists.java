package com.company.LC.初级算法.LinkedNode;

// 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
// 输入：1->2->4, 1->3->4
// 输出：1->1->2->3->4->4

public class MergeTwoLists {
    private class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) {
          this.val = val;
      }
      ListNode(int val, ListNode next) {
          this.val = val; this.next = next;
      }
    }

    /*
    * 按照顺序merge两个链表
    * 用新建节点逐个把节点连接就可以
    * */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode node = new ListNode(0);
        ListNode res = node;
        while(l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                node.next = l2;
                l2 = l2.next;
            } else {
                node.next = l1;
                l1 = l1.next;
            }
            node = node.next;
        }

        if (l1 == null) node.next = l2;
        else node.next = l1;

        return res.next;
    }
}
