package me.victor.code;

import java.util.ArrayList;
import java.util.List;

import me.victor.code.util.TreeNode;

/**
 * https://leetcode.cn/problems/binary-tree-inorder-traversal/
 */
public class T94_BinaryTreeInorderTraversal {

    public static void main(String[] args) {

    }

    public List<Integer> inorderTraversal(TreeNode root) {
        var list = new ArrayList<Integer>();
        func(list, root);
        return list;
    }

    private void func(List<Integer> list, TreeNode node) {
        if (node == null) return;
        func(list, node.left);
        list.add(node.val);
        func(list, node.right);
    }
}
