package me.victor.easy;

/**
 * 给定一个整数 (32 位有符号整数)，请编写一个函数来判断它是否是 4 的幂次方。
 *
 * 示例 1:
 * 输入: 16
 * 输出: true
 *
 * 示例 2:
 * 输入: 5
 * 输出: false
 */

public class T326_PowerOfFour {

    public static void main(String[] args) {
        System.out.println(original(16));
        System.out.println(original(6));
    }

    private static boolean original(int num) {
        return num > 0 && (num & (num - 1)) == 0 && (num & 0xAAAAAAAA) == 0;
    }
}
