package me.victor.code;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;

/**
 * https://leetcode.cn/problems/3sum/
 */
public class T15_3Sum {

    public static void main(String[] args) {
        var t = new T15_3Sum();
        System.out.println(t.threeSum(new int[]{-1, -1, -1, -1, 0, 1, 1, 2}));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) return Collections.emptyList();
        Arrays.sort(nums);
        var set = new LinkedHashSet<List<Integer>>();
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > 0) continue;
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                var v = nums[i] + nums[l] + nums[r];
                if (v == 0) {
                    set.add(List.of(nums[i], nums[l], nums[r]));
                    l++;
                }
                if (v < 0) l++;
                if (v > 0) r--;
            }
        }
        return set.stream().toList();
    }
}
