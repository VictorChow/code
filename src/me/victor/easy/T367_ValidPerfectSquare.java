package me.victor.easy;

/**
 * 给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。
 * 说明：不要使用任何内置的库函数，如  sqrt。
 *
 * 示例 1：
 * 输入：16
 * 输出：True
 *
 * 示例 2：
 * 输入：14
 * 输出：False
 */

public class T367_ValidPerfectSquare {

    public static void main(String[] args) {
        System.out.println(original(808201));
        System.out.println(original2(808201));
        //        System.out.println(original(14));
    }

    private static boolean original2(int num) {
        if (num < 0) return false;
        if (num < 2) return true;
        long n = num / 2;
        while (n * n > num) {
            n = (n + num / n) >> 1;
        }
        return n * n == num;
    }

    private static boolean original(int num) {
        if (num < 0) return false;
        if (num < 2) return true;
        return check(num, 0, num / 2);
    }

    private static boolean check(int num, int l, int r) {
        if (l > r) return false;
        long mid = l + ((r - l) >> 1);
        long pow = mid * mid;
        if (pow == num) return true;
        else if (pow < num) return check(num, (int) (mid + 1), r);
        else return check(num, l, (int) (mid - 1));
    }
}
