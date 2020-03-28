package me.victor.easy;

/**
 * Created by victor on 2020/3/27. (ง •̀_•́)ง
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
