package me.victor.easy;

import java.util.HashMap;
import java.util.Objects;

/**
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 * 示例 1:
 * 输入: [3,2,3]
 * 输出: 3
 *
 * 示例 2:
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 */

public class T169_MajorityElement {

    public static void main(String[] args) {
        System.out.println(original(new int[]{1}));
        System.out.println(original(new int[]{3, 2, 3}));
        System.out.println(original(new int[]{2, 2, 1, 1, 1, 2, 2}));

        System.out.println(best(new int[]{1}));
        System.out.println(best(new int[]{3, 2, 3}));
        System.out.println(best(new int[]{2, 2, 1, 1, 1, 2, 2}));
    }

    private static int original(int[] nums) {
        var map = new HashMap<Integer, Integer>((int) (nums.length / 0.75 + 1));
        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                var count = map.get(num) + 1;
                if (count > nums.length / 2) return num;
                map.put(num, count);
            }
        }
        return nums[0];
    }

    /**
     * Boyer-Moore 投票算法
     * 如果我们把众数记为 +1，把其他数记为 -1，将它们全部加起来，显然和大于 0，从结果本身我们可以看出众数比其他数多。
     *
     * 如果候选人不是maj 则 maj,会和其他非候选人一起反对 会反对候选人,所以候选人一定会下台(maj==0时发生换届选举)
     * 如果候选人是maj , 则maj 会支持自己，其他候选人会反对，同样因为maj 票数超过一半，所以maj 一定会成功当选
     */
    private static int best(int[] nums) {
        var count = 0;
        Integer candidate = null;
        for (int num : nums) {
            if (count == 0) candidate = num;
            count += Objects.equals(candidate, num) ? 1 : -1;
        }
        return Objects.requireNonNull(candidate);
    }
}
