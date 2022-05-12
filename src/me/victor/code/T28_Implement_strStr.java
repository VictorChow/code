package me.victor.code;

/**
 * https://leetcode.cn/problems/implement-strstr/
 */

public class T28_Implement_strStr {

    public static void main(String[] args) {
        System.out.println(original("hello", "ll"));
        System.out.println(original("aaaaa", "bba"));
        System.out.println(original("a", "a"));
    }


    private static int original(String haystack, String needle) {
        if (needle.isEmpty()) return 0;
        else if (haystack.isEmpty()) return -1;
        else if (needle.length() > haystack.length()) return -1;
        for (int i = 0; i < haystack.length(); i++) {
            for (int j = 0; j < needle.length(); j++) {
                if (i + j >= haystack.length() || haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
                if (j == needle.length() - 1) {
                    return i;
                }
            }
        }
        return -1;
    }

    /**
     * KMP的官方样例写不了, 另一个样例是用equals比较, 不是手写比较么...?
     */
    private static int official(String haystack, String needle) {
        int L = needle.length(), n = haystack.length();
        for (int start = 0; start < n - L + 1; ++start) {
            if (haystack.substring(start, start + L).equals(needle)) {
                return start;
            }
        }
        return -1;
    }
}
