package me.victor.code;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;

/**
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 示例 2：
 *
 * 输入：nums = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：nums = [0]
 * 输出：[]
 *  
 *
 * 提示：
 *
 * 0 <= nums.length <= 3000
 * -10^5 <= nums[i] <= 10^5
 *
 */
public class T15_3Sum {

    public static void main(String[] args) {
        var t = new T15_3Sum();
        System.out.println(t.threeSum(new int[]{-1, -1, -1, -1, 0, 1, 1, 2}));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) return Collections.emptyList();
        Arrays.sort(nums);
        var set = new LinkedHashSet<List<Integer>>();
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > 0) continue;
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                var v = nums[i] + nums[l] + nums[r];
                if (v == 0) {
                    set.add(List.of(nums[i], nums[l], nums[r]));
                    l++;
                }
                if (v < 0) l++;
                if (v > 0) r--;
            }
        }
        return set.stream().toList();
    }
}
