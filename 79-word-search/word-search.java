class Solution {

    public boolean exist(char[][] board, String word) {

        int rows = board.length;
        int cols = board[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (board[i][j] == word.charAt(0)) {
                    if (helper(board, word, i, j, 0)) {
                        return true;
                    }
                }

            }
        }

        return false;
    }

    public boolean helper(char[][] board, String word,
                          int row, int col, int index) {

        // All characters matched
        if (index == word.length()) {
            return true;
        }

        // Out of bounds
        if (row < 0 || row >= board.length ||
            col < 0 || col >= board[0].length) {
            return false;
        }

        // Character mismatch
        if (board[row][col] != word.charAt(index)) {
            return false;
        }

        // Mark as visited
        char temp = board[row][col];
        board[row][col] = '#';

        boolean found =
                helper(board, word, row + 1, col, index + 1) ||
                helper(board, word, row - 1, col, index + 1) ||
                helper(board, word, row, col + 1, index + 1) ||
                helper(board, word, row, col - 1, index + 1);

        // Backtrack
        board[row][col] = temp;

        return found;
    }
}