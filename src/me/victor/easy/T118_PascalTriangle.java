package me.victor.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 *
 * 示例:
 * 输入: 5
 * 输出:
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 */

public class T118_PascalTriangle {

    public static void main(String[] args) {
        var list = original(6);
        list.forEach(System.out::println);
        System.out.println("------");
        list = official(6);
        list.forEach(System.out::println);
    }

    private static List<List<Integer>> original(int numRows) {
        var list = new ArrayList<List<Integer>>();
        for (int i = 0; i <= numRows; i++) {
            var rowList = new ArrayList<Integer>();
            var preList = ((i - 1) >= 0) ? list.get(i - 1) : null;
            for (int j = 0; j < i; j++) {
                if (j == 0 || j == i - 1) {
                    rowList.add(1);
                } else {
                    rowList.add(preList.get(j) + preList.get(j - 1));
                }
            }
            list.add(rowList);
        }
        list.remove(0);
        return list;
    }

    private static List<List<Integer>> official(int numRows) {
        var triangle = new ArrayList<List<Integer>>();
        if (numRows == 0) return triangle;
        triangle.add(new ArrayList<>());
        triangle.get(0).add(1);
        for (int rowNum = 1; rowNum < numRows; rowNum++) {
            var row = new ArrayList<Integer>();
            var prevRow = triangle.get(rowNum - 1);
            row.add(1);
            for (int j = 1; j < rowNum; j++) {
                row.add(prevRow.get(j - 1) + prevRow.get(j));
            }
            row.add(1);
            triangle.add(row);
        }
        return triangle;
    }
}
