package com.company.InAction.LinkedList;


import java.util.List;

/*

https://leetcode-cn.com/problems/swap-nodes-in-pairs/

给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。

 输入：head = [1,2,3,4]
 输出：[2,1,4,3]
* */
public class SwapPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode dump = new ListNode(0);
        dump.next = head;
        ListNode temp = dump;
        while (temp.next != null &&  temp.next.next != null) {
            ListNode fir = temp.next;
            ListNode sec = temp.next.next;
            temp.next = sec;
            fir.next = sec.next;
            sec.next = fir;
            temp = fir;
        }
        return dump.next;
    }
}
