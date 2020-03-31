package me.victor.easy;

import java.util.Arrays;

/**
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 num1 成为一个有序数组。
 * 说明:
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 *
 * 示例:
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * 输出: [1,2,2,3,5,6]
 */

public class T88_MergeSortedArray {

    public static void main(String[] args) {
        var arr1 = new int[]{1, 2, 3, 0, 0, 0};
        var arr2 = new int[]{2, 5, 6};
        //        original(arr1, 3, arr2, arr2.length);
        official(arr1, 3, arr2, arr2.length);
        System.out.println(Arrays.toString(arr1));
    }

    private static void original(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        //        Arrays.sort(nums1);
        bubble(nums1);
    }

    private static void bubble(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (nums[j] < nums[i]) {
                    nums[j] = nums[j] ^ nums[i];
                    nums[i] = nums[j] ^ nums[i];
                    nums[j] = nums[j] ^ nums[i];
                }
            }
        }
    }

    private static void official(int[] nums1, int m, int[] nums2, int n) {
        // two get pointers for nums1 and nums2
        int p1 = m - 1;
        int p2 = n - 1;
        // set pointer for nums1
        int p = m + n - 1;

        // while there are still elements to compare
        while ((p1 >= 0) && (p2 >= 0))
            // compare two elements from nums1 and nums2
            // and add the largest one in nums1
            nums1[p--] = (nums1[p1] < nums2[p2]) ? nums2[p2--] : nums1[p1--];

        // add missing elements from nums2
        System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
    }
}
