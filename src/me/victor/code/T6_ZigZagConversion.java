package me.victor.code;

/**
 * https://leetcode.cn/problems/zigzag-conversion/
 */
public class T6_ZigZagConversion {

    public static void main(String[] args) {
        var t = new T6_ZigZagConversion();
        System.out.println(t.convert("PAYPALISHIRING", 4));
        System.out.println(t.convert("PAYPALISHIRING", 3));
        System.out.println(t.convert("ABC", 1));
        System.out.println(t.convert("AB", 1));
    }

    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        var arr = new StringBuilder[numRows];
        for (var i = 0; i < arr.length; i++) arr[i] = new StringBuilder();
        var i = 0;
        var incr = true;
        for (var ch : s.toCharArray()) {
            if (incr && i == numRows - 1) incr = false;
            if (!incr && i == 0) incr = true;
            arr[incr ? i++ : i--].append(ch);
        }
        var sb = new StringBuilder();
        for (var builder : arr) sb.append(builder.toString());
        return sb.toString();
    }
}
