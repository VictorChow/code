package me.victor.code;

import java.util.HashMap;

/**
 * 给定两个字符串 s 和 t，判断它们是否是同构的。
 * 如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
 * 所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。
 *
 * 示例 1:
 * 输入: s = "egg", t = "add"
 * 输出: true
 *
 * 示例 2:
 * 输入: s = "foo", t = "bar"
 * 输出: false
 *
 * 示例 3:
 * 输入: s = "paper", t = "title"
 * 输出: true
 *
 * 说明:
 * 你可以假设 s 和 t 具有相同的长度。
 */

public class T205_IsomorphicStrings {

    public static void main(String[] args) {
        System.out.println(original("egg", "add"));
        System.out.println(original("foo", "bar"));
        System.out.println(original("paper", "title"));
        System.out.println("----------");
        System.out.println(better("egg", "add"));
        System.out.println(better("foo", "bar"));
        System.out.println(better("paper", "title"));
    }

    private static boolean original(String s, String t) {
        var map = new HashMap<Character, Character>((int) (s.length() / 0.75 + 1));
        for (int i = 0; i < s.length(); i++) {
            var cs = s.charAt(i);
            var ct = t.charAt(i);
            var b = map.containsKey(cs);
            if (b && map.get(cs) != ct) return false;
            if (!b) {
                if (map.containsValue(ct)) return false;
                map.put(cs, ct);
            }
        }
        return true;
    }

    private static boolean better(String s, String t) {
        int[] arrS = new int[128], arrT = new int[128];
        for (int i = 0; i < s.length(); i++) {
            var cs = s.charAt(i);
            var ct = t.charAt(i);
            if (arrS[cs] != arrT[ct]) return false;
            if (arrS[cs] == 0) {
                arrS[cs] = i + 1;
                arrT[ct] = i + 1;
            }
        }
        return true;
    }
}
