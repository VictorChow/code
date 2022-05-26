package me.victor.code;

/**
 * https://leetcode.cn/problems/edit-distance/
 */
class T72_EditDistance {

    public static void main(String[] args) {
        var t = new T72_EditDistance();
        System.out.println(t.minDistance("horse", "ros"));
        System.out.println(t.minDistance("abcde", "ace"));
        System.out.println(t.minDistance("a", "b"));
    }

    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        if (m * n == 0) return m + n;
        //dp[i][j]为长度为i的word1和长度为j的word2的最小编辑距离
        var chs1 = word1.toCharArray();
        var chs2 = word2.toCharArray();
        var dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) dp[i][0] = i;
        for (int i = 1; i <= n; i++) dp[0][i] = i;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (chs1[i - 1] == chs2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    //dp[i - 1][j - 1]是替换,dp[i - 1][j]是删除,dp[i][j - 1]是新增
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i][j - 1]) + 1;
                }
            }
        }
        return dp[m][n];
    }
}
