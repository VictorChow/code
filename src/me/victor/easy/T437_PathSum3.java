package me.victor.easy;

/**
 * 给定一个二叉树，它的每个结点都存放着一个整数值。
 * 找出路径和等于给定数值的路径总数。
 * 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 * 二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。
 *
 * 示例：
 * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
 *
 *       10
 *      /  \
 *     5   -3
 *    / \    \
 *   3   2   11
 *  / \   \
 * 3  -2   1
 *
 * 返回 3。和等于 8 的路径有:
 * 1.  5 -> 3
 * 2.  5 -> 2 -> 1
 * 3.  -3 -> 11
 */

public class T437_PathSum3 {

    public static void main(String[] args) {
        //        var node = new TreeNode(10);
        //        node.right = new TreeNode(-3);
        //        node.right.right = new TreeNode(11);
        //        node.left = new TreeNode(5);
        //        node.left.left = new TreeNode(3);
        //        node.left.right = new TreeNode(2);
        //        node.left.left.left = new TreeNode(3);
        //        node.left.left.right = new TreeNode(-2);
        //        node.left.right.right = new TreeNode(1);
        //        System.out.println(pathSum(node, 8));
        var node = new TreeNode(1);
        node.left = new TreeNode(-2);
        node.right = new TreeNode(-3);
        node.right.left = new TreeNode(-2);
        node.left.left = new TreeNode(-1);
        node.left.right = new TreeNode(3);
        node.left.left.left = new TreeNode(-1);
        System.out.println(pathSum(node, 3));
    }

    private static int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        return find(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    private static int find(TreeNode node, int sum) {
        if (node == null) return 0;
        sum -= node.val;
        var r = sum == 0 ? 1 : 0;
        return r + find(node.left, sum) + find(node.right, sum);
    }

    private static void find(TreeNode node, int targetSum, int[] num, int rootSum, boolean asRoot) {
        if (node == null) return;
        if (rootSum + node.val == targetSum) num[0]++;
        if (!asRoot) {
            find(node.left, targetSum, num, rootSum + node.val, false);
            find(node.right, targetSum, num, rootSum + node.val, false);
        }
        find(node.left, targetSum, num, 0, true);
        find(node.right, targetSum, num, 0, true);
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) { val = x; }
    }
}
