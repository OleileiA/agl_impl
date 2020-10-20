package com.company.LC.初级算法.Tree;

/*
* 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
* 假设一个二叉搜索树具有如下特征：
    1. 节点的左子树只包含小于当前节点的数。
    2. 节点的右子树只包含大于当前节点的数。
    3. 所有左子树和右子树自身必须也是二叉搜索树。
* */
public class IsValidBST {

    /*
    * 利用中序遍历
    * */
    private long pre = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        // 访问左子树
        if (!isValidBST(root.left)) {
            return false;
        }
        // 访问当前节点：如果当前节点小于等于中序遍历的前一个节点，说明不满足BST，返回 false；否则继续遍历。
        // 中序遍历的特点就是左边潜到最深，然后遍历的节点都是pre节点的父节点，所以应该大于，小于等于就返回false
        if (root.val <= pre) {
            return false;
        }
        pre = root.val;
        // 访问右子树
        return isValidBST(root.right);
    }

}
