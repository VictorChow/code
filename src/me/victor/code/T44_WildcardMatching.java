package me.victor.code;

/**
 * https://leetcode.cn/problems/wildcard-matching/
 */
class T44_WildcardMatching {

    public static void main(String[] args) {
        var t = new T44_WildcardMatching();
        System.out.println(t.isMatch("aa", "a?"));
        System.out.println(t.isMatch("aa", "a**"));
        System.out.println(t.isMatch("aa", ""));
        System.out.println(t.isMatch("", "aa"));
        System.out.println(t.isMatch("", "***"));
        System.out.println(t.isMatch("", ""));
    }

    public boolean isMatch(String s, String p) {
        //dp[i][j]表示长度为i的s串和长度为j的p串是否匹配
        char[] ss = s.toCharArray(), ps = p.toCharArray();
        var dp = new boolean[ss.length + 1][ps.length + 1];
        dp[0][0] = true;
        for (int i = 0; i < ps.length; i++) {
            if (ps[i] == '*') dp[0][i + 1] = dp[0][i];
        }
        for (int i = 1; i <= ss.length; i++) {
            for (int j = 1; j <= ps.length; j++) {
                if (ss[i - 1] == ps[j - 1] || ps[j - 1] == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (ps[j - 1] == '*') {
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j - 1] || dp[i - 1][j];
                }
            }
        }
        return dp[ss.length][ps.length];
    }
}
