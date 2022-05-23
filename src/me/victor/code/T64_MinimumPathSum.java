package me.victor.code;

/**
 * https://leetcode.cn/problems/minimum-path-sum/
 */
class T64_MinimumPathSum {

    public static void main(String[] args) {
        var t = new T64_MinimumPathSum();
        System.out.println(t.minPathSum(new int[][]{
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1},
        }));
        System.out.println(t.minPathSum(new int[][]{
                {1, 2, 3},
                {4, 5, 6}
        }));
        System.out.println(t.minPathSum(new int[][]{{8},}));
    }

    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        var dp = new int[m][n];
        dp[m - 1][n - 1] = grid[m - 1][n - 1];
        for (int i = m - 2; i >= 0; i--) {
            dp[i][n - 1] = grid[i][n - 1] + dp[i + 1][n - 1];
        }
        for (int i = n - 2; i >= 0; i--) {
            dp[m - 1][i] = grid[m - 1][i] + dp[m - 1][i + 1];
        }
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                dp[i][j] = grid[i][j] + Math.min(dp[i + 1][j], dp[i][j + 1]);
            }
        }
        return dp[0][0];
    }
}
