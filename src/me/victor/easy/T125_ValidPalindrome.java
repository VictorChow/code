package me.victor.easy;

/**
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * 示例 1:
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 *
 * 示例 2:
 * 输入: "race a car"
 * 输出: false
 */

public class T125_ValidPalindrome {

    public static void main(String[] args) {
        System.out.println(original("A man, a plan, a canal: Panama"));
        System.out.println(original("race a car"));
    }

    private static boolean original(String s) {
        if (s.isEmpty()) return true;
        int l = 0, r = s.length() - 1;
        while (l < r) {
            char lc = s.charAt(l), rc = s.charAt(r);
            if (!valid(lc)) {
                l++;
                continue;
            }
            if (!valid(rc)) {
                r--;
                continue;
            }
            if ((lc & 0xDF) != (rc & 0xDF)) return false;
            l++;
            r--;
        }
        return true;
    }

    private static boolean valid(char c) {
        return (c >= '0' && c <= '9') || (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }
}
