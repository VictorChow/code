package me.victor.easy;

import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.TreeNode;

/**
 * 给你一棵二叉树的根节点 root ，返回其节点值的 后序遍历 。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：root = [1,null,2,3]
 * 输出：[3,2,1]
 * 示例 2：
 *
 * 输入：root = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：root = [1]
 * 输出：[1]
 *  
 *
 * 提示：
 *
 * 树中节点的数目在范围 [0, 100] 内
 * -100 <= Node.val <= 100
 *  
 *
 * 进阶：递归算法很简单，你可以通过迭代算法完成吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-postorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class T145_BinaryTreePostorderTraversal {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>(100);
        doTraversal(root, list);
        return list;
    }

    private void doTraversal(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        doTraversal(node.left, list);
        doTraversal(node.right, list);
        list.add(node.val);
    }
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}

        TreeNode(int val) {this.val = val;}

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
