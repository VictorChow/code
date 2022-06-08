package me.victor.code;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/interleaving-string/
 */
class T97_InterleavingString {

    public static void main(String[] args) {
        var t = new T97_InterleavingString();
        System.out.println(t.isInterleave("", "", ""));
        System.out.println(t.isInterleave("aabcc", "dbbca", "aadbbcbcac"));
        System.out.println(t.isInterleave("aabcc", "dbbca", "aadbbbaccc"));
        System.out.println(t.isInterleave("aabc", "abad", "aabcabad"));
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;
        var dp = new boolean[s1.length() + 1][s2.length() + 1];
        var chs1 = s1.toCharArray();
        var chs2 = s2.toCharArray();
        var chs3 = s3.toCharArray();
        dp[0][0] = true;
        for (int i = 1; i <= chs2.length; i++) {
            if (chs2[i - 1] == chs3[i - 1]) dp[0][i] = dp[0][i - 1];
        }
        for (int i = 1; i <= chs1.length; i++) {
            if (chs1[i - 1] == chs3[i - 1]) dp[i][0] = dp[i - 1][0];
        }
        for (int i = 1; i <= chs1.length; i++) {
            for (int j = 1; j <= chs2.length; j++) {
                var c1 = chs1[i - 1];
                var c2 = chs2[j - 1];
                var c3 = chs3[i + j - 1];
                dp[i][j] = (c1 == c3 && dp[i - 1][j]) || (c2 == c3 && dp[i][j - 1]);
            }
        }
        return dp[s1.length()][s2.length()];
    }

    public boolean isInterleave2(String s1, String s2, String s3) {
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
        var b = (i1 < chs1.length && chs1[i1] == chs3[i3] && f(map, chs1, i1 + 1, chs2, i2, chs3, i3 + 1)) || (i2 < chs2.length && chs2[i2] == chs3[i3] && f(map, chs1, i1, chs2, i2 + 1, chs3, i3 + 1));
        map.put(key, b);
        return b;
    }
}
