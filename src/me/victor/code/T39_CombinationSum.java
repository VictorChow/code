package me.victor.code;

import java.util.ArrayList;
import java.util.List;

import me.victor.code.util.Util;

/**
 * https://leetcode.cn/problems/combination-sum/
 */
class T39_CombinationSum {

    public static void main(String[] args) {
        var t = new T39_CombinationSum();
        System.out.println(t.combinationSum(Util.arr(2, 3, 5), 8));
        System.out.println(t.combinationSum(Util.arr(2, 3, 6, 7), 7));
        System.out.println(t.combinationSum(Util.arr(2), 1));
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        var lists = new ArrayList<List<Integer>>();
        var list = new ArrayList<Integer>();
        find(candidates, target, 0, list, lists, 0);
        return lists;
    }

    private void find(int[] candidates, int target, int sum, List<Integer> list, List<List<Integer>> lists, int l) {
        if (sum > target) return;
        if (sum == target) {
            lists.add(new ArrayList<>(list));
            return;
        }
        for (int i = l; i < candidates.length; i++) {
            list.add(candidates[i]);
            find(candidates, target, sum + candidates[i], list, lists, i);
            list.remove(list.size() - 1);
        }
    }
}
