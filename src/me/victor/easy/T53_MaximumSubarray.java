package me.victor.easy;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * 示例:
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * <p>
 * 进阶:
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 **/

public class T53_MaximumSubarray {

    public static void main(String[] args) {
        System.out.println(original(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(original(new int[]{-1}));
        System.out.println(original(new int[]{-2, -1}));
        System.out.println(original(new int[]{-1, -2}));
        System.out.println("----------------");
        System.out.println(modified(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(modified(new int[]{-1}));
        System.out.println(modified(new int[]{-2, -1}));
        System.out.println(modified(new int[]{-1, -2}));

    }

    private static int original(int[] nums) {
        var max = Integer.MIN_VALUE;
        for (int sub = 1; sub <= nums.length; sub++) {
            for (int i = 0; i <= nums.length - sub; i++) {
                var sum = sum(nums, i, i + sub);
                if (sum > max) {
                    max = sum;
                }
            }
        }
        return max;
    }

    /**
     * 前包后不包
     */
    private static int sum(int[] nums, int from, int to) {
        var sum = 0;
        for (int i = from; i < to; i++) {
            sum += nums[i];
        }
        return sum;
    }

    private static int modified(int[] nums) {
        var max = nums[0];
        var sum = 0;
        for (var num : nums) {
            // 这个地方不应该直接加, 应该先判断之前的
            sum += num;
            if (sum > 0) {
                max = Math.max(max, sum);
            } else {
                sum = 0;
                max = Math.max(max, num);
            }
        }
        return max;
    }

    /**
     * 假设sum<=0，那么后面的子序列肯定不包含目前的子序列, 所以令sum = num
     * 如果sum > 0对于后面的子序列是有好处的
     * max = Math.max(max, sum)保证可以找到最大的子序和。
     */
    private static int best(int[] nums) {
        int max = nums[0];
        int sum = 0;
        for (int num : nums) {
            if (sum > 0) {
                sum += num;
            } else {
                sum = num;
            }
            max = Math.max(max, sum);
        }
        return max;
    }
}
