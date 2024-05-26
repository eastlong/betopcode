package com.pitaya.tree;

import com.pitaya.common.TreeNode;

/**
 * @Description: 翻转二叉树
 * 226
 * @Date 2024/05/26 19:14:00
 **/
public class InvertTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        TreeNode left = invertTree(root.left); // 递归，看做把root的整个左子树翻转
        TreeNode right = invertTree(root.right);

        root.left = right;
        root.right = left;

        return root;
    }
}


/**
 * 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
 *
 * 输入：root = [4,2,7,1,3,6,9]
 * 输出：[4,7,2,9,6,3,1]
 *
 * 输入：root = [2,1,3]
 * 输出：[2,3,1]
 */
