package com.pitaya.tree;

import com.pitaya.common.TreeNode;

/**
 * @Description:对称二叉树
 * 101
 * @Date 2024/05/26 16:33:00
 **/
public class IsSymmetric {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;

        return cmp(root.left, root.right);
    }


    /**
     * 递归判断
     * @param node1
     * @param node2
     * @return
     */
    private boolean cmp(TreeNode node1, TreeNode node2) {
        // 递归第一步：设值递归终止条件
        if (node1 == null && node2 == null) return true;

        if (node1 == null || node2 == null || node1.val != node2.val) {
            return false;
        }

        // 递归遍历当前左右节点的子节点
        return cmp(node1.left, node2.right) && cmp(node1.right, node2.left);
    }
}

/**
 * 【题目描述】给你一个二叉树的根节点 root ， 检查它是否轴对称。
 * 输入：root = [1,2,2,3,4,4,3]
 * 输出：true
 *
 * 输入：root = [1,2,2,null,3,null,3]
 * 输出：false
 *
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
