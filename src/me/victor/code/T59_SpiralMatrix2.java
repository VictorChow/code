package me.victor.code;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/spiral-matrix-ii/
 */
class T59_SpiralMatrix2 {

    public static void main(String[] args) {
        var t = new T59_SpiralMatrix2();
        System.out.println(Arrays.deepToString(t.generateMatrix(3)));
    }

    public int[][] generateMatrix(int n) {
        var arr = new int[n][n];
        fill(arr, 0, 0, 0, 0);
        return arr;
    }

    private void fill(int[][] matrix, int count, int mode, int r, int c) {
        if (count++ == matrix[0].length * matrix.length) return;
        matrix[r][c] = count;
        if (mode == 0) {
            if (c + 1 == matrix[0].length || matrix[r][c + 1] != 0) {
                mode = 1;
                r++;
            } else c++;
        } else if (mode == 1) {
            if (r + 1 == matrix.length || matrix[r + 1][c] != 0) {
                mode = 2;
                c--;
            } else r++;
        } else if (mode == 2) {
            if (c - 1 < 0 || matrix[r][c - 1] != 0) {
                mode = 3;
                r--;
            } else c--;
        } else if (mode == 3) {
            if (r - 1 < 0 || matrix[r - 1][c] != 0) {
                mode = 0;
                c++;
            } else r--;
        }
        fill(matrix, count, mode, r, c);
    }
}
