package me.victor.code;

import me.victor.code.util.Util;

/**
 * https://leetcode.cn/problems/remove-duplicates-from-sorted-array/
 */

public class T26_RemoveDuplicatesFromSortedArray {


    public static void main(String[] args) {
        var t = new T26_RemoveDuplicatesFromSortedArray();
        //        var arr1 = new int[]{1, 1, 2};
        //        var arr2 = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(original(Util.arr(1, 2, 2)));
        System.out.println(t.removeDuplicates(Util.arr(1, 2, 2)));
        System.out.println(original(Util.arr(0, 0, 1, 1, 1, 2, 2, 3, 3, 4)));
        System.out.println(t.removeDuplicates(Util.arr(0, 0, 1, 1, 1, 2, 2, 3, 3, 4)));
    }

    private static int original(int[] nums) {
        if (nums.length == 0) return 0;
        int index = 1, val = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != val) {
                val = nums[index++] = nums[i];
            }
        }
        return index;
    }

    private static int official(int[] nums) {
        //思路一样
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

    public int removeDuplicates(int[] nums) {
        int l = 0, r = 0;
        while (r < nums.length) {
            if (nums[r] != nums[l]) {
                nums[++l] = nums[r];
            }
            r++;
        }
        return ++l;
    }
}
