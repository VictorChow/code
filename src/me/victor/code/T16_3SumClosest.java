package me.victor.code;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/3sum-closest/
 */
public class T16_3SumClosest {

    public static void main(String[] args) {
        var t = new T16_3SumClosest();
        System.out.println(t.threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
        System.out.println(t.threeSumClosest(new int[]{0, 0, 0}, 1));
        System.out.println(t.threeSumClosest(new int[]{-3, -2, -5, 3, -4}, 1));
    }

    public int threeSumClosest(int[] nums, int target) {
        Integer val = null;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                var v = nums[i] + nums[l] + nums[r];
                if (v == target) {
                    return v;
                }
                if (val == null || Math.abs(target - v) < Math.abs(target - val)) {
                    val = v;
                }
                if (v < target) l++;
                if (v > target) r--;
            }
        }
        return val;
    }
}
