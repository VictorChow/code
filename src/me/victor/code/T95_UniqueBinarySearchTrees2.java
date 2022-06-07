package me.victor.code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import me.victor.code.util.TreeNode;

/**
 * https://leetcode.cn/problems/unique-binary-search-trees-ii/
 */
class T95_UniqueBinarySearchTrees2 {

    public static void main(String[] args) {
        var t = new T95_UniqueBinarySearchTrees2();
        t.generateTrees(3);
    }

    public List<TreeNode> generateTrees(int n) {
        return generateTrees(1, n);
    }

    public List<TreeNode> generateTrees(int l, int r) {
        if (l > r) return Collections.singletonList(null);
        var list = new ArrayList<TreeNode>();
        for (int i = l; i <= r; i++) {
            var left = generateTrees(l, i - 1);
            var right = generateTrees(i + 1, r);
            for (TreeNode lNode : left) {
                for (TreeNode rNode : right) {
                    var node = new TreeNode(i);
                    node.left = lNode;
                    node.right = rNode;
                    list.add(node);
                }
            }
        }
        return list;
    }

}
