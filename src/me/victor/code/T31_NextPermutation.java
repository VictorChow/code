package me.victor.code;

import java.util.Arrays;

import me.victor.code.util.Util;

/**
 * https://leetcode.cn/problems/next-permutation/
 */
class T31_NextPermutation {

    public static void main(String[] args) {
        var t = new T31_NextPermutation();

        t.nextPermutation(Util.intArray(1));
        t.nextPermutation(Util.intArray(2, 1));
        t.nextPermutation(Util.intArray(1, 2, 3));
        t.nextPermutation(Util.intArray(3, 2, 1));
        t.nextPermutation(Util.intArray(1, 1, 5));
        t.nextPermutation(Util.intArray(1, 1, 1, 2, 2, 3, 4, 1, 5, 2, 2, 2, 2, 2));
        t.nextPermutation(Util.intArray(2, 6, 5, 3, 3, 1));
        t.nextPermutation(Util.intArray(4, 2, 0, 2, 3, 2, 0));
    }

    public void nextPermutation(int[] nums) {
        System.out.println(Arrays.toString(nums));
        if (nums.length <= 1) return;
        for (int i = nums.length - 1; i >= 1; i--) {
            if (nums[i - 1] < nums[i]) {
                var smallerIdx = findMinSmallerIdx(nums, nums[i - 1], i);
                swap(nums, smallerIdx, i - 1);
                reverse(nums, i, nums.length);
                System.out.println(Arrays.toString(nums));
                System.out.println("-----");
                return;
            }
        }
        reverse(nums, 0, nums.length);
        System.out.println(Arrays.toString(nums));
        System.out.println("-----");
    }

    private void reverse(int[] nums, int l, int r) {
        for (int i = l; i < l + (r - l) / 2; i++) {
            swap(nums, i, r - (i - l) - 1);
        }
    }

    private int findMinSmallerIdx(int[] nums, int cur, int l) {
        for (int i = nums.length - 1; i >= l; i--) {
            if (nums[i] > cur) return i;
        }
        throw new IllegalArgumentException();
    }

    public void nextPermutation2(int[] nums) {
        if (nums.length <= 1) return;
        System.out.println(Arrays.toString(nums));
        int idx = nums.length - 2;
        var preIdx = idx + 1;
        while (idx >= 0) {
            if (nums[preIdx] > nums[idx]) {
                swap(nums, preIdx, idx);
                System.out.println(Arrays.toString(nums));
                return;
            } else if (nums[idx] == nums[preIdx]) {
                preIdx--;
            }
            idx--;
        }
        for (int i = 0; i < nums.length / 2; i++) {
            var j = nums.length - 1 - i;
            swap(nums, i, j);
        }
        System.out.println(Arrays.toString(nums));
    }

    private void swap(int[] nums, int i, int j) {
        nums[i] ^= nums[j];
        nums[j] ^= nums[i];
        nums[i] ^= nums[j];
    }
}
