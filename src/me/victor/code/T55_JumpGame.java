package me.victor.code;

import me.victor.code.util.Util;

/**
 * https://leetcode.cn/problems/jump-game/
 */
class T55_JumpGame {

    public static void main(String[] args) {
        var t = new T55_JumpGame();
        System.out.println(t.canJump(Util.arr(2, 3, 1, 1, 4)));
        System.out.println(t.canJump(Util.arr(3, 2, 1, 0, 4)));
        System.out.println(t.canJump(Util.arr(1)));
    }

    public boolean canJump(int[] nums) {
        var max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (i > max) return false;
            max = Math.max(max, i + nums[i]);
        }
        return true;
    }

}
