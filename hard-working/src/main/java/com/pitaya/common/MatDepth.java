package com.pitaya.common;

/**
 * @Description: 二叉树的最大深度
 * 104
 * @Date 2024/05/26 16:44:00
 **/
public class MatDepth {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int leftDepth = maxDepth(root.left);
            int rightDepth = maxDepth(root.right);
            return Math.max(leftDepth, rightDepth);
        }
    }
}
