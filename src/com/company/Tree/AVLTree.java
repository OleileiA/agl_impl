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

    // 右旋实现, 注意右旋时，我们持有y节点，也就是最高的节点
    private Node rightRotate(Node y) {
        Node x = y.left;
        Node t3 = x.right;
        x.right = y;
        y.left = t3;
        // 更新height, 各取左右节点最大的+1
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;
        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
        return x; // 返回最高节点
    }

    // 左旋
    private Node leftRotate(Node y) {
        Node x = y.right;
        Node t3 = x.left;
        x.left = y;
        y.right = t3;
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;
        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
        return x;
    }

    // 增加节点
    public void add(E data) {
        root = add(root, data);
    }

    private Node add(Node node, E data) {
        /*----- 增加逻辑 -----*/

        if (node == null) { // 终止条件，找到了根上，可以插入了。
            size++;
            return new Node(data);
        }
        if (data.compareTo(node.data) > 0)
            node.right = add(node.right, data);
        else
            node.left = add(node.left, data);

        // 更新年height
        node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;

        /* ----- 调整逻辑 ------ */
        int balanceFactor = getBalanceFactor(node);

        // LL
        if (balanceFactor > 1 && getBalanceFactor(node.left) > 0) {
            return rightRotate(node);
        }

        // RR
        if (balanceFactor < -1 && getBalanceFactor(node.right) < 0) {
            return leftRotate(node);
        }

        // LR
        if (balanceFactor > 1 && getBalanceFactor(node.left) < 0) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // RL
        if (balanceFactor < -1 && getBalanceFactor(node.right) > 0) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    // 删除节点
    public E delete(E data) {
        Node node = delete(root, data);
        if (node == null) return null;
        return node.data;
    }

    // 思路和add类似，利用递归
    private Node delete(Node node, E data) {
        if (node == null) return null;

        Node saveNode;
        if (data.compareTo(node.data) > 0) {
            node.right = delete(node.right, data);
            saveNode = node;
        }
        else if (data.compareTo(node.data) < 0) {
            node.left = delete(node.left, data);
            saveNode = node;
        }
        else {
            // 找到了节点，开始正常的二叉树删除逻辑
            if (node.left == null){
                Node rightNode = node.right;
                node.right = null;
                size --;
                saveNode = rightNode;
            }
            // 待删除节点右子树为空的情况
            else if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size --;
                saveNode = leftNode;
            }
            else {
                Node min = findMinNode(node.right);
                min.right = delete(node.right, min.data);
                min.left = node.left;
                node.left = node.right = null;
                saveNode = min;
            }
        }

        if (saveNode == null) return null;

        // 更新年height
        saveNode.height = Math.max(getHeight(saveNode.left), getHeight(saveNode.right)) + 1;

        /* ----- 调整逻辑 ------ */
        int balanceFactor = getBalanceFactor(saveNode);

        // LL
        if (balanceFactor > 1 && getBalanceFactor(saveNode.left) > 0) {
            return rightRotate(saveNode);
        }

        // RR
        if (balanceFactor < -1 && getBalanceFactor(node.right) < 0) {
            return leftRotate(saveNode);
        }

        // LR
        if (balanceFactor > 1 && getBalanceFactor(node.left) < 0) {
            saveNode.left = leftRotate(saveNode.left);
            return rightRotate(saveNode);
        }

        // RL
        if (balanceFactor < -1 && getBalanceFactor(saveNode.right) > 0) {
            node.right = rightRotate(saveNode.right);
            return leftRotate(saveNode);
        }

        return saveNode;
    }

    //二叉搜索树的最小值一直找左孩子就行了
    private Node findMinNode(Node node){
        if(node.left == null) return node;
        return findMinNode(node.left);
    }

    /*
     * AVL树节点的实现，最大的特点是带有height字段
     *  */
    private class Node {
        private E data;
        private Node left;
        private Node right;
        private int height; // 表示节点所在的高度, 为了方便计算平衡因子

        public Node(E data) {
            this.data = data;
            this.left = null;
            this.right = null;
            this.height = 1;
        }
    }

    public static void main(String[] args) {
        AVLTree<Integer> avlTree = new AVLTree<>();

        avlTree.add(5);
        avlTree.add(4);
        avlTree.add(3);
        avlTree.add(2);
        avlTree.add(1);
        avlTree.add(6);
        avlTree.add(7);
        avlTree.add(8);
        avlTree.add(9);

//        avlTree.delete(5);
//        avlTree.delete(4);
//        avlTree.delete(2);
//        avlTree.delete(3);
//        avlTree.delete(1);
//        avlTree.delete(6);
//        avlTree.delete(7);
//        avlTree.delete(8);
//        avlTree.delete(9);

        System.out.println(avlTree);
    }


    private void preOrder(Node node) {
        if (node == null) return;
        System.out.println(node.data);
        preOrder(node.left);
        preOrder(node.right);
    }

    @Override
    public String toString() {
        preOrder(root);
        return "end";
    }
}
