package com.company.LC.初级算法.Tree;

/*
* 给定一个二叉树，检查它是否是镜像对称的。
*
* 进阶： 你可以运用递归和迭代两种方法解决这个问题吗？
* */
public class IsSymmetric {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return goDeep(root.left, root.right);
    }

    // 递归
    private boolean goDeep(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        if (left.val != right.val) return false;
        return goDeep(left.left, right.right) && goDeep(left.right, right.left);
    }
}
