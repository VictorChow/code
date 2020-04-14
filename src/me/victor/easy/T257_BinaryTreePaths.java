package me.victor.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 * 输入:
 *
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 *
 * 输出: ["1->2->5", "1->3"]
 * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
 */

public class T257_BinaryTreePaths {

    public static void main(String[] args) {
        var head = generate();
        System.out.println(original(head));
    }

    private static TreeNode generate() {
        var head = new TreeNode(6);
        head.left = new TreeNode(2);
        head.left.left = new TreeNode(0);
        head.left.right = new TreeNode(4);
        head.left.right.left = new TreeNode(3);
        head.left.right.right = new TreeNode(5);
        head.right = new TreeNode(8);
        head.right.left = new TreeNode(7);
        head.right.right = new TreeNode(9);
        return head;
    }

    private static List<String> original(TreeNode root) {
        var paths = new ArrayList<String>();
        find(root, new ArrayList<>(), paths);
        return paths;
    }

    private static void find(TreeNode node, List<String> nodes, List<String> paths) {
        if (node == null) return;
        nodes.add(String.valueOf(node.val));
        if (node.left == null && node.right == null) paths.add(String.join("->", nodes));
        find(node.left, nodes, paths);
        find(node.right, nodes, paths);
        nodes.remove(nodes.size() - 1);
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) { val = x; }
    }
}
