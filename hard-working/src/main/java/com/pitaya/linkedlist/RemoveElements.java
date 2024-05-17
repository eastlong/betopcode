package com.pitaya.linkedlist;

import com.pitaya.common.ListNode;

/**
 * @Description: 移除链表元素
 * @Date 2024/05/15 08:28:00
 **/
public class RemoveElements {
    public ListNode removeElements(ListNode head, int val) {
        if (null == head) return null;

        ListNode dummy = new ListNode(-1, head);
        ListNode pre = dummy;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next; // 移除元素
            } else {
                pre = cur; // 如果不是val，只需要继续执行 （pre前移动）
            }
            cur = cur.next; // cur 迁移
        }

        return dummy.next;
    }
}


/**
 * 203. 移除链表元素
 * 题意：删除链表中等于给定值 val 的所有节点。
 *
 * 示例 1： 输入：head = [1,2,6,3,4,5,6], val = 6 输出：[1,2,3,4,5]
 *
 * 示例 2： 输入：head = [], val = 1 输出：[]
 *
 * 示例 3： 输入：head = [7,7,7,7], val = 7 输出：[]
 *
 * public ListNode removeElements(ListNode head, int val) {
 *     if (head == null) {
 *         return head;
 *     }
 *     // 因为删除可能涉及到头节点，所以设置dummy节点，统一操作
 *     ListNode dummy = new ListNode(-1, head);
 *     ListNode pre = dummy;
 *     ListNode cur = head;
 *     while (cur != null) {
 *         if (cur.val == val) {
 *             pre.next = cur.next;
 *         } else {
 *             pre = cur;
 *         }
 *         cur = cur.next;
 *     }
 *     return dummy.next;
 * }
 *
 *
 */