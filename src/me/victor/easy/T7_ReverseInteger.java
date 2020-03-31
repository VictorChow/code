package me.victor.easy;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 * 示例 1:
 * 输入: 123
 * 输出: 321
 *
 * 示例 2:
 * 输入: -123
 * 输出: -321
 *
 * 示例 3:
 * 输入: 120
 * 输出: 21
 *
 * 注意:
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 */

public class T7_ReverseInteger {

    public static void main(String[] args) {
        System.out.println(original(123));
        System.out.println(original(-123));
        System.out.println(original(120));
        System.out.println(original(1534236469));

        System.out.println(official(123));
        System.out.println(official(-123));
        System.out.println(official(120));
        System.out.println(official(1534236469));
    }

    private static int original(int x) {
        var str = String.valueOf(x);
        var r = 0L;
        int pow = 0, length = str.length();
        var b = false;
        for (int i = 0; i < length; i++) {
            var c = str.charAt(i);
            if (c == '-') {
                b = true;
                continue;
            }
            r += Integer.parseInt(String.valueOf(c)) * Math.pow(10, pow++);
        }
        return (r > Integer.MAX_VALUE || r < Integer.MIN_VALUE) ? 0 : (int) (b ? -r : r);
    }

    private static int official(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > Integer.MAX_VALUE % 10)) {
                return 0;
            }
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < Integer.MAX_VALUE % 10)) {
                return 0;
            }
            rev = rev * 10 + pop;
        }
        return rev;
    }
}
