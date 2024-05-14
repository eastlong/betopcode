package com.pitaya.linkedlist;

import com.pitaya.common.ListNode;

/**
 * @Description: 反转链表
 * @Date 2024/05/08 07:17:00
 **/
public class ReverseList {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode nextNode = cur.next;
            cur.next = prev; // 方向反转 --> 核心步骤
            // 移动
            prev = cur;
            cur = nextNode;
        }

        return prev; // prev实际已经移动到链表最后一个节点，反转后，此时是链表头部
    }


}


/**
 * 206.反转链表
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 */