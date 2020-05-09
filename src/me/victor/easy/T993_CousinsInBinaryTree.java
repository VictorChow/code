package me.victor.easy;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;

/**
 * 在二叉树中，根节点位于深度 0 处，每个深度为 k 的节点的子节点位于深度 k+1 处。
 * 如果二叉树的两个节点深度相同，但父节点不同，则它们是一对堂兄弟节点。
 * 我们给出了具有唯一值的二叉树的根节点 root，以及树中两个不同节点的值 x 和 y。
 * 只有与值 x 和 y 对应的节点是堂兄弟节点时，才返回 true。否则，返回 false。
 *
 * 示例 1：
 * https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2019/02/16/q1248-01.png
 * 输入：root = [1,2,3,4], x = 4, y = 3
 * 输出：false
 *
 * 示例 2：
 * https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2019/02/16/q1248-02.png
 * 输入：root = [1,2,3,null,4,null,5], x = 5, y = 4
 * 输出：true
 *
 * 示例 3：
 * https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2019/02/16/q1248-03.png
 * 输入：root = [1,2,3,null,4], x = 2, y = 3
 * 输出：false
 *
 * 提示：
 * 二叉树的节点数介于 2 到 100 之间。
 * 每个节点的值都是唯一的、范围为 1 到 100 的整数。
 */

public class T993_CousinsInBinaryTree {
    private static final Queue<TreeNode> queue = new LinkedList<>();
    private static final Map<Integer, Integer> depth = new HashMap<>();
    private static final Map<Integer, TreeNode> parent = new HashMap<>();

    public static void main(String[] args) {
        var head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(3);
        head.left.right = new TreeNode(4);
        head.right.right = new TreeNode(5);
        System.out.println(original(head, 4, 5));
    }

    private static boolean original(TreeNode root, int x, int y) {
        if (root == null) return false;
        int depth = 1, dx = 0, dy = 0;
        TreeNode px = null, py = null;
        queue.add(root);
        while (!queue.isEmpty()) {
            var size = queue.size();
            for (int i = 0; i < size; i++) {
                var node = queue.poll();
                if (node.left != null) {
                    if (node.left.val == x) {
                        px = node;
                        dx = depth + 1;
                    } else if (node.left.val == y) {
                        py = node;
                        dy = depth + 1;
                    }
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    if (node.right.val == x) {
                        px = node;
                        dx = depth + 1;
                    } else if (node.right.val == y) {
                        py = node;
                        dy = depth + 1;
                    }
                    queue.offer(node.right);
                }
            }
            if (px != null && py != null) break;
            depth++;
        }
        return !Objects.equals(px, py) && dx == dy;
    }

    private static boolean official(TreeNode root, int x, int y) {
        dfs(root, null);
        return (depth.get(x) == depth.get(y) && parent.get(x) != parent.get(y));
    }

    private static void dfs(TreeNode node, TreeNode par) {
        if (node != null) {
            depth.put(node.val, par != null ? 1 + depth.get(par.val) : 0);
            parent.put(node.val, par);
            dfs(node.left, node);
            dfs(node.right, node);
        }
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
