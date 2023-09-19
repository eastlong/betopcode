package com.pitaya.common;

/**
 * @Description:
 * @Date 2023/09/18 06:35:00
 **/
public class ListNode {
    public int val;
    public ListNode next;

    ListNode() {}
    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
