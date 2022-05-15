package me.victor.code;

/**
 * Created by victor on 2022/5/15. (ง •̀_•́)ง
 */
class T36_ValidSudoku {

    public static void main(String[] args) {
        var t = new T36_ValidSudoku();
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


        System.out.println(t.isValidSudoku(chs));
    }

    public boolean isValidSudoku(char[][] board) {
        var row = new boolean[9][9];
        var col = new boolean[9][9];
        var box = new boolean[9][9];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '.') continue;
                var idx = board[i][j] - '0' - 1;
                if (row[i][idx] || col[j][idx] || box[i / 3 * 3 + j / 3][idx]) return false;
                row[i][idx] = col[j][idx] = box[i / 3 * 3 + j / 3][idx] = true;
            }
        }
        return true;
    }

    public boolean isValidSudoku2(char[][] board) {
        for (char[] chars : board) {
            if (!valid(new String(chars))) return false;
        }
        for (int i = 0; i < board.length; i++) {
            var sb = new StringBuilder();
            for (char[] chars : board) sb.append(chars[i]);
            if (!valid(sb.toString())) return false;
        }
        for (int i = 0; i < board.length / 3; i++) {
            for (int j = 0; j < board.length; j += 3) {
                var sb = new StringBuilder();
                sb.append(board[3 * i], j, 3);
                sb.append(board[3 * i + 1], j, 3);
                sb.append(board[3 * i + 2], j, 3);
                if (!valid(sb.toString())) return false;
            }
        }
        return true;
    }

    private boolean valid(String str) {
        var flag = 0;
        for (char ch : str.toCharArray()) {
            if (ch == '.') continue;
            var shl = 1 << (ch - '0');
            if ((flag & shl) != 0) return false;
            flag |= shl;
        }
        return true;
    }
}
