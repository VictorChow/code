package me.victor.code;

import me.victor.code.util.Util;

import java.util.*;

/**
 * https://leetcode.cn/problems/subsets-ii/
 */
public class T90_Subsets2 {

    public static void main(String[] args) {
        var t = new T90_Subsets2();
        System.out.println(t.subsetsWithDup(Util.arr(2, 1, 2, 2, 2)));
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        return subsetsWithDup(nums, nums.length).stream().toList();
    }

    public Set<List<Integer>> subsetsWithDup(int[] nums, int k) {
        if (k == 0) return Set.of(List.of());
        var list = subsetsWithDup(nums, k - 1);
        var ans = new HashSet<List<Integer>>();
        for (List<Integer> it : list) {
            ans.add(it);
            var tmp = new ArrayList<>(it);
            tmp.add(nums[k - 1]);
            ans.add(tmp);
        }
        return ans;
    }
}
