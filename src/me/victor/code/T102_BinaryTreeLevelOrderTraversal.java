package me.victor.code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import me.victor.code.util.TreeNode;

/**
 * https://leetcode.cn/problems/binary-tree-level-order-traversal/
 */
class T102_BinaryTreeLevelOrderTraversal {

    public static void main(String[] args) {
        var t = new T102_BinaryTreeLevelOrderTraversal();
        TreeNode node = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        System.out.println(t.levelOrder(node));
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return Collections.emptyList();
        var ans = new ArrayList<List<Integer>>();
        var queue = new LinkedList<TreeNode>();
        queue.offer(root);
        do {
            var nums = new ArrayList<Integer>();
            var nodes = new ArrayList<TreeNode>();
            while (!queue.isEmpty()) nodes.add(queue.poll());
            for (TreeNode it : nodes) {
                if (it != null) {
                    nums.add(it.val);
                    queue.offer(it.left);
                    queue.offer(it.right);
                }
            }
            if (!nums.isEmpty()) ans.add(nums);
        } while (!queue.isEmpty());
        return ans;
    }
}
