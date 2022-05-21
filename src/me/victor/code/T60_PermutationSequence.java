package me.victor.code;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/permutation-sequence/
 */
class T60_PermutationSequence {

    public static void main(String[] args) {
        var t = new T60_PermutationSequence();

        System.out.println(t.getPermutation(4, 4));
    }

    public String getPermutation(int n, int k) {
        var bool = new boolean[n];
        var chars = new char[n];
        var str = new String[1];
        int[] nums = new int[n], count = new int[1];
        for (int i = 0; i < nums.length; i++) nums[i] = i + 1;
        find(nums, bool, chars, 0, str, count, k);
        return str[0];
    }

    private boolean find(int[] nums, boolean[] bool, char[] chars, int len, String[] str, int[] count, int k) {
        if (len == nums.length) {
            if (++count[0] == k) {
                str[0] = new String(chars);
                return true;
            }
            return false;
        }
        for (int num : nums) {
            var idx = num - 1;
            if (bool[idx]) continue;
            bool[idx] = true;
            chars[len] = (char) (num + '0');
            if (find(nums, bool, chars, len + 1, str, count, k)) return true;
            bool[idx] = false;
        }
        return false;
    }
}
