package me.victor.code;

/**
 * https://leetcode.cn/problems/decode-ways/
 */
public class T91_DecodeWays {

    public static void main(String[] args) {
        var t = new T91_DecodeWays();
        System.out.println(t.numDecodings("12"));
        System.out.println(t.numDecodings("226"));
        System.out.println(t.numDecodings("10010"));
        System.out.println(t.numDecodings("230"));
    }

    public int numDecodings(String s) {
        var chs = s.toCharArray();
        if (chs[0] == '0') return 0;
        var dp = new int[s.length() + 1];
        dp[0] = 1;
        for (int i = 1; i < dp.length; i++) {
            if (chs[i - 1] == '0') {
                if (chs[i - 2] != '1' && chs[i - 2] != '2') return 0;
                dp[i] = dp[i - 2];
            } else {
                dp[i] = dp[i - 1];
                if (i - 2 >= 0 && (chs[i - 2] == '1' || (chs[i - 1] <= '6' && chs[i - 2] == '2'))) {
                    dp[i] += dp[i - 2];
                }
            }
        }
        return dp[s.length()];
    }
}
