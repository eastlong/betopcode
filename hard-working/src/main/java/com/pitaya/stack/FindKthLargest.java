package com.pitaya.stack;

import java.util.Comparator;
import java.util.PriorityQueue;

public class FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        // step1: 构建最小堆
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k, Comparator.comparingInt(a -> a));
        // step2: 先在堆里面放进k个元素。
        for (int i=0 ; i < k; i++) {
            minHeap.offer(nums[i]);
        }
        // step3: 遇到比堆顶元素大的就替换堆顶元素，并把替换后的堆顶元素重新放入堆中。
        for (int i=k; i < len; i++) {
            if (nums[i] > minHeap.peek()) {
                minHeap.poll();
                minHeap.offer(nums[i]);
            }
        }

        return minHeap.peek();
    }
}
