package me.victor.easy;

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 你可以假设数组中无重复元素。
 *
 * 示例 1:
 * 输入: [1,3,5,6], 5
 * 输出: 2
 *
 * 示例 2:
 * 输入: [1,3,5,6], 2
 * 输出: 1
 *
 * 示例 3:
 * 输入: [1,3,5,6], 7
 * 输出: 4
 *
 * 示例 4:
 * 输入: [1,3,5,6], 0
 * 输出: 0
 */

public class T35_SearchInsertPosition {

    public static void main(String[] args) {
        System.out.println(original(new int[]{1, 3, 5, 6}, 5)); //2
        System.out.println(original(new int[]{1, 3, 5, 6}, 2)); //1
        System.out.println(original(new int[]{1, 3, 5, 6}, 7)); //4
        System.out.println(original(new int[]{1, 3, 5, 6}, 0)); //0
    }

    private static int original(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target) {
                return i;
            }
        }
        return nums.length;
    }
}
