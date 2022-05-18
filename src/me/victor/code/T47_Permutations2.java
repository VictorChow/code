package me.victor.code;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import me.victor.code.util.Util;

/**
 * https://leetcode.cn/problems/permutations/
 */
class T47_Permutations2 {

    public static void main(String[] args) {
        var t = new T47_Permutations2();
        System.out.println(t.permuteUnique(Util.arr(1, 3, 1)));
    }


    public List<List<Integer>> permuteUnique(int[] nums) {
        var ans = new LinkedHashSet<List<Integer>>();
        var list = new ArrayList<Integer>();
        var idx = new boolean[nums.length];
        var sign = new int[nums.length][21];//原题值范围 -10到10
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
            idx[i] = true;
            permuteUnique(nums, ans, list, idx, 1);
            list.remove(list.size() - 1);
            idx[i] = false;
        }
        return ans.stream().toList();
    }

    private void permuteUnique(int[] nums, Set<List<Integer>> ans, List<Integer> list, boolean[] idx, int deep) {
        if (deep > nums.length) return;
        if (list.size() == nums.length) {
            ans.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (idx[i]) continue;
            idx[i] = true;
            list.add(nums[i]);
            permuteUnique(nums, ans, list, idx, deep + 1);
            list.remove(list.size() - 1);
            idx[i] = false;
        }
    }
}
