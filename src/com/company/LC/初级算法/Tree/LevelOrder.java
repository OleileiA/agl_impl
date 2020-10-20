package com.company.LC.初级算法.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
*
* 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
*   3
   / \
  9  20
    /  \
   15   7

   [
  [3],
  [9,20],
  [15,7]
]
* */
public class LevelOrder {

    /*
    *  使用广度优先级遍历, 注意队列的使用。
    * */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        if (root == null) return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            List<Integer> level = new ArrayList<Integer>();
            int curSize = q.size();
            for (int i = 0; i < curSize; i++) {
                TreeNode node = q.poll();
                level.add(node.val);
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }
            result.add(level);
        }
        return result;
    }
}
