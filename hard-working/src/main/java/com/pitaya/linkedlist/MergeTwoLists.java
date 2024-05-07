package com.pitaya.linkedlist;

import com.pitaya.common.ListNode;

/**
 * @Description:
 * @Date 2024/05/07 22:28:00
 **/
public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                p.next = list1;
                list1 = list1.next;
            } else {
                p.next = list2;
                list2 = list2.next;
            }

            p = p.next; // p需要一直向后移动
        }

        if (list1 != null) p.next = list1;
        if (list2 != null) p.next = list2;

        return dummy.next;
    }
}
