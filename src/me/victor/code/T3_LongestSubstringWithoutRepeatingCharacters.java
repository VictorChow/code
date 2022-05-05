package me.victor.code;


import java.util.HashMap;
import java.util.LinkedHashSet;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *  
 *
 * 提示：
 *
 * 0 <= s.length <= 5 * 104
 * s 由英文字母、数字、符号和空格组成
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
                //                l = map.get(ch);
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
