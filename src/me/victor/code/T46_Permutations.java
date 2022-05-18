package me.victor.code;

import java.util.ArrayList;
import java.util.List;

import me.victor.code.util.Util;

/**
 * https://leetcode.cn/problems/permutations/
 */
class T46_Permutations {

    public static void main(String[] args) {
        var t = new T46_Permutations();
        System.out.println(t.permute(Util.arr(1, 2, 3)));
    }

    public List<List<Integer>> permute(int[] nums) {
        var ans = new ArrayList<List<Integer>>();
        var list = new ArrayList<Integer>();
        for (int num : nums) {
            list.add(num);
            permute(nums, ans, list, 1);
            list.remove(list.size() - 1);
        }
        return ans;
    }

    private void permute(int[] nums, List<List<Integer>> ans, List<Integer> list, int deep) {
        if (deep > nums.length) return;
        if (list.size() == nums.length) {
            ans.add(new ArrayList<>(list));
            return;
        }
        for (int num : nums) {
            if (list.contains(num)) continue;
            list.add(num);
            permute(nums, ans, list, deep + 1);
            list.remove(list.size() - 1);
        }
    }
}
