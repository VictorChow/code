package me.victor.easy;

/**
 * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
 * 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
 *
 * 注意:
 * 假设字符串的长度不会超过 1010。
 *
 * 示例 1:
 * 输入:
 * "abccccdd"
 * 输出:
 * 7
 *
 * 解释:
 * 我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
 */

public class T409_LongestPalindrome {

    public static void main(String[] args) {
        System.out.println(original("abccccdd"));
    }

    private static int original(String s) {
        if (s == null) return 0;
        var arr = new int[52];
        for (int i = 0; i < s.length(); i++) {
            var c = s.charAt(i);
            arr[c - 65 - ((c >= 'a') ? 6 : 0)]++;
        }
        int single = 0, couple = 0;
        for (int it : arr) {
            if ((it & 1) == 1) {
                single++;
                couple += it - 1;
            } else {
                couple += it;
            }
        }
        return couple + (single > 0 ? 1 : 0);
    }
}
