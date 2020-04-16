package me.victor.easy;

import java.util.Arrays;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 示例:
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 *
 * 说明:
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 */

public class T283_MoveZeroes {

    public static void main(String[] args) {
        var nums = new int[]{0, 1, 0, 3, 12};
        System.out.println(Arrays.toString(nums));
        //        original(nums);
        //        modified(nums);
        official(nums);
        System.out.println(Arrays.toString(nums));

        var nums2 = new int[]{0, 0, 1};
        System.out.println(Arrays.toString(nums2));
        //        original(nums2);
        //        modified(nums2);
        official(nums2);
        System.out.println(Arrays.toString(nums2));
    }

    private static void original(int[] nums) {
        if (nums == null) return;
        var modCount = 0;
        for (var i = 0; i < nums.length - modCount; ) {
            if (nums[i] == 0) {
                var tmp = Arrays.copyOfRange(nums, i + 1, nums.length - modCount);
                System.arraycopy(tmp, 0, nums, i, tmp.length);
                nums[nums.length - modCount - 1] = 0;
                modCount++;
            } else i++;
        }
    }

    /**
     * 快慢指针
     */
    private static void modified(int[] nums) {
        if (nums == null) return;
        var index = 0;
        for (var i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index++] = nums[i];
            }
        }
        for (int i = index; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    private static void official(int[] nums) {
        for (int index = 0, zeroIndex = 0; index < nums.length; index++) {
            if (nums[index] != 0) {
                nums[index] ^= nums[zeroIndex];
                nums[zeroIndex] ^= nums[index];
                nums[index] ^= nums[zeroIndex];
                zeroIndex++;
            }
        }
    }

}
