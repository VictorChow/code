package me.victor.easy;

import java.util.Arrays;

/**
 * 给定两个字符串 s 和 t，它们只包含小写字母。
 * 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
 * 请找出在 t 中被添加的字母。
 *
 * 示例:
 * 输入：
 * s = "abcd"
 * t = "abcde"
 * 输出：
 * e
 * 解释：
 * 'e' 是那个被添加的字母。
 */

public class T389_FindTheDifference {

    public static void main(String[] args) {
        System.out.println(original("abcd", "debac"));
        System.out.println(original2("abcd", "debac"));
        System.out.println(original3("abcd", "debac"));
    }

    private static char original3(String s, String t) {
        var n = 0;
        for (int i = 0; i < t.length(); i++) n += t.charAt(i);
        for (int i = 0; i < s.length(); i++) n -= s.charAt(i);
        return (char) n;
    }

    private static char original2(String s, String t) {
        var arr = new int[26];
        for (int i = 0; i < s.length(); i++) arr[s.charAt(i) - 'a']++;
        for (int i = 0; i < t.length(); i++) arr[t.charAt(i) - 'a']--;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                return (char) (i + 'a');
            }
        }
        throw new RuntimeException();
    }

    private static char original(String s, String t) {
        char[] arr1 = s.toCharArray(), arr2 = t.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        for (int i = 0; i < arr1.length; i++) {
            char c1 = arr1[i];
            char c2 = arr2[i];
            if (c1 != c2) return c2;
        }
        return arr2[arr2.length - 1];
    }
}
