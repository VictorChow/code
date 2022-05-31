package me.victor.code;

import me.victor.code.util.Util;

/**
 * https://leetcode.cn/problems/remove-duplicates-from-sorted-array-ii/
 */
class T80_RemoveDuplicatesFromSortedArray2 {

    public static void main(String[] args) {
        var t = new T80_RemoveDuplicatesFromSortedArray2();
        var arr1 = Util.arr(1, 1, 1, 2, 2, 3);
        System.out.println(t.removeDuplicates(arr1));
        Util.print(arr1);
        var arr2 = Util.arr(0, 0, 1, 1, 1, 1, 2, 3, 3);
        System.out.println(t.removeDuplicates(arr2));
        Util.print(arr2);
    }

    public int removeDuplicates(int[] nums) {
        var n = 0;
        for (int num : nums) {
            if (n < 2 || num > nums[n - 2]) {
                nums[n++] = num;
            }
        }
        return n;
    }

    public int removeDuplicates2(int[] nums) {
        var pre = nums[0];
        var count = 1;
        var l = 1;
        for (int i = 1; i < nums.length; i++) {
            var val = nums[i];
            if (val == pre) {
                if (count + 1 != 3) {
                    count++;
                    nums[l++] = val;
                }
            } else {
                pre = val;
                count = 1;
                nums[l++] = val;
            }
        }
        return l;
    }
}
