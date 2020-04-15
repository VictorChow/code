package me.victor.easy;

import java.util.Arrays;

/**
 * 给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
 *
 * 示例 1:
 * 输入: [3,0,1]
 * 输出: 2
 *
 * 示例 2:
 * 输入: [9,6,4,2,3,5,7,0,1]
 * 输出: 8
 *
 * 说明:
 * 你的算法应具有线性时间复杂度。你能否仅使用额外常数空间来实现?
 */

public class T268_MissingNumber {

    public static void main(String[] args) {
        System.out.println(original(new int[]{3, 0, 1}));
        System.out.println(original(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1}));
        System.out.println(original2(new int[]{3, 0, 1}));
        System.out.println(original2(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1}));
    }

    private static int original2(int[] nums) {
        var n = 0;
        for (int i = 0; i < nums.length; i++) {
            n ^= i;
            n ^= nums[i];
        }
        n ^= nums.length;
        return n;
    }

    private static int original(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) if (nums[i] != i) return i;
        return nums.length;
    }
}
