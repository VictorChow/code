package me.victor.code;

import me.victor.code.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class T113_PathSum2 {

    public static void main(String[] args) {

    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        var ans = new ArrayList<List<Integer>>();
        f(ans, new ArrayList<>(), root, targetSum);
        return ans;
    }

    private void f(List<List<Integer>> ans, List<Integer> list, TreeNode node, int remain) {
        if (node == null) return;
        list.add(node.val);
        if (remain == node.val && node.left == null && node.right == null) {
            ans.add(new ArrayList<>(list));
        } else {
            f(ans, list, node.left, remain - node.val);
            f(ans, list, node.right, remain - node.val);
        }
        list.remove(list.size() - 1);
    }

}
