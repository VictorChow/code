package me.victor.code;

import java.util.LinkedList;

/**
 * 示例 1：
 *
 * 输入：s = "42"
 * 输出：42
 * 解释：加粗的字符串为已经读入的字符，插入符号是当前读取的字符。
 * 第 1 步："42"（当前没有读入字符，因为没有前导空格）
 *          ^
 * 第 2 步："42"（当前没有读入字符，因为这里不存在 '-' 或者 '+'）
 *          ^
 * 第 3 步："42"（读入 "42"）
 *            ^
 * 解析得到整数 42 。
 * 由于 "42" 在范围 [-231, 231 - 1] 内，最终结果为 42 。
 * 示例 2：
 *
 * 输入：s = "   -42"
 * 输出：-42
 * 解释：
 * 第 1 步："   -42"（读入前导空格，但忽视掉）
 *             ^
 * 第 2 步："   -42"（读入 '-' 字符，所以结果应该是负数）
 *              ^
 * 第 3 步："   -42"（读入 "42"）
 *                ^
 * 解析得到整数 -42 。
 * 由于 "-42" 在范围 [-231, 231 - 1] 内，最终结果为 -42 。
 * 示例 3：
 *
 * 输入：s = "4193 with words"
 * 输出：4193
 * 解释：
 * 第 1 步："4193 with words"（当前没有读入字符，因为没有前导空格）
 *          ^
 * 第 2 步："4193 with words"（当前没有读入字符，因为这里不存在 '-' 或者 '+'）
 *          ^
 * 第 3 步："4193 with words"（读入 "4193"；由于下一个字符不是一个数字，所以读入停止）
 *              ^
 * 解析得到整数 4193 。
 * 由于 "4193" 在范围 [-231, 231 - 1] 内，最终结果为 4193 。
 *  
 *
 * 提示：
 *
 * 0 <= s.length <= 200
 * s 由英文字母（大写和小写）、数字（0-9）、' '、'+'、'-' 和 '.' 组成
 *
 */
public class T8_StringToInteger {

    public static void main(String[] args) {
        var t = new T8_StringToInteger();
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(t.myAtoi("42"));
        System.out.println(t.myAtoi("   -42"));
        System.out.println(t.myAtoi("4193 with words"));
        System.out.println(t.myAtoi(" a "));
        System.out.println(t.myAtoi("34.5"));
        System.out.println(t.myAtoi("1232132132112"));
        System.out.println(t.myAtoi(" 2147483647"));
        System.out.println(t.myAtoi("-1232132132112"));
        System.out.println(t.myAtoi("-2147483648"));
        System.out.println(t.myAtoi("-2147483647"));
        System.out.println(t.myAtoi("21474836460"));
        System.out.println(t.myAtoi("00000-42a1234"));
        System.out.println(t.myAtoi("  +  413"));
    }

    public int myAtoi(String s) {
        if (s.isBlank()) return 0;
        var chs = s.toCharArray();
        Boolean positive = null;
        var l = 0L;
        var queue = new LinkedList<Character>();
        for (char c : chs) {
            if (c == ' ') {
                if (positive != null) break;
                if (queue.isEmpty()) continue;
                else break;
            }
            if (c == '-' || c == '+') {
                if (positive != null || !queue.isEmpty()) break;
                positive = c == '+';
                continue;
            }
            if (c < '0' || c > '9') break;
            queue.add(c);
        }
        while (!queue.isEmpty()) {
            var c = queue.poll();
            l = l * 10 + (c - '0');
            if ((positive == null || positive) && l > Integer.MAX_VALUE) {
                l = Integer.MAX_VALUE;
                break;
            }
            if ((positive != null && !positive) && l > (long) Integer.MAX_VALUE + 1) {
                l = (long) Integer.MAX_VALUE + 1;
                break;
            }
        }
        return (int) ((positive == null || positive) ? l : -l);
    }
}
