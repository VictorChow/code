package me.victor.code;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/minimum-window-substring/
 */
public class T76_MinimumWindowSubstring {

    public static void main(String[] args) {
        var t = new T76_MinimumWindowSubstring();
        //        System.out.println(t.minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(t.minWindow("a", "a"));
        System.out.println(t.minWindow("a", "aa"));
        System.out.println(t.minWindow("ab", "a"));
        System.out.println(t.minWindow("ab", "b"));
        System.out.println(t.minWindow("bdab", "ab"));
        System.out.println(t.minWindow("aafskaaa", "aaa"));
        System.out.println(t.minWindow("aaaabbbbbcdd", "abcdd"));
        System.out.println(t.minWindow("bbaac", "aba"));
        System.out.println(t.minWindow("cgklivwehljxrdzpfdqsapogwvjtvbzahjnsejwnuhmomlfsrvmrnczjzjevkdvroiluthhpqtffhlzyglrvorgnalk", "mqfff"));
    }

    public String minWindow(String s, String t) {
        if (t.length() > s.length()) return "";
        var arr = new int[128];
        for (char c : t.toCharArray()) arr[c]++;
        var str = "";
        int l = 0, count = t.length();
        var chs = s.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            if (arr[chs[i]] > 0) count--;
            arr[chs[i]]--;
            if (count == 0) {
                while (l <= i) {
                    if (arr[chs[l]] + 1 > 0) {
                        str = str.isEmpty() || i - l + 1 < str.length() ? s.substring(l, i + 1) : str;
                        break;
                    } else arr[chs[l++]]++;
                }
                arr[chs[l++]]++;
                count++;
            }
        }
        return str;
    }

    /**
     * 思路有问题，废弃
     */
    public String minWindow2(String s, String t) {
        if (s.length() < t.length()) return "";
        var count = t.length();
        var arr = new int['z' - 'A'];
        Arrays.fill(arr, Integer.MIN_VALUE);
        for (char c : t.toCharArray()) {
            if (arr[c - 'A'] == Integer.MIN_VALUE) arr[c - 'A'] = 0;
            arr[c - 'A']++;
        }
        var min = Integer.MAX_VALUE;
        var str = "";
        int l = -1;
        var chs = s.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            var c = chs[i];
            if (arr[c - 'A'] == Integer.MIN_VALUE) {
                continue;
            }
            if (l == -1) l = i;
            if (arr[c - 'A'] == 0) {
                var b = false;
                for (int j = l; j <= i; j++) {
                    if (arr[chs[j] - 'A'] == Integer.MIN_VALUE) continue;
                    if (b) {
                        l = j;
                        break;
                    }
                    if (chs[j] == c) b = true;
                    else {
                        arr[chs[j] - 'A']++;
                        count++;
                    }
                }
            } else {
                arr[c - 'A']--;
                count--;
            }
            if (count == 0) {
                if (i - l + 1 < min) {
                    min = i - l + 1;
                    str = s.substring(l, i + 1);
                }
            }
        }
        if (count == 0) {
            if (min == Integer.MAX_VALUE || s.length() - l < min) return s.substring(l);
        }
        return str;
    }
}
