package me.victor.code;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * https://leetcode.cn/problems/n-queens-ii/
 */
class T51_NQueens2 {

    public static void main(String[] args) {
        var t = new T51_NQueens2();
        System.out.println(t.totalNQueens(1));
        System.out.println(t.totalNQueens(2));
        System.out.println(t.totalNQueens(3));
        System.out.println(t.totalNQueens(4));
        System.out.println(t.totalNQueens(5));
        System.out.println(t.totalNQueens(6));
        System.out.println(t.totalNQueens(7));
        System.out.println(t.totalNQueens(8));
        System.out.println(t.totalNQueens(9));
    }

    public int totalNQueens(int n) {
        var arr = new int[n];
        var ans = new int[1];
        Arrays.fill(arr, -1);
        find(ans, arr, 0);
        return ans[0];
    }

    private void find(int ans[], int[] arr, int i) {
        for (byte j = 0; j < arr.length; j++) {
            arr[i] = j;
            if (check(arr)) {
                if (i == arr.length - 1) ans[0]+=1;
                else find(ans, arr, i + 1);
            }
            arr[i] = -1;
        }
    }

    private boolean check(int[] arr) {
        var line = IntStream.range(0, arr.length).filter(it -> arr[it] == -1).findFirst().orElse(arr.length);
        long v = 0;
        for (int i = 0; i < line; i++) {
            long flag = 1L << arr[i] //检查竖向
                    | 1L << (i + arr[i] + 16) //检查斜向"/"
                    | 1L << (i - arr[i] + 40); //检查斜向"\"
            if ((v & flag) != 0) {
                return false;
            }
            v |= flag;
        }
        return true;
    }

}
