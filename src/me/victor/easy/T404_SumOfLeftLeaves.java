package me.victor.easy;

/**
 * 计算给定二叉树的所有左叶子之和。
 *
 * 示例：
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
 */

public class T404_SumOfLeftLeaves {

    public static void main(String[] args) {
        var head = new TreeNode(3);
        head.left = new TreeNode(9);
        head.left.left = new TreeNode(20);
        head.right = new TreeNode(20);
        head.right.left = new TreeNode(15);
        head.right.right = new TreeNode(7);
        head.right.right.left = new TreeNode(100);

        System.out.println(original(head));
    }

    private static int original(TreeNode root) {
        if (root == null) return 0;
        var num = 0;
        if (root.left != null && root.left.left == null && root.left.right == null) {
            num += root.left.val;
        }
        return num + original(root.left) + original(root.right);
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) { val = x; }
    }
}
