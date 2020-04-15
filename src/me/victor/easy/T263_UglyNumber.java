package me.victor.easy;

/**
 * 编写一个程序判断给定的数是否为丑数。
 * 丑数就是只包含质因数 2, 3, 5 的正整数。
 *
 * 示例 1:
 * 输入: 6
 * 输出: true
 * 解释: 6 = 2 × 3
 *
 * 示例 2:
 * 输入: 8
 * 输出: true
 * 解释: 8 = 2 × 2 × 2
 *
 * 示例 3:
 * 输入: 14
 * 输出: false
 * 解释: 14 不是丑数，因为它包含了另外一个质因数 7。
 *
 * 说明：
 * 1 是丑数。
 * 输入不会超过 32 位有符号整数的范围: [−2^31,  2^31 − 1]。
 */

public class T263_UglyNumber {

    public static void main(String[] args) {
        System.out.println(original(6));
        System.out.println(original(8));
        System.out.println(original(14));
    }

    private static boolean original(int num) {
        if (num == 0) return false;
        if ((num & 1) == 0) return original(num >> 1);
        if (num % 3 == 0) return original(num / 3);
        if (num % 5 == 0) return original(num / 5);
        return num == 1;
    }
}
