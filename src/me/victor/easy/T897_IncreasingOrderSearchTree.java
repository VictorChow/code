package me.victor.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个树，请你按中序遍历重新排列树，使树中最左边的结点现在是树的根，并且每个结点没有左子结点，只有一个右子结点。
 *
 * 示例 ：
 * 输入：[5,3,6,2,4,null,8,1,null,null,null,7,9]
 *        5
 *       / \
 *     3    6
 *    / \    \
 *   2   4    8
 *  /        / \
 * 1        7   9
 * 输出：[1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
 *  1
 *   \
 *    2
 *     \
 *      3
 *       \
 *        4
 *         \
 *          5
 *           \
 *            6
 *             \
 *              7
 *               \
 *                8
 *                 \
 *                  9
 */

public class T897_IncreasingOrderSearchTree {
    private static final List<TreeNode> list = new ArrayList<>();

    public static void main(String[] args) {
        var head = new TreeNode(5);
        head.left = new TreeNode(3);
        head.left.left = new TreeNode(2);
        head.left.right = new TreeNode(4);
        head.left.left.left = new TreeNode(1);
        head.right = new TreeNode(6);
        head.right.right = new TreeNode(8);
        head.right.right.left = new TreeNode(7);
        head.right.right.right = new TreeNode(9);
        original(head);
    }

    private static TreeNode original(TreeNode root) {
        if (root == null) return null;
        find(root);
        var head = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            head.left = null;
            head.right = list.get(i);
            head = list.get(i);
        }
        return list.get(0);
    }

    private static void find(TreeNode root) {
        if (root == null) return;
        find(root.left);
        list.add(root);
        find(root.right);
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) { val = x; }

        @Override
        public String toString() {
            return String.valueOf(val);
        }
    }
}
