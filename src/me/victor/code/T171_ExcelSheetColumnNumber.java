package me.victor.code;

/**
 * 给定一个Excel表格中的列名称，返回其相应的列序号。
 * 例如，
 *     A -> 1
 *     B -> 2
 *     C -> 3
 *     ...
 *     Z -> 26
 *     AA -> 27
 *     AB -> 28
 *     ...
 *
 * 示例 1:
 * 输入: "A"
 * 输出: 1
 *
 * 示例 2:
 * 输入: "AB"
 * 输出: 28
 *
 * 示例 3:
 * 输入: "ZY"
 * 输出: 701
 */

public class T171_ExcelSheetColumnNumber {

    public static void main(String[] args) {
        System.out.println(original("A"));
        System.out.println(original("AB"));
        System.out.println(original("ZY"));
        System.out.println(original("ACBD"));
    }

    private static int original(String s) {
        int num = 0, pow = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            var digit = s.charAt(i) - 64;
            num += digit * (int) Math.pow(26, pow++);
        }
        return num;
    }
}
