package me.victor.code;

/**
 * https://leetcode.cn/problems/reverse-integer/
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
