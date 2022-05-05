package me.victor.code;

/**
 * 给定一个仅包含大小写字母和空格 ' ' 的字符串 s，返回其最后一个单词的长度。如果字符串从左向右滚动显示，那么最后一个单词就是最后出现的单词。
 * 如果不存在最后一个单词，请返回 0 。
 * 说明：一个单词是指仅由字母组成、不包含任何空格字符的 最大子字符串。
 *
 * 示例:
 * 输入: "Hello World"
 * 输出: 5
 */

public class T58_LengthOfLastWord {

    public static void main(String[] args) {
        System.out.println(original("Hello World"));
        System.out.println(original("a b c"));
        System.out.println(original("good"));
        System.out.println(original("a "));
    }

    private static int original(String s) {
        var trimmed = s.trim();
        var index = trimmed.lastIndexOf(" ");
        return (index == -1) ? trimmed.length() : trimmed.length() - index - 1;
    }

    private static int official(String s) {
        int end = s.length() - 1;
        while (end >= 0 && s.charAt(end) == ' ') end--;
        if (end < 0) return 0;
        int start = end;
        while (start >= 0 && s.charAt(start) != ' ') start--;
        return end - start;
    }
}
