package me.victor.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import me.victor.code.util.Util;

/**
 * https://leetcode.cn/problems/combination-sum-ii/
 */
class T40_CombinationSum2 {

    public static void main(String[] args) {
        var t = new T40_CombinationSum2();
        System.out.println(t.combinationSum2(Util.arr(10, 1, 2, 7, 6, 1, 5), 8));
        System.out.println(t.combinationSum2(Util.arr(2, 5, 2, 1, 2), 5));
        System.out.println(t.combinationSum2(Util.arr(2), 1));

    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        var set = new HashSet<List<Integer>>();
        var list = new ArrayList<Integer>();
        find(candidates, target, 0, list, set, 0);
        return set.stream().toList();
    }

    private void find(int[] candidates, int target, int sum, List<Integer> list, Set<List<Integer>> lists, int l) {
        if (sum > target) return;
        if (sum == target) {
            lists.add(new ArrayList<>(list));
            return;
        }
        for (int i = l; i < candidates.length; i++) {
            if (i > l && candidates[i] == candidates[i - 1]) continue;
            list.add(candidates[i]);
            find(candidates, target, sum + candidates[i], list, lists, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
