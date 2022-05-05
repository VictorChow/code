package me.victor.code;

/**
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 *
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 * 示例 2：
 *
 * 输入：nums1 = [1,2], nums2 = [3,4]
 * 输出：2.50000
 * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 *  
 *
 *  
 *
 * 提示：
 *
 * nums1.length == m
 * nums2.length == n
 * 0 <= m <= 1000
 * 0 <= n <= 1000
 * 1 <= m + n <= 2000
 * -10^6 <= nums1[i], nums2[i] <= 10^6
 *
 */

public class T4_MedianOfTwoSortedArrays {

    public static void main(String[] args) {
        var t = new T4_MedianOfTwoSortedArrays();
        System.out.println(t.findMedianSortedArrays1(new int[]{1, 3}, new int[]{2}));
        System.out.println(t.findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));
        System.out.println(t.findMedianSortedArrays1(new int[]{1, 2}, new int[]{3, 4}));
        System.out.println(t.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
        System.out.println(t.findMedianSortedArrays1(new int[]{1, 3, 5, 7}, new int[]{2, 4, 6, 8, 9}));
        System.out.println(t.findMedianSortedArrays(new int[]{1, 3, 5, 7}, new int[]{2, 4, 6, 8, 9}));


    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int left = (m + n + 1) / 2;
        int right = (m + n + 2) / 2;
        return (findKth(nums1, 0, nums2, 0, left) + findKth(nums1, 0, nums2, 0, right)) / 2.0;
    }

    //i: nums1的起始位置 j: nums2的起始位置
    public int findKth(int[] nums1, int i, int[] nums2, int j, int k) {
        if (i >= nums1.length) return nums2[j + k - 1];//nums1为空数组
        if (j >= nums2.length) return nums1[i + k - 1];//nums2为空数组
        if (k == 1) {
            return Math.min(nums1[i], nums2[j]);
        }
        int midVal1 = (i + k / 2 - 1 < nums1.length) ? nums1[i + k / 2 - 1] : Integer.MAX_VALUE;
        int midVal2 = (j + k / 2 - 1 < nums2.length) ? nums2[j + k / 2 - 1] : Integer.MAX_VALUE;
        if (midVal1 < midVal2) {
            return findKth(nums1, i + k / 2, nums2, j, k - k / 2);
        } else {
            return findKth(nums1, i, nums2, j + k / 2, k - k / 2);
        }
    }


    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length, i = 0, j = 0, k = 0;
        int midIdx1 = (m + n - 1) / 2, midIdx2 = (m + n) / 2;
        int midVal1 = 0, midVal2;
        while (true) {
            int v1 = i < m ? nums1[i] : Integer.MAX_VALUE;
            int v2 = j < n ? nums2[j] : Integer.MAX_VALUE;
            boolean v1Small = v1 < v2;
            int v = Math.min(v1, v2);
            if (v1Small) {
                i++;
            } else {
                j++;
            }
            if (k == midIdx1) {
                midVal1 = v;
            }
            if (k == midIdx2) {
                midVal2 = v;
                return (midVal1 + midVal2) / 2.0;
            }
            k++;
        }
    }
}
