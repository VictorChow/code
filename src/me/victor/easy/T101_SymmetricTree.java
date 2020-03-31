package me.victor.easy;

/**
 * 给定一个二叉树，检查它是否是镜像对称的。
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 *
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 *
 * 说明:
 * 如果你可以运用递归和迭代两种方法解决这个问题，会很加分。
 */

public class T101_SymmetricTree {

    public static void main(String[] args) {
        var node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(2);
        node.left.left = new TreeNode(3);
        node.left.right = new TreeNode(4);
        node.right.left = new TreeNode(4);
        node.right.right = new TreeNode(3);

        //        var node = new TreeNode(1);
        //        node.left = new TreeNode(2);
        //        node.right = new TreeNode(2);
        //        //        node.left.left = new TreeNode(3);
        //        node.left.right = new TreeNode(3);
        //        node.right.left = new TreeNode(3);
        //        //        node.right.right = new TreeNode(3);

        System.out.println(original(node));

    }

    public static boolean original(TreeNode root) {
        return (root == null) || check(root, root);
    }

    private static boolean check(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        return left.val == right.val && check(left.left, right.right) && check(left.right, right.left);
    }

    public static class TreeNode {
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
