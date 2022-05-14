package me.victor.code;

import me.victor.code.util.Util;

/**
 * https://leetcode.cn/problems/search-in-rotated-sorted-array/
 */
class T33_SearchInRotatedSortedArray {

    public static void main(String[] args) {
        var t = new T33_SearchInRotatedSortedArray();
        //        System.out.println(t.search(Util.intArr(4, 5, 6, 7, 0, 1, 2), 0));
        System.out.println(t.search(Util.intArr(4, 5, 6, 7, 0, 1, 2), 1));
        //        System.out.println(t.search(Util.intArr(1), 0));
    }

    public int search(int[] nums, int target) {
        var v = new int[]{-1};
        search(nums, target, 0, nums.length / 2, v);
        search(nums, target, nums.length / 2 + 1, nums.length - 1, v);
        return v[0];
    }

    private void search(int[] nums, int target, int l, int r, int[] v) {
        if (v[0] != -1 || r < l || l < 0) return;
        if (nums[l] == target) {
            v[0] = l;
            return;
        }
        if (l == r) return;
        var m = l + (r - l) / 2;
        if (nums[l] > nums[r]) {
            search(nums, target, l, m, v);
            search(nums, target, m + 1, r, v);
            return;
        }
        if (nums[l] > target || nums[r] < target) return;
        if (target == nums[m]) v[0] = m;
        else if (target < nums[m]) search(nums, target, l, m - 1, v);
        else search(nums, target, m + 1, r, v);
    }
}
