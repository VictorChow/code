package me.victor.easy;

import java.util.List;

/**
 * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 *
 * 示例 1:
 * 输入: "hello"
 * 输出: "holle"
 *
 * 示例 2:
 * 输入: "leetcode"
 * 输出: "leotcede"
 *
 * 说明:
 * 元音字母不包含字母"y"。
 */

public class T345_ReverseVowelsOfAString {

    public static void main(String[] args) {
        System.out.println(original("hello"));
        System.out.println(original("leetcode"));
    }

    private static String original(String s) {
        if (s == null) return null;
        var list = List.of('a', 'A', 'e', 'E', 'i', 'I', 'o', 'O', 'u', 'U');
        var arr = s.toCharArray();
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (!list.contains(arr[l])) {
                l++;
                continue;
            }
            if (!list.contains(arr[r])) {
                r--;
                continue;
            }
            arr[l] ^= arr[r];
            arr[r] ^= arr[l];
            arr[l++] ^= arr[r--];
        }
        return new String(arr);
    }
}
