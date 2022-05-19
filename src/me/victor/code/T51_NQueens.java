package me.victor.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/**
 * https://leetcode.cn/problems/n-queens/
 */
class T51_NQueens {

    public static void main(String[] args) {
        var t = new T51_NQueens();
        List<List<String>> lists = t.solveNQueens(3);
        for (int i = 0; i < lists.size(); i++) {
            System.out.println((i + 1) + ": " + lists.get(i));
        }
    }

    public List<List<String>> solveNQueens(int n) {
        var arr = new int[n];
        var ans = new ArrayList<List<String>>();
        Arrays.fill(arr, -1);
        find(ans, arr, 0);
        return ans;
    }

    private void find(List<List<String>> ans, int[] arr, int i) {
        for (byte j = 0; j < arr.length; j++) {
            arr[i] = j;
            if (check(arr)) {
                if (i == arr.length - 1) ans.add(format(arr));
                else find(ans, arr, i + 1);
            }
            arr[i] = -1;
        }
    }

    private List<String> format(int[] arr) {
        var l = new ArrayList<String>();
        for (int i : arr) {
            var bytes = new byte[arr.length];
            Arrays.fill(bytes, (byte) '.');
            bytes[i] = 'Q';
            l.add(new String(bytes));
        }
        return l;
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
