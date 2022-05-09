package me.victor.code;

import java.util.LinkedList;

/**
 * https://leetcode.cn/problems/string-to-integer-atoi/
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
