package me.victor.code;

/**
 * https://leetcode.cn/problems/word-search/
 */
class T79_WordSearch {

    public static void main(String[] args) {
        var t = new T79_WordSearch();
        //        System.out.println(t.exist(new char[][]{
        //                {'A', 'B', 'C', 'E'},
        //                {'S', 'F', 'C', 'S'},
        //                {'A', 'D', 'E', 'E'}
        //        }, "ABCCED"));
        //
        //        System.out.println(t.exist(new char[][]{
        //                {'A', 'B', 'C', 'E'},
        //                {'S', 'F', 'C', 'S'},
        //                {'A', 'D', 'E', 'E'}
        //        }, "SEE"));

        //        System.out.println(t.exist(new char[][]{
        //                {'A', 'B', 'C', 'E'},
        //                {'S', 'F', 'C', 'S'},
        //                {'A', 'D', 'E', 'E'}
        //        }, "ABCB"));

        System.out.println(t.exist(new char[][]{
                {'A'}
        }, "A"));
    }

    public boolean exist(char[][] board, String word) {
        var ch = word.charAt(0);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == ch) {
                    if (exist(board, i, j, new boolean[board.length][board[0].length], word.toCharArray(), 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean exist(char[][] board, int r, int c, boolean[][] flags, char[] words, int idx) {
        if (r >= board.length || c >= board[0].length || r < 0 || c < 0) return false;
        if (idx == words.length - 1) return true;
        if (flags[r][c] || board[r][c] != words[idx]) return false;
        flags[r][c] = true;
        var b = exist(board, r + 1, c, flags, words, idx + 1) ||
                exist(board, r - 1, c, flags, words, idx + 1) ||
                exist(board, r, c + 1, flags, words, idx + 1) ||
                exist(board, r, c - 1, flags, words, idx + 1);
        flags[r][c] = false;
        return b;
    }
}
