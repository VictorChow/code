package me.victor.code;

import java.util.HashMap;

/**
 * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的 绝对值 至多为 k。
 *
 * 示例 1:
 * 输入: nums = [1,2,3,1], k = 3
 * 输出: true
 *
 * 示例 2:
 * 输入: nums = [1,0,1,1], k = 1
 * 输出: true
 *
 * 示例 3:
 * 输入: nums = [1,2,3,1,2,3], k = 2
 * 输出: false
 */

public class T219_ContainsDuplicate2 {

    public static void main(String[] args) {
        System.out.println(original(new int[]{1, 2, 3, 1}, 3));
        System.out.println(original(new int[]{1, 0, 1, 1}, 1));
        System.out.println(original(new int[]{1, 2, 3, 1, 2, 3}, 2));
    }

    private static boolean original(int[] nums, int k) {
        if (nums == null) return false;
        var map = new HashMap<Integer, Integer>((int) (nums.length / 0.75 + 1));
        for (int i = 0; i < nums.length; i++) {
            var it = nums[i];
            if (map.containsKey(it) && Math.abs(map.get(it) - i) <= k) return true;
            map.put(it, i);
        }
        return false;
    }
}
