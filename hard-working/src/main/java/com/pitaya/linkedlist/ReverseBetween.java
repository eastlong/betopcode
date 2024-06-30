package com.pitaya.linkedlist;

import com.pitaya.common.ListNode;

/**
 * @Description: 反转链表2
 * @Date 2024/06/26 22:07:00
 **/
public class ReverseBetween {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode now = dummyNode, pre = dummyNode;
        for(int i=0; i<left; i++){
            pre = now;
            now = now.next;
        }
        pre.next = reverse(now, right-left);
        return dummyNode.next;
    }

    private ListNode reverse(ListNode head, int k){
        ListNode pre = null;
        ListNode now = head;
        while(k >= 0){
            ListNode temp = now.next;
            now.next = pre;
            pre = now;
            now = temp;
            k--;
        }
        head.next = now;
        return pre;
    }
}

/**
 * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 *
 * 输入： head = [1,2,3,4,5], left = 2, right = 4
 * 输出： [1,4,3,2,5]
 *
 * 示例 2：
 *
 * 输入： head = [5], left = 1, right = 1
 * 输出： [5]
 */
