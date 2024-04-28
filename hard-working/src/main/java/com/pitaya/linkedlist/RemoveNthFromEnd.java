package com.pitaya.linkedlist;

import com.pitaya.common.ListNode;

/**
 * @Description:
 * https://github.com/yuanguangxin/LeetCode/tree/master
 * @Date 2023/09/18 06:59:00
 **/
public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        int length = getLength(head);
        ListNode cur= dummy;
        for (int i = 0; i < length - n; i++) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return dummy.next;
    }

    public int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            length ++;
            head = head.next;
        }

        return length;
    }
}
