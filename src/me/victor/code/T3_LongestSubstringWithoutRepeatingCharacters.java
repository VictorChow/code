package me.victor.code;


import java.util.HashMap;
import java.util.LinkedHashSet;

/**
 * https://leetcode.cn/problems/longest-substring-without-repeating-characters/
 */
public class T3_LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        var t = new T3_LongestSubstringWithoutRepeatingCharacters();
        System.out.println(t.lengthOfLongestSubstring("abba"));
        System.out.println(t.lengthOfLongestSubstring("cdd"));
        System.out.println(t.lengthOfLongestSubstring("a"));
        System.out.println(t.lengthOfLongestSubstring("au"));
        System.out.println(t.lengthOfLongestSubstring("aa"));
        System.out.println(t.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(t.lengthOfLongestSubstring("bbbbb"));
        System.out.println(t.lengthOfLongestSubstring("pwwkew"));
    }

    private int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) return s.length();
        char[] chars = s.toCharArray();
        int l = 0, max = 1;
        for (int i = 1; i < chars.length; i++) {
            for (int j = l; j < i; j++) {
                if (chars[i] == chars[j]) {
                    l = j + 1;
                    break;
                }
            }
            max = Math.max(max, i - l + 1);
        }
        return max;
    }

    public int lengthOfLongestSubstring2(String s) {
        if (s.isEmpty()) return 0;
        int l = -1, r = 0, max = 0;
        var map = new HashMap<Character, Integer>();
        char[] chs = s.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            char ch = chs[i];
            if (map.containsKey(ch)) {
                max = Math.max(max, r - l);
                l = Math.max(map.get(ch), l);
            }
            r = i;
            map.put(ch, i);
        }
        return Math.max(max, r - l);
    }

    /**
     * 超时
     */
    public int lengthOfLongestSubstring1(String s) {
        var max = 0;
        var set = new LinkedHashSet<Character>();
        for (int i = 0; i < s.length(); i++) {
            set.clear();
            for (int j = i; j < s.length(); j++) {
                char ch = s.charAt(j);
                if (set.contains(ch)) {
                    if (set.size() > max) {
                        max = set.size();
                    }
                    set.clear();
                } else {
                    set.add(ch);
                }
            }
            if (set.size() > max) {
                max = set.size();
            }
        }
        return max;
    }
}
