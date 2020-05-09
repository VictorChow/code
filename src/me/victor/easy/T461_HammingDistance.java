package me.victor.easy;

/**
 * 两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
 * 给出两个整数 x 和 y，计算它们之间的汉明距离。
 * 注意：
 * 0 ≤ x, y < 2^^31.
 *
 * 示例:
 * 输入: x = 1, y = 4
 * 输出: 2
 * 解释:
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 *        ↑   ↑
 * 上面的箭头指出了对应二进制位不同的位置。
 */

public class T461_HammingDistance {

    public static void main(String[] args) {
        System.out.println(original(1, 4));
        System.out.println(official(1, 4));
    }

    private static int original(int x, int y) {
        var num = 0;
        for (int i = 0; i < Integer.SIZE; i++) {
            num += (x & 1) ^ (y & 1);
            x >>= 1;
            y >>= 1;
        }
        return num;
    }

    private static int official(int x, int y) {
        return Integer.bitCount(x ^ y);
    }
}
