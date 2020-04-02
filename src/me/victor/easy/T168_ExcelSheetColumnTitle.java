package me.victor.easy;

/**
 * 给定一个正整数，返回它在 Excel 表中相对应的列名称。
 * 例如，
 *     1 -> A
 *     2 -> B
 *     3 -> C
 *     ...
 *     26 -> Z
 *     27 -> AA
 *     28 -> AB
 *     ...
 * 示例 1:
 * 输入: 1
 * 输出: "A"
 *
 * 示例 2:
 * 输入: 28
 * 输出: "AB"
 *
 * 示例 3:
 * 输入: 701
 * 输出: "ZY"
 *
 * 示例 4:
 * 输入: 705
 * 输出: "AAC"
 */

public class T168_ExcelSheetColumnTitle {

    public static void main(String[] args) {
        //        System.out.println(original(26));
        //        System.out.println("----");
        //        System.out.println(original(28));
        //        System.out.println("----");
        //        System.out.println(original(701));
        //        System.out.println("----");
        System.out.println(original(702));
        //        System.out.println("----");
        //        System.out.println(original(705));
    }

    private static String original(int n) {
        var sb = new StringBuilder();
        //        while (true) {
        //            if (n <= 26) {
        //                sb.insert(0, getChar(n - 1));
        //                break;
        //            }
        //            var remainder = n % 26;
        //            if (remainder == 0) {
        //                remainder = 26;
        //                n -= 26;
        //            }
        //            sb.insert(0, getChar(remainder - 1));
        //            n /= 26;
        //        }
        do {
            var remainder = n % 26;
            if (remainder == 0) {
                remainder = 26;
                n -= 26;
            }
            sb.insert(0, (char) ('A' + remainder - 1));
            n /= 26;
        } while (n > 0);
        return sb.toString();
    }
}
