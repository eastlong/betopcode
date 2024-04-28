package com.pitaya.linkedlist.lru_cache;

import com.pitaya.linkedlist.totate_right.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 146. LRU 缓存
 * 请你设计并实现一个满足  LRU (最近最少使用) 缓存 约束的数据结构。
 * @Date 2023/09/16 16:40:00
 **/
public class LRUCache {
    class DLinkedNode {
        int key;
        int val;
        DLinkedNode prev;
        DLinkedNode next;
        public DLinkedNode () {}
        public DLinkedNode(int _key, int _value) {
            this.key = _key;
            this.val = _value;
        }
    }

    private Map<Integer, DLinkedNode> cache = new HashMap<>(); // key:index; value:节点值
    private int size; // 缓存的大小
    private int capacity; // 缓存的容量
    private DLinkedNode head, tail; //  head和tail都是虚拟的节点

    // 构造函数：初始化 --> 6个元素
    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    /**
     * get过程：
     * (1) 从缓存中获取key,若key不存在，则返回一个-1
     * (2) 若key存在，则把当前节点移动到最前面，返回 节点的值
     */
    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (null == node) return -1;

        moveToHead(node);

        return node.val;
    }

    /**
     * put 过程
     * (1) 判断node 节点是否存在
     * (2) 如果node 节点不存在
     *  a. 创建新的节点node，并把node放入缓存
     *  b. 把node节点移动到首部
     *  c. 维护size,size++
     *  d. 判断size> capacity? 若大于，则把尾部节点删除，并删除缓存；size--
     *  (2) 如果node节点存在
     *      a. 更新value
     *      b. 把node移动到队首
     */
    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if (null == node) {
            // 创建新的节点node，并把node放入缓存
            DLinkedNode newNode = new DLinkedNode(key, value);
            cache.put(key, newNode);

            // 把node节点移动到首部
            addToHead(newNode);

            // 维护size,size++
            size ++;
            if (size > capacity) {
                DLinkedNode tail = removeTail();
                cache.remove(tail.key);
                size --;
            }
        } else {
            node.val = value;
            moveToHead(node);
        }

    }

    // 将已有的元素移动到链表头部
    // （1）移除当前节点
    // （2）将当前节点移动到链表头部
    private void moveToHead(DLinkedNode node) {
        removeNode(node);

        addToHead(node);
    }

    // 移除某个节点的元素,由于是双向链表，顾及前后,先前再后
    private void removeNode(DLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // 将某个节点移动到头部（不删除原来的节点）
    // 由于是双向链表，因此node 和 head的前后都要顾及，且先前再后
    private void addToHead(DLinkedNode node) {
        node.prev = head; // 这里的head已经是虚拟头节点了，放心使用
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private DLinkedNode removeTail() {
        DLinkedNode node = tail.prev;
        removeNode(node);

        return node;
    }
}
/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

/**
 * 实现 LRUCache 类：
 * ● LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存
 * ● int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * ● void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组 key-value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。
 *
 * 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
 */

//请你设计并实现一个满足 LRU (最近最少使用) 缓存 约束的数据结构。
//
// 实现 LRUCache 类：
//
//
//
//
// LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存
// int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
// void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组 ke
//y-value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。
//
//
// 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
//
//
//
//
//
// 示例：
//
//
//输入
//["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
//[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
//输出
//[null, null, null, 1, null, -1, null, -1, 3, 4]
//