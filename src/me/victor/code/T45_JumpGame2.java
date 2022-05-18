package me.victor.code;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import me.victor.code.util.Util;

/**
 * https://leetcode.cn/problems/jump-game-ii/
 */
class T45_JumpGame2 {

    public static void main(String[] args) {
        var t = new T45_JumpGame2();
        System.out.println(t.jump(Util.arr(2, 3, 1, 1, 4)));
        System.out.println(t.jump(Util.arr(2, 3, 0, 1, 4)));
        System.out.println(t.jump(Util.arr(22)));
    }

    public int jump(int[] nums) {
        int step = 0, max = 0, r = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            max = Math.max(max, nums[i] + i);
            if (r == i) {
                step++;
                r = max;
            }
        }
        return step;
    }

    public int jump2(int[] nums) {
        if (nums.length == 1) return 0;
        var dp = new int[nums.length];
        for (int i = 1; i < nums.length; i++) {
            var idx = new ArrayList<Integer>();
            for (int j = 0; j < i; j++) {
                if (j + nums[j] >= i) idx.add(j);
            }
            dp[i] = min(dp, idx) + 1;
        }
        return dp[nums.length - 1];
    }

    private int min(int[] dp, List<Integer> idx) {
        return idx.stream().map(it -> dp[it]).min(Comparator.comparingInt(o -> o)).orElse(dp.length);
    }
}
