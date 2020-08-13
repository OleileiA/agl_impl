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

    /* 自己实现一遍delete */
    public void delete2(int data) {
        Node father_p = null; // 当前节点的父节点
        Node p = tree;  // 当前节点

        while (p != null && p.data != data) {
            father_p = p;
            if (data > p.data) p = p.right;
            else p = p.left;
        }
        if (p == null) return; // 没有找到


        /*
        * 当搜索的到目标节点左右两边都有子树的情况下
        *
        * 备注：当前节点左右都有子树要和其他情况区分开的原因是：
        * 只有一边子树的时候直接使用子树替换节点就行了。
        * 都有子树需要把右子树的最小节点替换当前节点，维持二叉树，如果也直接替换，那么右子树的左节点和当前节点的左子树冲突了。（想象一下那个画面）
         *  */
        if (p.left != null && p.right != null) {
            Node minFather = p;
            Node min = p.right;
            while (min.left != null) {
                minFather = min;
                min = min.left;
            }
            p.data = min.data; // 注意这里，直接交换值，不需要交换元素

            // 重新设置father_p和p准备删除
            father_p = minFather;
            p = min;
        }

        // 当前节点是叶子节点或者只有一个边子树
        Node child;
        if (p.left != null) child = p.left;
        else if (p.right != null) child = p.right;
        else child = null; // 没有子节点

        // 注意这里的赋值行为直接删除了p
        if (father_p == null) tree = child;
        else if (father_p.left == p) father_p.left = child;
        else father_p.right = child;
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
        show(tree);
        return "";
    }
    public static int getTreeDepth(Node root) {
        return root == null ? 0 : (1 + Math.max(getTreeDepth(root.left), getTreeDepth(root.right)));
    }
    private static void writeArray(Node currNode, int rowIndex, int columnIndex, String[][] res, int treeDepth) {
        // 保证输入的树不为空
        if (currNode == null) return;
        // 先将当前节点保存到二维数组中
        res[rowIndex][columnIndex] = String.valueOf(currNode.data);

        // 计算当前位于树的第几层
        int currLevel = ((rowIndex + 1) / 2);
        // 若到了最后一层，则返回
        if (currLevel == treeDepth) return;
        // 计算当前行到下一行，每个元素之间的间隔（下一行的列索引与当前元素的列索引之间的间隔）
        int gap = treeDepth - currLevel - 1;

        // 对左儿子进行判断，若有左儿子，则记录相应的"/"与左儿子的值
        if (currNode.left != null) {
            res[rowIndex + 1][columnIndex - gap] = "/";
            writeArray(currNode.left, rowIndex + 2, columnIndex - gap * 2, res, treeDepth);
        }

        // 对右儿子进行判断，若有右儿子，则记录相应的"\"与右儿子的值
        if (currNode.right != null) {
            res[rowIndex + 1][columnIndex + gap] = "\\";
            writeArray(currNode.right, rowIndex + 2, columnIndex + gap * 2, res, treeDepth);
        }
    }
    public static void show(Node root) {
        if (root == null) System.out.println("EMPTY!");
        // 得到树的深度
        int treeDepth = getTreeDepth(root);

        // 最后一行的宽度为2的（n - 1）次方乘3，再加1
        // 作为整个二维数组的宽度
        int arrayHeight = treeDepth * 2 - 1;
        int arrayWidth = (2 << (treeDepth - 2)) * 3 + 1;
        // 用一个字符串数组来存储每个位置应显示的元素
        String[][] res = new String[arrayHeight][arrayWidth];
        // 对数组进行初始化，默认为一个空格
        for (int i = 0; i < arrayHeight; i ++) {
            for (int j = 0; j < arrayWidth; j ++) {
                res[i][j] = " ";
            }
        }

        // 从根节点开始，递归处理整个树
        // res[0][(arrayWidth + 1)/ 2] = (char)(root.val + '0');
        writeArray(root, 0, arrayWidth/ 2, res, treeDepth);

        // 此时，已经将所有需要显示的元素储存到了二维数组中，将其拼接并打印即可
        for (String[] line: res) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < line.length; i ++) {
                sb.append(line[i]);
                if (line[i].length() > 1 && i <= line.length - 1) {
                    i += line[i].length() > 4 ? 2: line[i].length() - 1;
                }
            }
            System.out.println(sb.toString());
        }
    }

    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.insert(3);
        binarySearchTree.insert(1);
        binarySearchTree.insert(2);
//        binarySearchTree.insert(4);
//        binarySearchTree.insert(5);
//        binarySearchTree.insert(6);

//        binarySearchTree.delete2(3);
//        binarySearchTree.delete2(6);
//        binarySearchTree.delete2(5);
//        binarySearchTree.delete2(4);
//        binarySearchTree.delete2(1);
//        binarySearchTree.delete2(2);
        System.out.print(binarySearchTree);
    }
}
