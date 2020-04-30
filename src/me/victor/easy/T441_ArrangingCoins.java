package me.victor.easy;

/**
 * 你总共有 n 枚硬币，你需要将它们摆成一个阶梯形状，第 k 行就必须正好有 k 枚硬币。
 * 给定一个数字 n，找出可形成完整阶梯行的总行数。
 * n 是一个非负整数，并且在32位有符号整型的范围内。
 *
 * 示例 1:
 * n = 5
 * 硬币可排列成以下几行:
 * ¤
 * ¤ ¤
 * ¤ ¤
 * 因为第三行不完整，所以返回2.
 *
 * 示例 2:
 * n = 8
 * 硬币可排列成以下几行:
 * ¤
 * ¤ ¤
 * ¤ ¤ ¤
 * ¤ ¤
 *
 * 因为第四行不完整，所以返回3.
 */

public class T441_ArrangingCoins {

    public static void main(String[] args) {
        System.out.println(original(0));
        System.out.println(original(1));
        System.out.println(original(5));
        System.out.println(original(8));
        System.out.println(original(Integer.MAX_VALUE));
        System.out.println(original(12763812));
    }

    private static int original(int n) {
        return (int) ((-1 + Math.sqrt(1 + 8.0 * n)) / 2);
    }
}
