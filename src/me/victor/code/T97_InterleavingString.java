package me.victor.code;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/interleaving-string/
 */
class T97_InterleavingString {

    public static void main(String[] args) {
        var t = new T97_InterleavingString();
        //        System.out.println(t.isInterleave("", "", ""));
        //        System.out.println(t.isInterleave("aabcc", "dbbca", "aadbbcbcac"));
        //        System.out.println(t.isInterleave("aabcc", "dbbca", "aadbbbaccc"));
        System.out.println(t.isInterleave("aabc", "abad", "aabcabad"));
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;
        return f(new HashMap<>(), s1.toCharArray(), 0, s2.toCharArray(), 0, s3.toCharArray(), 0);
    }

    private boolean f(Map<String, Boolean> map, char[] chs1, int i1, char[] chs2, int i2, char[] chs3, int i3) {
        var key = i1 + "-" + i2 + "-" + i3;
        if (map.containsKey(key)) return map.get(key);
        if (i3 == chs3.length) {
            map.put(key, true);
            return true;
        }
        var c3 = chs3[i3];
        var b = false;
        if (i1 < chs1.length) {
            var c1 = chs1[i1];
            if (c1 == c3) {
                if (f(map, chs1, i1 + 1, chs2, i2, chs3, i3 + 1)) b = true;
            }
        }
        if (i2 < chs2.length) {
            var c2 = chs2[i2];
            if (c2 == c3) {
                if (f(map, chs1, i1, chs2, i2 + 1, chs3, i3 + 1)) b = true;
            }
        }
        map.put(key, b);
        return b;
    }
}
