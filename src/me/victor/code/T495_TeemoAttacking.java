package me.victor.code;

import me.victor.code.util.Util;

/**
 * https://leetcode.cn/problems/teemo-attacking/
 */
class T495_TeemoAttacking {

    public static void main(String[] args) {
        var t = new T495_TeemoAttacking();
        System.out.println(t.findPoisonedDuration(Util.arr(1, 2), 2));
        System.out.println(t.findPoisonedDuration(Util.arr(10), 2));
    }

    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int sum = 0, pre = timeSeries[0];
        for (int i = 1; i < timeSeries.length; i++) {
            sum += Math.min(timeSeries[i] - pre, duration);
            pre = timeSeries[i];
        }
        return sum + duration;
    }
}
