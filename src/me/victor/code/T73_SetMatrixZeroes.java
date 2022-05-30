package me.victor.code;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import me.victor.code.util.Util;

/**
 * https://leetcode.cn/problems/set-matrix-zeroes/
 */
class T73_SetMatrixZeroes {

    public static void main(String[] args) {
        var t = new T73_SetMatrixZeroes();
        var arr1 = new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        t.setZeroes(arr1);
        var arr2 = new int[][]{{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        t.setZeroes(arr2);
        Util.print(arr2);
    }

    public void setZeroes(int[][] matrix) {
        Set<Integer> row = new HashSet<>();
        Set<Integer> col = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    row.add(i);
                    col.add(j);
                }
            }
        }
        for (int i : row) Arrays.fill(matrix[i], 0);
        for (int i : col) {
            for (int[] ints : matrix) {
                ints[i] = 0;
            }
        }
    }
}
