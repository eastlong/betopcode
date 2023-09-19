package com.pitaya.linkedlist.totate_right;

/**
 * @Description:
 * 给你一个链表的头节点 head ，然后将链表每个节点向右移动 k 个位置。
 * head = [1,2,3,4,5]，k = 2，我们输出[4,5,1,2,3]
 * @Date 2023/09/19 07:16:00
 **/
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) return head;

        int n = 0; // 链表的长度
        ListNode tail = null;
        for (ListNode p = head; p != null; p = p.next) {
            tail = p;
            n ++;
        }

        k = k % n; // 防止k超过链表长度
        ListNode p = head;
        for (int i = 0; i < n-k-1; i++) {
            p = p.next;
        }

        // 节点移动
        tail.next = head;
        head = p.next;
        p.next = null;

        return head; // 返回新的头节点
    }

}
