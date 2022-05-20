package me.victor.code;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/spiral-matrix/
 */
class T54_SpiralMatrix {

    public static void main(String[] args) {
        var t = new T54_SpiralMatrix();
        var matrix = new int[][]{
                {1, 2, 3, 4},
                {10, 11, 12, 5},
                {9, 8, 7, 6}
        };
        System.out.println(t.spiralOrder(matrix));
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        var list = new ArrayList<Integer>();
        var bool = new boolean[matrix.length][matrix[0].length];
        print(list, matrix, bool, 0, 0, 0, 0);
        return list;
    }

    private void print(List<Integer> list, int[][] matrix, boolean[][] bool, int count, int mode, int r, int c) {
        if (count == matrix[0].length * matrix.length) return;
        list.add(matrix[r][c]);
        bool[r][c] = true;
        if (mode == 0) {
            if (c + 1 == matrix[0].length || bool[r][c + 1]) {
                mode = 1;
                r++;
            } else c++;
        } else if (mode == 1) {
            if (r + 1 == matrix.length || bool[r + 1][c]) {
                mode = 2;
                c--;
            } else r++;
        } else if (mode == 2) {
            if (c - 1 < 0 || bool[r][c - 1]) {
                mode = 3;
                r--;
            } else c--;
        } else if (mode == 3) {
            if (r - 1 < 0 || bool[r - 1][c]) {
                mode = 0;
                c++;
            } else r--;
        }
        print(list, matrix, bool, count + 1, mode, r, c);
    }
}
