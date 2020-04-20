package me.victor.easy;

import java.util.LinkedHashMap;

/**
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 *
 * 案例:
 * s = "leetcode"
 * 返回 0.
 *
 * s = "loveleetcode",
 * 返回 2.
 *
 * 注意事项：您可以假定该字符串只包含小写字母。
 */

public class T387_FirstUniqueCharacterInAString {

    public static void main(String[] args) {
        System.out.println(original(""));
        System.out.println(original("aabbcc"));
        System.out.println(original("leetcode"));
        System.out.println(original("loveleetcode"));
        System.out.println(original("dsfnasidufyysenrawierhaewiu"));
    }

    private static int original(String s) {
        if (s == null) return -1;
        var map = new LinkedHashMap<Character, Integer>((int) (s.length() / 0.75 + 1));
        for (int i = 0; i < s.length(); i++) {
            var c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        //        for (Map.Entry<Character, Integer> it : map.entrySet()) {
        //            if (it.getValue() == 1) return s.indexOf(it.getKey());
        //        }
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) return i;
        }
        return -1;
    }
}
