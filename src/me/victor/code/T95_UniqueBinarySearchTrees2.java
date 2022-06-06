package me.victor.code;

import java.util.ArrayList;
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
        var ans = new ArrayList<TreeNode>();
        var bool = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            TreeNode h = new TreeNode(i);
            bool[i] = true;
            f(ans, h, h, i, n, 1, bool);
            bool[i] = false;
        }
        return ans;
    }

    private void f(List<TreeNode> ans, TreeNode head, TreeNode node, int x, int n, int count, boolean[] bool) {
        if (count == n) {
            ans.add(clone(head));
            return;
        }
        if (x < 1 || x > n) return;
        for (int i = 1; i < x; i++) {
            if (bool[i]) continue;
            node.left = new TreeNode(i);
            bool[i] = true;
            f(ans, head, node.left, i, x, count + 1, bool);
            bool[i] = false;
            node.left = null;
        }
        for (int j = x + 1; j <= n; j++) {
            if (bool[j]) continue;
            node.right = new TreeNode(j);
            bool[j] = true;
            f(ans, head, node.right, j, n, count + 1, bool);
            bool[j] = false;
            node.right = null;
        }
        //
        //        for (int i = 1; i < x; i++) {
        //            node.left = new TreeNode(i);
        //            f(ans, head, node.left, i, n, count + 1);
        //            for (int j = x + 1; j <= n; j++) {
        //                node.right = new TreeNode(j);
        //                f(ans, head, node.right, j, n, count + 2);
        //                node.right = null;
        //            }
        //            node.left = null;
        //        }
    }

    private TreeNode clone(TreeNode head) {
        if (head == null) return null;
        TreeNode h = new TreeNode(head.val);
        h.left = clone(head.left);
        h.right = clone(head.right);
        return h;
    }
}
