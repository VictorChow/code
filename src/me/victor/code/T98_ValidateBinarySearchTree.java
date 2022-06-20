package me.victor.code;

import me.victor.code.util.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class T98_ValidateBinarySearchTree {
    private long pre = Long.MIN_VALUE;


    public static void main(String[] args) {
        var t = new T98_ValidateBinarySearchTree();


    }

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        if (!isValidBST(root.left)) return false;
        if (root.val <= pre) return false;
        pre = root.val;
        return isValidBST(root.right);
    }

    public boolean isValidBST2(TreeNode root) {
        return isValidBST2(root, new HashMap<>(), new HashMap<>());
    }

    public boolean isValidBST2(TreeNode root, Map<TreeNode, Long> max, Map<TreeNode, Long> min) {
        if (root == null) return true;
        var lMax = max(max, root.left);
        var rMin = min(min, root.right);
        var b = root.val > lMax && root.val < rMin;
        return b && isValidBST2(root.left, max, min) && isValidBST2(root.right, max, min);
    }

    private long max(Map<TreeNode, Long> max, TreeNode node) {
        if (node == null) return Long.MIN_VALUE;
        if (max.containsKey(node)) return max.get(node);
        var val = Math.max(Math.max(node.val, max(max, node.left)), max(max, node.right));
        max.put(node, val);
        return val;
    }

    private long min(Map<TreeNode, Long> min, TreeNode node) {
        if (node == null) return Long.MAX_VALUE;
        if (min.containsKey(node)) return min.get(node);
        var val = Math.min(Math.min(node.val, min(min, node.left)), min(min, node.right));
        min.put(node, val);
        return val;
    }
}
