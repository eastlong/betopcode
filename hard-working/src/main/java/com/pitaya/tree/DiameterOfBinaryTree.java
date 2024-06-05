package com.pitaya.tree;

import com.pitaya.common.TreeNode;

/**
 * @Description:二叉树的直径
 * 543
 * @Date 2024/05/26 19:23:00
 **/
public class DiameterOfBinaryTree {
    int ans = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return ans;
    }

    public int depth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int Left = depth(node.left);
        int Right = depth(node.right);
        ans = Math.max(Left + Right, ans); //将每个节点最大直径(左子树深度+右子树深度)当前最大值比较并取大者
        return Math.max(Left, Right) + 1; // 这里已经计算了根节点的深度
    }
}

/**
 * https://leetcode.cn/problems/diameter-of-binary-tree/description/
 * 给你一棵二叉树的根节点，返回该树的 直径 。
 *
 * 二叉树的 直径 是指树中任意两个节点之间最长路径的 长度 。这条路径可能经过也可能不经过根节点 root 。
 *
 * 两节点之间路径的 长度 由它们之间边数表示。
 */
