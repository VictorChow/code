package me.victor.code;

import java.util.Arrays;

/**
 * 给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。
 *
 * 返回这三个数的和。
 *
 * 假定每组输入只存在恰好一个解。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 * 示例 2：
 *
 * 输入：nums = [0,0,0], target = 1
 * 输出：0
 *  
 *
 * 提示：
 *
 * 3 <= nums.length <= 1000
 * -1000 <= nums[i] <= 1000
 * -10^4 <= target <= 10^4
 */
public class T16_3SumClosest {

    public static void main(String[] args) {
        var t = new T16_3SumClosest();
        System.out.println(t.threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
        System.out.println(t.threeSumClosest(new int[]{0, 0, 0}, 1));
        System.out.println(t.threeSumClosest(new int[]{-3, -2, -5, 3, -4}, 1));
    }

    public int threeSumClosest(int[] nums, int target) {
        Integer val = null;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                var v = nums[i] + nums[l] + nums[r];
                if (v == target) {
                    return v;
                }
                if (val == null || Math.abs(target - v) < Math.abs(target - val)) {
                    val = v;
                }
                if (v < target) l++;
                if (v > target) r--;
            }
        }
        return val;
    }
}
