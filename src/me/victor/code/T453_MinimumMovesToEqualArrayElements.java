package me.victor.code;

/**
 * 给定一个长度为 n 的非空整数数组，找到让数组所有元素相等的最小移动次数。每次移动将会使 n - 1 个元素增加 1。
 *
 * 示例:
 * 输入:
 * [1,2,3]
 * 输出:
 * 3
 * 解释:
 * 只需要3次移动（注意每次移动会增加两个元素的值）：
 * [1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
 */

public class T453_MinimumMovesToEqualArrayElements {
    public static void main(String[] args) {
        System.out.println(original(new int[]{1, 2, 3}));
    }

    /**
     * 将除了一个元素之外的全部元素+1，等价于将该元素-1，因为我们只对元素的相对大小感兴趣。
     * 因此，该问题简化为需要进行的减法次数。
     */
    private static int original(int[] nums) {
        int min = Integer.MAX_VALUE, steps = 0;
        for (int num : nums) min = Math.min(num, min);
        for (int num : nums) steps += num - min;
        return steps;
    }
}
