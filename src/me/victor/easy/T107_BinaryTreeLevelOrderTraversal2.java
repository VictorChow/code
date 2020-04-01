package me.victor.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其自底向上的层次遍历为：
 *
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
 */

public class T107_BinaryTreeLevelOrderTraversal2 {

    public static void main(String[] args) {
        var node = new TreeNode(2);
        node.left = new TreeNode(9);
        node.right = new TreeNode(20);
        node.right.left = new TreeNode(15);
        node.right.right = new TreeNode(7);
        System.out.println(original(node));
    }

    private static List<List<Integer>> original(TreeNode root) {
        var list = new ArrayList<List<Integer>>();
        find(root, list, 0);
        Collections.reverse(list);
        return list;
    }

    private static void find(TreeNode node, List<List<Integer>> list, int depth) {
        if (node == null) return;
        if (depth == list.size()) list.add(new ArrayList<>());
        list.get(depth).add(node.val);
        find(node.left, list, depth + 1);
        find(node.right, list, depth + 1);
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) { val = x; }
    }

}
