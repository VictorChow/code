package me.victor.code;

/**
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
 *
 * 注意：
 * num1和num2的长度都小于 5100.
 * num1和num2都只包含数字 0-9.
 * num1和num2都不包含任何前导零。
 * 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式。
 */

public class T415_AddStrings {

    public static void main(String[] args) {
        System.out.println(original("6913259244", "71103343"));
        System.out.println(original("123", "3445"));
        System.out.println(original("1", "23"));
    }

    private static String original(String num1, String num2) {
        var sb = new StringBuilder();
        int i1 = num1.length() - 1, i2 = num2.length() - 1;
        var isCarry = false;
        while (i1 >= 0 || i2 >= 0) {
            var n1 = i1 >= 0 ? num1.charAt(i1--) - 48 : 0;
            var n2 = i2 >= 0 ? num2.charAt(i2--) - 48 : 0;
            var sum = n1 + n2 + (isCarry ? 1 : 0);
            isCarry = sum > 9;
            sb.insert(0, sum % 10);
        }
        if (isCarry) sb.insert(0, "1");
        return sb.toString();
    }
}
