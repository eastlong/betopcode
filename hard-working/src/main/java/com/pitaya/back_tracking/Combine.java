package com.pitaya.back_tracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description: 77. 组合
 * @Date 2024/05/07 21:26:00
 **/
public class Combine {
    List<List<Integer>> result= new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        backtracking(n,k,1);
        return result;
    }

    /**
     *
     * @param n n个数字
     * @param k 符合要求的k个数字
     * @param startIndex 搜索的起始索引
     */
    public void backtracking(int n, int k , int startIndex) {
        if (path.size() == k) { // 当path符合长度为k的list条件时
            result.add(new ArrayList<>(path));
            return; // 停止当前的循环，而非全局，比如得到 [2,4],就可以步继续下去了
        }
        for (int i = startIndex; i<=n; i++) {
            path.add(i);
            backtracking(n, k, i+1);
            path.removeLast(); // 例如：path中有[1,2],我们必须把2弹出，把3加入，构造成[1,3]
        }
    }

    /**
     * 每次从集合中选取元素，可选择的范围随着选择的进行而收缩，调整可选择的范围，就是要靠startIndex
     * @param startIndex 用来记录本层递归的中，集合从哪里开始遍历（集合就是[1,...,n] ）。
     */
    private void combineHelper(int n, int k, int startIndex){
        //终止条件
        if (path.size() == k){
            result.add(new ArrayList<>(path));
            return;
        }
        // i <= n-(k-path.size()) + 1; 剪枝；比如k=4,n=4,当i遍历到2的时候没有意义，因为从2开始，就凑不够4个数了
        for (int i = startIndex; i <= n - (k - path.size()) + 1; i++){
            path.add(i);
            combineHelper(n, k, i + 1);
            path.removeLast();
        }
    }
}

/**
 * 回溯问题的本质是递归
 * 【组合问题无序，不能重复；排列问题有序，数字可以重复】
 *
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 *
 * 示例: 输入: n = 4, k = 2 输出: [ [2,4], [3,4], [2,3], [1,2], [1,3], [1,4], ]
 *
 *
 * ========================== 回溯算法模板 ===========================
 *
 * void backtracking(参数) {
 *     if (终止条件) {
 *         存放结果;
 *         return;
 *     }
 *
 *     for (选择：本层集合中元素（树中节点孩子的数量就是集合的大小）) {
 *         处理节点;
 *         backtracking(路径，选择列表); // 递归
 *         回溯，撤销处理结果
 *     }
 * }
 */
