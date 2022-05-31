package me.victor.code;

import me.victor.code.util.Util;

/**
 * https://leetcode.cn/problems/search-in-rotated-sorted-array-ii/
 */

class T81_SearchInRotatedSortedArray2 {

    public static void main(String[] args) {
        var t = new T81_SearchInRotatedSortedArray2();
        System.out.println(t.search(Util.arr(2, 5, 6, 0, 0, 1, 2), 0));
        System.out.println(t.search(Util.arr(2, 5, 6, 0, 0, 1, 2), 3));
        System.out.println(t.search(Util.arr(1, 0, 1, 1, 1), 0));
        System.out.println(t.search(Util.arr(1, 2, 2, 2, 0, 1, 1), 0));
    }

    public boolean search(int[] nums, int target) {
        return search(nums, 0, nums.length - 1, target);
    }

    public boolean search(int[] nums, int l, int r, int target) {
        while (l < r && nums[l] == nums[l + 1]) l++;
        while (l < r && nums[r] == nums[r - 1]) r--;
        var m = l + (r - l) / 2;
        if (nums[l] > nums[m] || nums[m] > nums[r]) {
            return search(nums, l, m, target) || search(nums, m + 1, r, target);
        }
        while (l <= r) {
            m = l + (r - l) / 2;
            if (nums[m] == target) return true;
            if (nums[m] > target) r = m - 1;
            else l = m + 1;
        }
        return false;
    }
}
