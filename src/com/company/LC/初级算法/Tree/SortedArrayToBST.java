package com.company.LC.初级算法.Tree;

/*
  将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
  本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。

  给定有序数组: [-10,-3,0,5,9], 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：

      0
     / \
   -3   9
   /   /
 -10  5

* */
public class SortedArrayToBST {


    /*
    * BST的中序遍历递增的，所以这个数组直接还原就可以
    * 你可以随便找一个节点，其左边的元素是其左子树，右边的元素是右子树
    * 所以找中间的节点比较平衡
    * */
    public TreeNode sortedArrayToBST(int[] nums) {
        return makeTree(nums, 0, nums.length - 1);
    }

    private TreeNode makeTree(int[] nums, int s, int e) {
        if (s > e) return null;
        int mid = s + (e - s) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = makeTree(nums, s, mid - 1);
        node.right = makeTree(nums, mid + 1, e);
        return node;
    }
}
