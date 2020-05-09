package me.victor.easy;

import java.util.List;

/**
 * 给定两个整数 L 和 R ，找到闭区间 [L, R] 范围内，计算置位位数为质数的整数个数。
 * （注意，计算置位代表二进制表示中1的个数。例如 21 的二进制表示 10101 有 3 个计算置位。还有，1 不是质数。）
 *
 * 示例 1:
 * 输入: L = 6, R = 10
 * 输出: 4
 * 解释:
 * 6 -> 110 (2 个计算置位，2 是质数)
 * 7 -> 111 (3 个计算置位，3 是质数)
 * 9 -> 1001 (2 个计算置位，2 是质数)
 * 10-> 1010 (2 个计算置位，2 是质数)
 *
 * 示例 2:
 * 输入: L = 10, R = 15
 * 输出: 5
 * 解释:
 * 10 -> 1010 (2 个计算置位, 2 是质数)
 * 11 -> 1011 (3 个计算置位, 3 是质数)
 * 12 -> 1100 (2 个计算置位, 2 是质数)
 * 13 -> 1101 (3 个计算置位, 3 是质数)
 * 14 -> 1110 (3 个计算置位, 3 是质数)
 * 15 -> 1111 (4 个计算置位, 4 不是质数)
 *
 * 注意:
 * L, R 是 L <= R 且在 [1, 10^6] 中的整数。
 * R - L 的最大值为 10000。
 */

public class T762_PrimeNumberOfSetBitsInBinaryRepresentation {

    public static void main(String[] args) {
        System.out.println(original(800, 1000));
        System.out.println(modified(800, 1000));
        System.out.println(best(800, 1000));
    }

    private static int original(int l, int r) {
        var num = 0;
        var list = List.of(2, 3, 5, 7, 11, 13, 17, 19);
        for (int i = l; i <= r; i++) {
            var count = 0;
            for (int j = 0; j < Integer.SIZE; j++) {
                if ((i >>> j & 1) == 1) count++;
            }
            if (list.contains(count)) num++;
        }
        return num;
    }

    private static int modified(int l, int r) {
        var num = 0;
        var list = List.of(2, 3, 5, 7, 11, 13, 17, 19);
        for (int i = l; i <= r; i++) {
            var count = Integer.bitCount(i);
            if (list.contains(count)) num++;
        }
        return num;
    }

    private static int best(int l, int r) {
        int res = 0;
        for (int i = l; i <= r; i++) {
            //665772的二进制表示是0000 0000 0000 1010 0010 1000 1010 1100，所有的1都在质数位置
            res += 665772 >> Integer.bitCount(i) & 1;
        }
        return res;
    }
}
