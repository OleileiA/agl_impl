package com.company.Tree;

public class RedBlackBST <Key extends Comparable<Key>, Value> {

    private Node root;

    // 定义颜色
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    // 节点
    private class Node {
        Key key;
        Value val;
        int N; // 这个子树的节点总数
        Node left;
        Node right;
        boolean color;

        Node (Key key, Value value, int N, boolean color) {
            this.key = key;
            this.val = value;
            this.N = N;
            this.color = color;
        }
    }

    // 判断是否是红色节点(红色连接的左节点)
    private boolean isRed(Node node) {
        if (node == null) return false;
        return node.color == RED;
    }

    // 返回当前节点子树的节点个数
    private int size(Node node) {
        if (node == null) return 0;
        return node.N;
    }

    // 左旋
    private Node rotateLeft(Node h) {
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        x.N = h.N;
        h.N = size(h.left) + size(h.right) + 1;
        return x;
    }

    // 右旋
    private Node rotateRight(Node h) {
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = size(h.left) + size(h.right) + 1;
        return x;
    }

    // 颜色转换， 专门用来转换一个节点两个红色子节点的颜色
    private void flipColors(Node h) {
        h.color = RED; // 为什么当前节点要设置成红色，暂时不清楚
        h.left.color = BLACK;
        h.right.color = BLACK;
    }

    // 放入新的元素
    public void put(Key key, Value value) {
        root = put(root, key, value);
        root.color = BLACK;
    }

    // 内部实现(非常漂亮的递归， 我想把红黑树的实现背下来)
    private Node put(Node h, Key key, Value val) {

        if (h == null) return new Node(key, val, 1, RED);
        int cmp = key.compareTo(h.key);
        if (cmp < 0) h.left = put(h.left, key, val);
        if (cmp > 0) h.right = put(h.right, key, val);
        else h.val = val;

        if (isRed(h.right) && !isRed(h.left)) h = rotateLeft(h);
        if (isRed(h.left) && isRed(h.left.left)) h = rotateRight(h);
        if (isRed(h.left) && isRed(h.right)) flipColors(h);

        h.N = size(h.left) + size(h.right) + 1;

        return h;
    }
}
