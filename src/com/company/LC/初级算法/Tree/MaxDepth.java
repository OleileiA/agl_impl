package com.company.LC.初级算法.Tree;

public class MaxDepth {

    /*
    * 给定一个二叉树，找出其最大深度
    * */
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        else {
            int leftNum = maxDepth(root.left);
            int rightNum = maxDepth(root.right);
            return Math.max(leftNum,  rightNum) + 1;
        }
    }
}
