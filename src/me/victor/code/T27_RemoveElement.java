package me.victor.code;

import java.util.Arrays;

import me.victor.code.util.Util;

/**
 * https://leetcode.cn/problems/remove-element/
 */
public class T27_RemoveElement {


    public static void main(String[] args) {
        var t = new T27_RemoveElement();
        var arr1 = Util.arr(3, 2, 2, 3);
        System.out.println(Arrays.toString(arr1));
        System.out.println(t.removeElement(arr1, 3));
        //        System.out.println(original(arr1, 3));
        System.out.println(Arrays.toString(arr1));
        var arr2 = Util.arr(0, 1, 2, 2, 3, 0, 4, 2);
        System.out.println(Arrays.toString(arr2));
        //        System.out.println(original(arr2, 2));
        System.out.println(t.removeElement(arr2, 2));
        System.out.println(Arrays.toString(arr2));
    }

    private static int original(int[] nums, int val) {
        if (nums.length == 0) return 0;
        var index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[index++] = nums[i];
            }
        }
        return index;
    }


    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) return 0;
        int l = 0, r = nums.length - 1;
        while (l < r) {
            if (nums[l] != val) {
                l++;
                continue;
            }
            if (nums[r] == val) {
                r--;
                continue;
            }
            nums[l++] = nums[r--];
        }
        return l + 1;
    }

}
