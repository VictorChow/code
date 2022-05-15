package me.victor.code;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/sudoku-solver/
 */
class T37_SudokuSolver {

    public static void main(String[] args) {
        var t = new T37_SudokuSolver();
        var chs = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        System.out.println(Arrays.deepToString(chs));
        t.solveSudoku(chs);
        System.err.println(Arrays.deepToString(chs));
    }

    public void solveSudoku(char[][] board) {
        boolean[][] row = new boolean[9][9], col = new boolean[9][9], box = new boolean[9][9];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '.') continue;
                var idx = board[i][j] - '0' - 1;
                row[i][idx] = col[j][idx] = box[i / 3 * 3 + j / 3][idx] = true;
            }
        }
        fill(board, row, col, box, 0);
    }

    private boolean fill(char[][] board, boolean[][] row, boolean[][] col, boolean[][] box, int n) {
        if (n == 81) return true;
        int i = n / 9, j = n % 9;
        if (board[i][j] == '.') {
            for (int k = 0; k < 9; k++) {
                if (row[i][k] || col[j][k] || box[i / 3 * 3 + j / 3][k]) continue;
                row[i][k] = col[j][k] = box[i / 3 * 3 + j / 3][k] = true;
                board[i][j] = (char) (k + '0' + 1);
                if (fill(board, row, col, box, n + 1)) return true;
                board[i][j] = '.';
                row[i][k] = col[j][k] = box[i / 3 * 3 + j / 3][k] = false;
            }
        } else return fill(board, row, col, box, n + 1);
        return false;
    }
}
