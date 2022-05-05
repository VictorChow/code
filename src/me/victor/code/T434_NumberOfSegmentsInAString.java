package me.victor.code;

/**
 * 统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。
 * 请注意，你可以假定字符串里不包括任何不可打印的字符。
 *
 * 示例:
 * 输入: "Hello, my name is John"
 * 输出: 5
 *
 * 解释: 这里的单词是指连续的不是空格的字符，所以 "Hello," 算作 1 个单词。
 */

public class T434_NumberOfSegmentsInAString {

    public static void main(String[] args) {
        System.out.println(original("Hello, my name is John"));
        System.out.println(original("this is a         bird"));
        System.out.println(original("   i'm victor"));
        System.out.println(original("   i'm victor   "));
    }

    private static int original(String s) {
        if (s == null) return 0;
        var count = 0;
        var valid = false;
        for (int i = 0; i < s.length(); i++) {
            var c = s.charAt(i);
            if (c == ' ' && valid) count++;
            valid = c != ' ';
        }
        if (valid) count++;
        return count;
    }
}
