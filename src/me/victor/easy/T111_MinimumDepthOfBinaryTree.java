package me.victor.easy;

/**
 * 给定一个二叉树，找出其最小深度。
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最小深度  2.
 */

public class T111_MinimumDepthOfBinaryTree {

    public static void main(String[] args) {
        var node = new TreeNode(3);
        node.left = new TreeNode(9);
        node.right = new TreeNode(20);
        node.left.left = new TreeNode(3);
        //        node.left.right = new TreeNode(4);
        node.right.left = new TreeNode(15);
        node.right.right = new TreeNode(7);

        System.out.println(original(node));
        System.out.println(official(node));
    }

    private static int original(TreeNode root) {
        if (root == null) return 0;
        int[] min = new int[]{Integer.MAX_VALUE};
        check(root, 1, min);
        return min[0];
    }

    private static int official(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        var minDepth = Integer.MAX_VALUE;
        if (root.left != null) minDepth = Math.min(official(root.left), minDepth);
        if (root.right != null) minDepth = Math.min(official(root.right), minDepth);
        return minDepth + 1;
    }

    private static void check(TreeNode node, int depth, int[] min) {
        if (node == null) return;
        if (node.left == null && node.right == null) min[0] = Math.min(depth, min[0]);
        check(node.left, depth + 1, min);
        check(node.right, depth + 1, min);
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) { val = x; }
    }
}
