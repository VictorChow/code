package me.victor.code;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/merge-sorted-array/
 */

public class T88_MergeSortedArray {

    public static void main(String[] args) {
        var t = new T88_MergeSortedArray();
        var arr1 = new int[]{1, 2, 3, 0, 0, 0};
        var arr2 = new int[]{2, 5, 6};

        t.merge(arr1, 3, arr2, arr2.length);
        System.out.println(Arrays.toString(arr1));
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i1 = m - 1, i2 = n - 1, r = m + n - 1;
        while (r >= 0) {
            if (i1 >= 0 && i2 >= 0) {
                nums1[r--] = nums1[i1] > nums2[i2] ? nums1[i1--] : nums2[i2--];
            } else if (i2 >= 0) {
                nums1[r--] = nums2[i2--];
            } else break;
        }
    }
}
