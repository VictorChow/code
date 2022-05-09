package me.victor.code;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * https://leetcode.cn/problems/longest-common-prefix/
 */

public class T14_LongestCommonPrefix {

    public static void main(String[] args) {
        var arr1 = new String[]{"flower", "flow", "flight"};
        var arr2 = new String[]{"dog", "racecar", "car"};
        var arr3 = new String[]{"aca", "cba"};
        System.out.println(original(arr1));
        System.out.println(original(arr2));
        System.out.println(original(arr3));
        System.out.println(official(arr1));
        System.out.println(official(arr2));
        System.out.println(official(arr3));

        var t = new T14_LongestCommonPrefix();
        System.out.println(t.longestCommonPrefix(arr1));
        System.out.println(t.longestCommonPrefix(arr2));
        System.out.println(t.longestCommonPrefix(arr3));
    }

    private static String original(String[] strs) {
        var sb = new StringBuilder();
        var minStringLength = Arrays.stream(strs).mapToInt(String::length).min().orElse(0);
        for (int i = 0; i < minStringLength; i++) {
            int finalI = i;
            var distinctList = Arrays.stream(strs).map(it -> it.charAt(finalI)).distinct().collect(Collectors.toList());
            if (distinctList.size() == 1) {
                sb.append(distinctList.get(0));
            } else {
                break;
            }
        }
        return sb.toString();
    }

    private static String official(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 1) return strs[0];
        String p = "";
        for (int i = 0; i < strs[0].length(); i++) {
            var ch = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i >= strs[j].length() || ch != strs[j].charAt(i)) return p;
            }
            p += ch;
        }
        return p;
    }
}
