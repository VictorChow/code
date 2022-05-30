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

        System.out.println(t.exist(new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        }, "SEE"));
    }

    public boolean exist(char[][] board, String word) {
        return exist(board, 0, 0, new boolean[board.length][board[0].length], word.toCharArray(), 0);
    }

    public boolean exist(char[][] board, int r, int c, boolean[][] flags, char[] words, int idx) {
        if (r >= board.length || c >= board[0].length || r < 0 || c < 0) return false;
//        if (flags[r][c]) {
//            return exist(board, r + 1, c, flags, words, idx) ||
//                    exist(board, r - 1, c, flags, words, idx) ||
//                    exist(board, r, c + 1, flags, words, idx) ||
//                    exist(board, r, c - 1, flags, words, idx);
//        }
        if (idx == words.length) return true;
        if (board[r][c] != words[idx]) return false;
        flags[r][c] = true;
        var b = exist(board, r + 1, c, flags, words, idx + 1) ||
                exist(board, r - 1, c, flags, words, idx + 1) ||
                exist(board, r, c + 1, flags, words, idx + 1) ||
                exist(board, r, c - 1, flags, words, idx + 1);
        flags[r][c] = false;
        return b;
    }
}
