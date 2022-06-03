package me.victor.code;

import me.victor.code.util.Util;

import java.util.Stack;

public class T85_MaximalRectangle {

    public static void main(String[] args) {
        var t = new T85_MaximalRectangle();
        System.out.println(t.maximalRectangle(Util.arrChar2d("[[\"1\",\"0\",\"1\",\"0\",\"0\"],[\"1\",\"0\",\"1\",\"1\",\"1\"],[\"1\",\"1\",\"1\",\"1\",\"1\"],[\"1\",\"0\",\"0\",\"1\",\"0\"]]")));
    }


    public int maximalRectangle(char[][] matrix) {
        var max = 0;
        for (int i = matrix.length - 1; i >= 0; i--) {
            var chars = matrix[i];
            var nums = new int[chars.length + 2];
            for (int j = 0; j < chars.length; j++) {
                for (int k = i; k >= 0; k--) {
                    if (matrix[k][j] == '0') break;
                    nums[j + 1]++;
                }
            }
            var stack = new Stack<Integer>();
            for (int n = 0; n < nums.length; n++) {
                while (!stack.isEmpty() && nums[n] < nums[stack.peek()]) {
                    var pop = stack.pop();
                    var h = nums[pop];
                    var w = n - stack.peek() - 1;
                    var area = h * w;
                    max = Math.max(max, area);
                }
                stack.push(n);
            }
        }
        return max;
    }
}
