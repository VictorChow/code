package me.victor.code;

import me.victor.code.util.Util;

/**
 * https://leetcode.cn/problems/first-missing-positive/
 */
class T41_FirstMissingPositive {

    public static void main(String[] args) {
        var t = new T41_FirstMissingPositive();
        System.out.println(t.firstMissingPositive(Util.arr(1, 2, 0)) == 3);
        System.out.println(t.firstMissingPositive(Util.arr(3, 4, -1, 1)) == 2);
        System.out.println(t.firstMissingPositive(Util.arr(7, 8, 9, 11, 12)) == 1);
        System.out.println(t.firstMissingPositive(Util.arr(1, 2, 3)) == 4);
        System.out.println(t.firstMissingPositive(Util.arr(1, 2, -3)) == 3);
        System.out.println(t.firstMissingPositive(Util.arr(2)) == 1);
        System.out.println(t.firstMissingPositive(Util.arr(1, 1)) == 2);
    }

    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int x;
            while ((x = nums[i]) >= 1 && x <= nums.length && nums[i] != nums[x - 1]) {
                var j = x - 1;
                nums[j] ^= nums[i];
                nums[i] ^= nums[j];
                nums[j] ^= nums[i];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (i + 1 != nums[i]) return i + 1;
        }
        return nums.length + 1;
    }

    public int firstMissingPositive2(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] >= 0 && nums[i] < nums.length && nums[i] != i && nums[i] != nums[nums[i]]) {
                var v = nums[i];
                nums[v] ^= nums[i];
                nums[i] ^= nums[v];
                nums[v] ^= nums[i];
            }
        }
        for (int i = 1; i < nums.length; i++) {
            if (i != nums[i]) return i;
        }
        return nums[0] == nums.length ? nums.length + 1 : nums.length;
    }
}
