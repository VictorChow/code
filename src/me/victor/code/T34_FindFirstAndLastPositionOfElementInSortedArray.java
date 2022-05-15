package me.victor.code;

import java.util.Arrays;

import me.victor.code.util.Util;

/**
 * https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/
 */
class T34_FindFirstAndLastPositionOfElementInSortedArray {

    public static void main(String[] args) {
        var t = new T34_FindFirstAndLastPositionOfElementInSortedArray();
        System.out.println(Arrays.toString(t.searchRange(Util.arr(5, 7, 7, 8, 9, 10), 8)));
    }

    public int[] searchRange(int[] nums, int target) {
        var pos = new int[]{-1, -1};
        searchRange(nums, target, 0, nums.length - 1, pos);
        return pos;
    }

    private void searchRange(int[] nums, int target, int l, int r, int[] pos) {
        if (l > r) return;
        var m = l + (r - l) / 2;
        if (nums[m] < target) searchRange(nums, target, m + 1, r, pos);
        else if (nums[m] > target) searchRange(nums, target, l, m - 1, pos);
        else {
            if (pos[0] == -1 && pos[1] == -1) pos[0] = pos[1] = m;
            else if (m < pos[0]) pos[0] = m;
            else if (m > pos[1]) pos[1] = m;
            searchRange(nums, target, l, m - 1, pos);
            searchRange(nums, target, m + 1, r, pos);
        }
    }
}
