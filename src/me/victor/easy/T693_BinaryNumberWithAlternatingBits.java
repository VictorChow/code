package me.victor.easy;

/**
 * 给定一个正整数，检查他是否为交替位二进制数：换句话说，就是他的二进制数相邻的两个位数永不相等。
 *
 * 示例 1:
 * 输入: 5
 * 输出: True
 * 解释:
 * 5的二进制数是: 101
 *
 * 示例 2:
 * 输入: 7
 * 输出: False
 * 解释:
 * 7的二进制数是: 111
 *
 * 示例 3:
 * 输入: 11
 * 输出: False
 * 解释:
 * 11的二进制数是: 1011
 *
 *  示例 4:
 * 输入: 10
 * 输出: True
 * 解释:
 * 10的二进制数是: 1010
 */

public class T693_BinaryNumberWithAlternatingBits {

    public static void main(String[] args) {
        System.out.println(original(5));
        System.out.println(original(7));
        System.out.println(original(11));
        System.out.println(original(10));
    }

    private static boolean original(int n) {
        if (n <= 0) return false;
        var find1 = false;
        var checkBit = 1;
        for (int i = Integer.SIZE - 1; i >= 0; i--) {
            var bit = n >>> i & 1;
            if (!find1) {
                if (bit == 0) continue;
                else find1 = true;
            }
            if (checkBit != bit) return false;
            checkBit = 1 - checkBit;
        }
        return true;
    }
}
