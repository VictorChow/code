package me.victor.code;

import me.victor.code.util.Util;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/sort-colors/
 */
public class T75_SortColors {

    public static void main(String[] args) {
        var t = new T75_SortColors();
//        var arr = Util.arr(1, 0, 2, 1, 0, 2, 1, 0, 0, 1, 2, 2, 0, 0, 1, 2, 1, 0, 1, 0, 2, 0, 1);
//        t.sortColors(arr);
//        System.out.println(Arrays.toString(arr));

        var arr2 = Util.arr(2, 0, 0, 2, 1, 1, 1, 0, 0, 2, 0);
        t.sortColors(arr2);
        System.out.println(Arrays.toString(arr2));
    }

    public void sortColors(int[] nums) {
        int i = 0, l = 0, r = nums.length - 1;
        while (i <= r) {
            var val = nums[i];
            if (val == 0) {
                if (i == l) {
                    i++;
                    l++;
                } else swap(nums, i, l++);
            } else if (val == 2) swap(nums, i, r--);
            else i++;
        }
    }

    private void swap(int[] nums, int i, int j) {
        if (i == j) return;
        nums[i] ^= nums[j];
        nums[j] ^= nums[i];
        nums[i] ^= nums[j];
    }
}
