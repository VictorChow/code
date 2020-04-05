package me.victor.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 *
 * 示例 1:
 *
 * 输入: [1,2,3,1]
 * 输出: 4
 * 解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 * 示例 2:
 *
 * 输入: [2,7,9,3,1]
 * 输出: 12
 * 解释: 偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 *      偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 */

public class T198_HouseRobber {

    public static void main(String[] args) {
        System.out.println(original(new int[]{1, 2, 3, 1}));
        System.out.println(original(new int[]{2, 7, 9, 3, 1}));
        var t = System.currentTimeMillis();
        System.out.println(original(new int[]{1, 2, 23, 34, 1, 123, 134, 435, 131, 0, 123, 4, 11, 67, 68, 90, 1, 2, 23, 34, 1, 123, 134, 435, 131, 0, 123, 4, 11, 67, 68, 90, 1, 2, 23, 34, 1, 123, 134, 435, 131, 0, 123, 4, 11, 67, 68, 90, 1, 2, 23, 34, 1, 123, 134, 435, 131, 0, 123, 4, 11, 67, 68, 90, 1, 2, 23, 34, 1, 123, 134, 435, 131, 0, 123, 4, 11, 67, 68, 90, 1, 2, 23, 34, 1, 123, 134, 435, 131, 0, 123, 4, 11, 67, 68, 90, 1, 2, 23, 34, 1, 123, 134, 435, 131, 0, 123, 4, 11, 67, 68, 90, 1, 2, 23, 34, 1, 123, 134, 435, 131, 0, 123, 4, 11, 67, 68, 90, 1, 2, 23, 34, 1, 123, 134, 435, 131, 0, 123, 4, 11, 67, 68, 90, 1, 2, 23, 34, 1, 123, 134, 435, 131, 0, 123, 4, 11, 67, 68, 90, 122, 2, 23, 34, 1, 123, 134, 435, 131, 0, 123, 4, 11, 67, 68, 90, 1, 2, 23, 34, 1, 123, 134, 435, 1311, 0, 123, 4, 11, 67, 68, 90, 1, 2, 23, 34, 1, 123, 134, 435, 131, 0, 123, 4, 11, 67, 68, 90, 1, 2, 23, 34, 1, 123, 134, 435, 131, 0, 123, 4, 11, 67, 68, 90}));
        System.out.println(System.currentTimeMillis() - t);

        t = System.currentTimeMillis();
        System.out.println(modified(new int[]{1, 2, 23, 34, 1, 123, 134, 435, 131, 0, 123, 4, 11, 67, 68, 90, 1, 2, 23, 34, 1, 123, 134, 435, 131, 0, 123, 4, 11, 67, 68, 90, 1, 2, 23, 34, 1, 123, 134, 435, 131, 0, 123, 4, 11, 67, 68, 90, 1, 2, 23, 34, 1, 123, 134, 435, 131, 0, 123, 4, 11, 67, 68, 90, 1, 2, 23, 34, 1, 123, 134, 435, 131, 0, 123, 4, 11, 67, 68, 90, 1, 2, 23, 34, 1, 123, 134, 435, 131, 0, 123, 4, 11, 67, 68, 90, 1, 2, 23, 34, 1, 123, 134, 435, 131, 0, 123, 4, 11, 67, 68, 90, 1, 2, 23, 34, 1, 123, 134, 435, 131, 0, 123, 4, 11, 67, 68, 90, 1, 2, 23, 34, 1, 123, 134, 435, 131, 0, 123, 4, 11, 67, 68, 90, 1, 2, 23, 34, 1, 123, 134, 435, 131, 0, 123, 4, 11, 67, 68, 90, 122, 2, 23, 34, 1, 123, 134, 435, 131, 0, 123, 4, 11, 67, 68, 90, 1, 2, 23, 34, 1, 123, 134, 435, 1311, 0, 123, 4, 11, 67, 68, 90, 1, 2, 23, 34, 1, 123, 134, 435, 131, 0, 123, 4, 11, 67, 68, 90, 1, 2, 23, 34, 1, 123, 134, 435, 131, 0, 123, 4, 11, 67, 68, 90}));
        System.out.println(System.currentTimeMillis() - t);

        t = System.currentTimeMillis();
        System.out.println(official(new int[]{1, 2, 23, 34, 1, 123, 134, 435, 131, 0, 123, 4, 11, 67, 68, 90, 1, 2, 23, 34, 1, 123, 134, 435, 131, 0, 123, 4, 11, 67, 68, 90, 1, 2, 23, 34, 1, 123, 134, 435, 131, 0, 123, 4, 11, 67, 68, 90, 1, 2, 23, 34, 1, 123, 134, 435, 131, 0, 123, 4, 11, 67, 68, 90, 1, 2, 23, 34, 1, 123, 134, 435, 131, 0, 123, 4, 11, 67, 68, 90, 1, 2, 23, 34, 1, 123, 134, 435, 131, 0, 123, 4, 11, 67, 68, 90, 1, 2, 23, 34, 1, 123, 134, 435, 131, 0, 123, 4, 11, 67, 68, 90, 1, 2, 23, 34, 1, 123, 134, 435, 131, 0, 123, 4, 11, 67, 68, 90, 1, 2, 23, 34, 1, 123, 134, 435, 131, 0, 123, 4, 11, 67, 68, 90, 1, 2, 23, 34, 1, 123, 134, 435, 131, 0, 123, 4, 11, 67, 68, 90, 122, 2, 23, 34, 1, 123, 134, 435, 131, 0, 123, 4, 11, 67, 68, 90, 1, 2, 23, 34, 1, 123, 134, 435, 1311, 0, 123, 4, 11, 67, 68, 90, 1, 2, 23, 34, 1, 123, 134, 435, 131, 0, 123, 4, 11, 67, 68, 90, 1, 2, 23, 34, 1, 123, 134, 435, 131, 0, 123, 4, 11, 67, 68, 90}));
        System.out.println(System.currentTimeMillis() - t);
    }

    private static int original(int[] nums) {
        if (nums.length == 0) return 0;
        else if (nums.length == 1) return nums[0];
        var map = new HashMap<Integer, Integer>((int) (nums.length / 0.75 + 1));
        return Math.max(find(nums, 0, map), (find(nums, 1, map)));
    }

    private static int find(int[] nums, int index, Map<Integer, Integer> cache) {
        if (index >= nums.length) return 0;
        if (cache.containsKey(index)) return cache.get(index);
        var max = nums[index] + Math.max(find(nums, index + 2, cache), find(nums, index + 3, cache));
        cache.put(index, max);
        return max;
    }

    private static int modified(int[] nums) {
        if (nums.length == 0) return 0;
        else if (nums.length == 1) return nums[0];
        var map = new HashMap<Integer, Integer>((int) (nums.length / 0.75 + 1));
        return find2(nums, nums.length - 1, map);
    }

    private static int find2(int[] nums, int n, Map<Integer, Integer> cache) {
        if (n < 0) return 0;
        else if (n == 0) return nums[0];
        else if (n == 1) return Math.max(nums[0], nums[1]);
        if (cache.containsKey(n)) return cache.get(n);
        var max = Math.max(find2(nums, n - 2, cache) + nums[n], find2(nums, n - 1, cache));
        cache.put(n, max);
        return max;
    }

    private static int official(int[] nums) {
        int preMax = 0, curMax = 0;
        for (int num : nums) {
            var tmp = curMax;
            curMax = Math.max(curMax, preMax + num);
            preMax = tmp;
        }
        return curMax;
    }
}
