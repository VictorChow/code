package me.victor.code;

/**
 * https://leetcode.cn/problems/unique-paths-ii/
 */
class T63_UniquePaths2 {

    public static void main(String[] args) {
        var t = new T63_UniquePaths2();
        System.out.println(t.uniquePathsWithObstacles(new int[][]{
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0},
        }));
        System.out.println(t.uniquePathsWithObstacles(new int[][]{
                {0, 1},
                {0, 0},
        }));
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        if (obstacleGrid[m - 1][n - 1] == 1) return 0;
        var dp = new int[m][n];
        for (int i = n - 1; i >= 0; i--) {
            if (obstacleGrid[m - 1][i] == 1) break;
            dp[m - 1][i] = 1;
        }
        for (int i = m - 1; i >= 0; i--) {
            if (obstacleGrid[i][n - 1] == 1) break;
            dp[i][n - 1] = 1;
        }
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                if (obstacleGrid[i][j] == 1) dp[i][j] = 0;
                else dp[i][j] = dp[i][j + 1] + dp[i + 1][j];
            }
        }
        return dp[0][0];
    }

}
