package com.company.Tree;

/*
* 二叉搜索树的实现， 是一个高度平衡的二叉树
*  */
public class AVLTree<E extends Comparable<E>> {

    private Node root;

    private int size;

    public AVLTree() {
        root = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /*
    * 获取平衡因子,注意这里或者平衡因子的时候只获取其左右两个节点的高度
    * 因为高度是从下向上，从0开始的。如果树不平衡那么左右的height会不同
    *  */
    private int getBalanceFactor(Node node) {
        if (node == null) return 0;
        return getHeight(node.left) - getHeight(node.right);
    }

    /*
    * 获取节点高度
    *  */
    private int getHeight(Node node) {
        if (node == null) return 0;
        return node.height;
    }

    public boolean isBalanced() {
        return isBalanced(root);
    }

    private boolean isBalanced(Node node) {
        if (node == null) return true;
        int factor = Math.abs(getBalanceFactor(node));
        if (factor > 1) return false;
        return isBalanced(node.left) && isBalanced(node.right);
    }



    /*
     * AVL树节点的实现，最大的特点是带有height字段
     *  */
    private class Node {
        private E e;
        private Node left;
        private Node right;
        private int height; // 表示节点所在的高度, 为了方便计算平衡因子

        public Node(E e) {
            this.e = e;
            this.left = null;
            this.right = null;
            this.height = 1;
        }
    }


    public static void main(String[] args) {

    }
}
