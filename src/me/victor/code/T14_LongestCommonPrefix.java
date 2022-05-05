package me.victor.code;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 *
 * 示例 2:
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 *
 * 说明:
 * 所有输入只包含小写字母 a-z 。
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
}
