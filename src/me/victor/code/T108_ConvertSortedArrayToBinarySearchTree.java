package me.victor.code;

/**
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 *
 * 示例:
 * 给定有序数组: [-10,-3,0,5,9],
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 */

public class T108_ConvertSortedArrayToBinarySearchTree {

    public static void main(String[] args) {
        System.out.println(original(new int[]{-10, -3, 0, 5, 9}));
    }

    private static TreeNode original(int[] nums) {
        if (nums == null) return null;
        return buildNode(nums, 0, nums.length - 1);
    }

    private static TreeNode buildNode(int[] nums, int start, int end) {
        if (start > end) return null;
        var mid = start + ((end - start) >> 1);
        var root = new TreeNode(nums[mid]);
        root.left = buildNode(nums, start, mid - 1);
        root.right = buildNode(nums, mid + 1, end);
        return root;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) { val = x; }
    }

}
