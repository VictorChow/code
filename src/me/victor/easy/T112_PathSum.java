package me.victor.easy;

/**
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例: 
 * 给定如下二叉树，以及目标和 sum = 22，
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \      \
 *         7    2      1
 * 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
 */

public class T112_PathSum {

    public static void main(String[] args) {
        var node = new TreeNode(5);
        node.left = new TreeNode(4);
        node.right = new TreeNode(8);
        node.left.left = new TreeNode(11);
        node.right.left = new TreeNode(13);
        node.right.right = new TreeNode(4);
        node.left.left.left = new TreeNode(7);
        node.left.left.right = new TreeNode(2);
        node.right.right = new TreeNode(1);
        System.out.println(original(node, 22));
        System.out.println(modified(node, 22));

        var node2 = new TreeNode(-2);
        node2.right = new TreeNode(-3);
        System.out.println(original(node2, -5));
        System.out.println(modified(node2, -5));
    }

    private static boolean original(TreeNode root, int sum) {
        return check(root, sum, 0);
    }

    private static boolean modified(TreeNode root, int sum) {
        if (root == null) return false;
        if (root.left == null && root.right == null) {
            return sum - root.val == 0;
        }
        return modified(root.left, sum - root.val) || modified(root.right, sum - root.val);
    }

    private static boolean check(TreeNode node, int sum, int tmp) {
        if (node == null) return false;
        if (node.left == null && node.right == null) {
            if (tmp + node.val == sum) return true;
        }
        return check(node.left, sum, tmp + node.val) || check(node.right, sum, tmp + node.val);
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) { val = x; }
    }
}
