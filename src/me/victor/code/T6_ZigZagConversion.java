package me.victor.code;

/**
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 *
 * 请你实现这个将字符串进行指定行数变换的函数：
 *
 * string convert(string s, int numRows);
 *  
 *
 * 示例 1：
 *
 * 输入：s = "PAYPALISHIRING", numRows = 3
 * 输出："PAHNAPLSIIGYIR"
 * 示例 2：
 * 输入：s = "PAYPALISHIRING", numRows = 4
 * 输出："PINALSIGYAHRPI"
 * 解释：
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 * 示例 3：
 *
 * 输入：s = "A", numRows = 1
 * 输出："A"
 *  
 *
 * 提示：
 *
 * 1 <= s.length <= 1000
 * s 由英文字母（小写和大写）、',' 和 '.' 组成
 * 1 <= numRows <= 1000
 *
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