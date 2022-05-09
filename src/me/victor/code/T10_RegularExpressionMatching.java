package me.victor.code;

import java.util.LinkedList;

/**
 * https://leetcode.cn/problems/regular-expression-matching/
 */
public class T10_RegularExpressionMatching {

    public static void main(String[] args) {
        var t = new T10_RegularExpressionMatching();
        System.out.println(t.isMatch("xxxabc", ".*abc"));
        System.out.println(t.isMatch("abc", "a*bc"));
        System.out.println(t.isMatch("aaaa", "a*"));
        System.out.println(t.isMatch("a", "a"));
        System.out.println(t.isMatch("aa", "a*"));
        System.out.println(t.isMatch("a", "a*"));
        System.out.println(t.isMatch("abc", "a*abc"));
        System.out.println(t.isMatch("aab", "c*a*b"));
        System.out.println(t.isMatch("a", "ab*"));
        System.out.println(t.isMatch("aaa", "ab*a*c*a"));
        System.out.println(t.isMatch("abcdede", "ab.*de"));
        System.out.println(t.isMatch("", "a*"));
        System.out.println("~~~~~~~");
        System.out.println(t.isMatch("abcabbc", ".*abc"));
        System.out.println(t.isMatch("aa", "a"));
        System.out.println(t.isMatch("ab", ".c*"));
        System.out.println(t.isMatch("", "a"));
        System.out.println(t.isMatch("aaa", "aaaa"));
        System.out.println(t.isMatch("a", ".*..a*"));
    }

    public boolean isMatch(String s, String p) {
        char[] cs = s.toCharArray(), cp = p.toCharArray();
        var dp = new boolean[cs.length + 1][cp.length + 1];
        dp[0][0] = true;
        for (int i = 1; i < cp.length + 1; i++) {
            if (cp[i - 1] == '*') {
                dp[0][i] = dp[0][i - 2];
            }
        }
        for (int i = 1; i < cs.length + 1; i++) {
            for (int j = 1; j < cp.length + 1; j++) {
                if (cs[i - 1] == cp[j - 1] || cp[j - 1] == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (cp[j - 1] == '*') {
                    if (cs[i - 1] == cp[j - 2] || cp[j - 2] == '.') {
                        dp[i][j] = dp[i][j - 2] || dp[i][j - 1] || dp[i - 1][j];
                    } else {
                        dp[i][j] = dp[i][j - 2];
                    }
                }
            }
        }
        return dp[cs.length][cp.length];
    }

    public boolean isMatch1(String s, String p) {
        var queue = new LinkedList<R>();
        for (char c : p.toCharArray()) {
            var pre = queue.peekLast();
            if (c != '*') {
                if (pre != null && pre.asterisk && pre.c == '.') {
                    pre.dotNext = c;
                }
                queue.add(new R(c));
            } else pre.asterisk = true;
        }
        int i = 0, j = 0;
        var chs = s.toCharArray();
        R lastAsterisk = null;
        while (i < chs.length) {
            if (j == queue.size()) return false;
            var c = chs[i];
            var r = queue.get(j);
            var b = r.match(c);
            if (r.asterisk) {
                if (c == r.dotNext) {
                    j++;
                    continue;
                }
                if (b) {
                    if (r.matchedCount > 0) {
                        lastAsterisk = r;
                        if (j + 1 < queue.size()) {
                            var r2 = queue.get(j + 1);
                            if (r2.c == r.c) queue.remove(j + 1);
                        }
                        i++;
                    } else {
                        j++;
                    }
                } else {
                    j++;
                }
            } else {
                if (b) {
                    i++;
                    j++;
                } else {
                    return false;
                }
            }
        }
        int c = 0;
        for (int k = j; k < queue.size(); k++) {
            R r2 = queue.get(k);
            if (r2.asterisk || (lastAsterisk != null && lastAsterisk.c == r2.c && --lastAsterisk.matchedCount > 0)) {
                continue;
            }
            c++;
        }
        return c == 0;
    }

    private static class R {
        private final char c;
        private boolean asterisk;
        private int matchedCount;
        private char dotNext;

        public R(char c) {
            this.c = c;
        }

        private boolean match(char c) {
            var b = this.c == '.' || this.c == c;
            if (asterisk && b) {
                matchedCount++;
            }
            return b;
        }

        @Override
        public String toString() {
            return c + (asterisk ? "*" : "") + (dotNext == 0 ? "" : "(" + dotNext + ")");
        }
    }
}
