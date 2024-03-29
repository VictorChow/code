package me.victor.code;

/**
 * 给定一个正整数，输出它的补数。补数是对该数的二进制表示取反。
 *
 * 示例 1:
 * 输入: 5
 * 输出: 2
 * 解释: 5 的二进制表示为 101（没有前导零位），其补数为 010。所以你需要输出 2 。
 *
 * 示例 2:
 * 输入: 1
 * 输出: 0
 * 解释: 1 的二进制表示为 1（没有前导零位），其补数为 0。所以你需要输出 0 。
 *
 * 注意:
 * 给定的整数保证在 32 位带符号整数的范围内。
 * 你可以假定二进制数不包含前导零位。
 */

public class T476_NumberComplement {

    public static void main(String[] args) {
        System.out.println(original(5));
        System.out.println(original(1023));
    }

    private static int original(int num) {
        var r = 0;
        for (int i = 0; i < Integer.SIZE; i++) {
            r |= ~(num >> i) << i;
        }
        for (int i = Integer.SIZE - 1; i >= 0; i--) {
            if (r >>> i == 0) break;
            r ^= 1 << i;
        }
        return r;
    }
}
