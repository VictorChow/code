package me.victor.easy;

/**
 * 给定一个二叉树，找出其最大深度。
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度 3
 */

public class T104_MaximumDepthOfBinaryTree {

    public static void main(String[] args) {
        var node = new TreeNode(3);
        node.left = new TreeNode(9);
        node.right = new TreeNode(20);
        //        node.left.left = new TreeNode(3);
        //        node.left.right = new TreeNode(4);
        node.right.left = new TreeNode(15);
        node.right.right = new TreeNode(7);

        System.out.println(original(node));
        System.out.println(modified(node));
    }

    private static int original(TreeNode root) {
        return check(root, 0);
    }

    private static int check(TreeNode root, int depth) {
        return root == null ? depth : Math.max(check(root.left, depth + 1), check(root.right, depth + 1));
    }

    private static int modified(TreeNode root) {
        if (root == null) return 0;
        return Math.max(modified(root.left), modified(root.right)) + 1;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) { val = x; }
    }
}
