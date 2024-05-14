package com.pitaya.linkedlist;

import com.pitaya.common.ListNode;

/**
 * @Description: 相交链表
 * @Date 2024/05/08 07:33:00
 **/
public class GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode pA = headA, pB = headB;
        while (pA != pB) { // 第一种情况：有相交点，则会退出；第二种情况，没有相交点，但是pA，pB移动完成之后都会同时移动到null,相等，也会退出
            pA = (pA == null) ? headB : pA.next;
            pB = (pB == null) ? headA : pB.next;
        }

        // pA在headA和headB走了一遍，pB在headB和headA走了一遍，最后肯定会相交或者 pa=pb=null
        return pA;
    }
}

/**
 * 160.相交链表
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
 *
 */
