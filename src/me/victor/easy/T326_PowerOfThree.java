package me.victor.easy;

/**
 * 给定一个整数，写一个函数来判断它是否是 3 的幂次方。
 *
 * 示例 1:
 * 输入: 27
 * 输出: true
 *
 * 示例 2:
 * 输入: 0
 * 输出: false
 *
 * 示例 3:
 * 输入: 9
 * 输出: true
 *
 * 示例 4:
 * 输入: 45
 * 输出: false
 */

public class T326_PowerOfThree {

    public static void main(String[] args) {
        System.out.println(original(27));
        System.out.println(original(0));
        System.out.println(original(9));
        System.out.println(original(45));
    }

    private static boolean original(int n) {
        if (n <= 0) return false;
        if (n % 3 == 0) return original(n / 3);
        return n == 1;
    }
}
