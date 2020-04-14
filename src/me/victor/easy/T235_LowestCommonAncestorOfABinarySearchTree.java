package me.victor.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * 例如，给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]
 * https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/14/binarysearchtree_improved.png
 *
 * 示例 1:
 * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 * 输出: 6
 * 解释: 节点 2 和节点 8 的最近公共祖先是 6。
 *
 * 示例 2:
 * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
 * 输出: 2
 * 解释: 节点 2 和节点 4 的最近公共祖先是 2, 因为根据定义最近公共祖先节点可以为节点本身。
 *
 * 说明:
 * 所有节点的值都是唯一的。
 * p、q 为不同节点且均存在于给定的二叉搜索树中。
 *
 * 二叉搜索树（BST）的性质：
 *
 * 节点 NN 左子树上的所有节点的值都小于等于节点 NN 的值
 * 节点 NN 右子树上的所有节点的值都大于等于节点 NN 的值
 * 左子树和右子树也都是 BST
 */

public class T235_LowestCommonAncestorOfABinarySearchTree {

    public static void main(String[] args) {
        var head = generate();
        System.out.println(original(head, head.left.right.right, head.right.right));
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

    private static TreeNode official(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val < root.val && q.val < root.val) {
            return official(root.left, p, q);
        }
        if (p.val > root.val && q.val > root.val) {
            return official(root.right, p, q);
        }
        return root;
    }

    /**
     * 最开始没注意到是二叉搜索树, 写的通用的
     */
    private static TreeNode original(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        var pNodes = new ArrayList<TreeNode>();
        var qNodes = new ArrayList<TreeNode>();
        find(root, p, pNodes);
        find(root, q, qNodes);
        pNodes.retainAll(qNodes);
        return pNodes.get(0);
    }

    private static boolean find(TreeNode root, TreeNode target, List<TreeNode> parents) {
        if (root == null) return false;
        if (root == target) {
            parents.add(root);
            return true;
        }
        if (find(root.left, target, parents)) {
            parents.add(root);
            return true;
        }
        if (find(root.right, target, parents)) {
            parents.add(root);
            return true;
        }
        return false;
    }

    private static class TreeNode {
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
