package com.company.Tree;

/*
* 二叉搜索树的实现
* 算法分析：
* 1. 最差时间复杂度会降低为链表O(n)
* 2. 最好为完全二叉树：O(log2n)
*  */
public class BinarySearchTree {

    private Node tree;

    public Node find(int data) {
        Node p = tree;
        while (p != null) {
            if (data > p.data) p = p.right;
            else if (data < p.data) p = p.left;
            else return p;
        }
        return null;
    }

    public void insert(int data) {
        if (tree == null) {
            tree = new Node(data);
            return;
        }
        Node p = tree;
        while (p != null) {
            if (data > p.data) {
                if (p.right == null) {
                    p.right = new Node(data);
                    return;
                }
                p = p.right;
            } else {
                if (p.left == null) {
                    p.left = new Node(data);
                    return;
                }
                p = p.left;
            }
        }
    }

    /*
    * 一般来说删除有两种方式：
    * 1. 真正的删除
    * 2. 标记为删除，这样比较省事
    * 这里采用真正删除的方式
    *
    * 真正的删除需要做的事情：
    * 1. 被删除的节点没有子节点，直接将其设置为null。
    * 2. 被删除的节点只有一个节点，那么不管是左节点还是右节点, 直接指向被删除的节点就完了。
    * 3. 如果分别有左子树和右子树，要使用右子树中最小的节点替换。
    * */
    public void delete(int data) {
        Node p = tree; // p指向要删除的节点，初始化指向根节点
        Node pp = null; // pp记录的是p的父节点
        while (p != null && p.data != data) {
            pp = p;
            if (data > p.data) p = p.right;
            else p = p.left;
        }
        if (p == null) return; // 没有找到

        // 要删除的节点有两个子节点
        if (p.left != null && p.right != null) { // 查找右子树中最小节点
            Node minP = p.right;
            Node minPP = p; // minPP表示minP的父节点
            while (minP.left != null) {
                minPP = minP;
                minP = minP.left;
            }
            p.data = minP.data; // 将minP的数据替换到p中
            p = minP; // 下面就变成了删除minP了
            pp = minPP;
        }

        // 删除节点是叶子节点或者仅有一个子节点
        Node child; // p的子节点
        if (p.left != null) child = p.left;
        else if (p.right != null) child = p.right;
        else child = null;

        if (pp == null) tree = child; // 删除的是根节点
        else if (pp.left == p) pp.left = child;
        else pp.right = child;
    }

    private class Node {
        private int data;
        private Node left;
        private Node right;
        public Node(int data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "Node{" +
                "data=" + data +
                '}';
        }
    }

    /* 前序 */
    public void preOrder(Node tree) {
        if (tree == null) return;
        System.out.println(tree.data);
        preOrder(tree.left);
        preOrder(tree.right);
    }
    /* 中序 */
    public void inOrder(Node tree) {
        if (tree == null) return;
        inOrder(tree.left);
        System.out.println(tree.data);
        inOrder(tree.right);
    }
    /* 后序 */
    public void postOrder(Node tree) {
        if (tree == null) return;
        postOrder(tree.left);
        postOrder(tree.right);
        System.out.println(tree.data);
    }

    @Override
    public String toString() {
        preOrder(tree);
        return "end";
    }

    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.insert(3);
        binarySearchTree.insert(1);
        binarySearchTree.insert(2);
        binarySearchTree.insert(4);
        binarySearchTree.insert(5);
        binarySearchTree.insert(6);

        binarySearchTree.delete(3);
        binarySearchTree.delete(6);
        binarySearchTree.delete(5);
//        binarySearchTree.delete(4);
//        binarySearchTree.delete(1);
//        binarySearchTree.delete(2);
        System.out.print(binarySearchTree);
    }
}
