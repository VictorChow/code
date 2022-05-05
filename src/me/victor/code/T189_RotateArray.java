package me.victor.code;

import java.util.Arrays;

/**
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 *
 * 示例 1:
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 *
 * 示例 2:
 * 输入: [-1,-100,3,99] 和 k = 2
 * 输出: [3,99,-1,-100]
 * 解释:
 * 向右旋转 1 步: [99,-1,-100,3]
 * 向右旋转 2 步: [3,99,-1,-100]
 *
 * 说明:
 * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * 要求使用空间复杂度为 O(1) 的 原地 算法。
 */

public class T189_RotateArray {

    public static void main(String[] args) {
        var arr1 = new int[]{1, 2, 3, 4, 5, 6, 7};
        best(arr1, 3);
        System.out.println(Arrays.toString(arr1));

    }

    private static void original(int[] nums, int k) {
        if (nums.length == 0) return;
        var r = k % nums.length;
        if (r == 0) return;
        var arrR = Arrays.copyOfRange(nums, nums.length - r, nums.length);
        var arrL = Arrays.copyOf(nums, nums.length - r);
        System.arraycopy(arrL, 0, nums, arrR.length, arrL.length);
        System.arraycopy(arrR, 0, nums, 0, arrR.length);
    }

    private static void best(int[] nums, int k) {
        if (nums.length == 0) return;
        var r = k % nums.length;
        if (r == 0) return;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, r - 1);
        reverse(nums, r, nums.length - 1);
    }

    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            nums[start] ^= nums[end];
            nums[end] ^= nums[start];
            nums[start] ^= nums[end];
            start++;
            end--;
        }
    }
}
