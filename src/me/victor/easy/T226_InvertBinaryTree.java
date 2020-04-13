package me.victor.easy;

/**
 * 翻转一棵二叉树。
 * 示例：
 * 输入：
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 输出：
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 */

public class T226_InvertBinaryTree {

    public static void main(String[] args) {

    }

    private static TreeNode original(TreeNode root) {
        if (root == null) return null;
        var tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        original(root.left);
        original(root.right);
        return root;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) { val = x; }
    }
}
