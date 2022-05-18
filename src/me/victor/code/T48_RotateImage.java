package me.victor.code;

import java.util.Arrays;

import me.victor.code.util.Util;

/**
 * https://leetcode.cn/problems/rotate-image/
 */
class T48_RotateImage {

    public static void main(String[] args) {
        var t = new T48_RotateImage();
        var arr1 = new int[][]{
                Util.arr(5, 1, 9, 11),
                Util.arr(2, 4, 8, 10),
                Util.arr(13, 3, 6, 7),
                Util.arr(15, 14, 12, 16)
        };
        t.rotate(arr1);

        for (int[] ints : arr1) {
            System.out.println(Arrays.toString(ints));
        }
    }

    public void rotate(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < i; j++) {
                matrix[i][j] ^= matrix[j][i];
                matrix[j][i] ^= matrix[i][j];
                matrix[i][j] ^= matrix[j][i];
            }
        }
        for (int[] ints : matrix) {
            for (int i = 0; i < ints.length / 2; i++) {
                ints[i] ^= ints[ints.length - 1 - i];
                ints[ints.length - 1 - i] ^= ints[i];
                ints[i] ^= ints[ints.length - 1 - i];
            }
        }
    }
}
