package me.victor.code;

/**
 * https://leetcode.cn/problems/length-of-last-word/
 */
public class T58_LengthOfLastWord {

    public static void main(String[] args) {
        var t = new T58_LengthOfLastWord();
        System.out.println(t.lengthOfLastWord("hello word"));
    }

    private static int official(String s) {
        int end = s.length() - 1;
        while (end >= 0 && s.charAt(end) == ' ') end--;
        if (end < 0) return 0;
        int start = end;
        while (start >= 0 && s.charAt(start) != ' ') start--;
        return end - start;
    }

    public int lengthOfLastWord(String s) {
        var trimmed = s.trim();
        var index = trimmed.lastIndexOf(" ");
        return (index == -1) ? trimmed.length() : trimmed.length() - index - 1;
    }
}
