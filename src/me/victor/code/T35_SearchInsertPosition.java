package me.victor.code;

import me.victor.code.util.Util;

/**
 * https://leetcode.cn/problems/search-insert-position/
 */
public class T35_SearchInsertPosition {

    public static void main(String[] args) {
        System.out.println(original(new int[]{1, 3, 5, 6}, 5)); //2
        System.out.println(original(new int[]{1, 3, 5, 6}, 2)); //1
        System.out.println(original(new int[]{1, 3, 5, 6}, 7)); //4
        System.out.println(original(new int[]{1, 3, 5, 6}, 0)); //0

        var t = new T35_SearchInsertPosition();
        System.out.println(t.searchInsert(Util.arr(1, 3, 5, 6), 5));
        System.out.println(t.searchInsert(Util.arr(1, 3, 5, 6), 2));
        System.out.println(t.searchInsert(Util.arr(1, 3, 5, 6), 6));
        System.out.println(t.searchInsert(Util.arr(1, 3, 5, 6), 7));
        System.out.println(t.searchInsert(Util.arr(1, 3, 5, 6), 0));

    }

    private static int original(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target) {
                return i;
            }
        }
        return nums.length;
    }

    public int searchInsert(int[] nums, int target) {
        if (target > nums[nums.length - 1]) return nums.length;
        int l = 0, r = nums.length - 1;
        while (l < r) {
            var m = l + (r - l) / 2;
            if (nums[m] == target) return m;
            if (nums[m] < target) l = m + 1;
            else r = m;
        }
        return l;
    }

}
