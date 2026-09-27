class Solution {
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
    int cols = board[0].length;

    boolean[][] visited = new boolean[rows][cols];

    for (int r = 0; r < rows; r++) {
        for (int c = 0; c < cols; c++) {

            if (dfs(board, word, r, c, 0, visited)) {
                return true;
            }
        }
    }

    return false;
    }

    private boolean dfs(char[][] board, String word,
                    int r, int c, int index,
                    boolean[][] visited) {

    // Entire word matched
    if (index == word.length()) {
        return true;
    }

    // Invalid position
    if (r < 0 || r >= board.length ||
        c < 0 || c >= board[0].length) {
        return false;
    }

    // Already used
    if (visited[r][c]) {
        return false;
    }

    // Character doesn't match
    if (board[r][c] != word.charAt(index)) {
        return false;
    }

    // Mark visited
    visited[r][c] = true;

    // Explore neighbors
    boolean found =
            dfs(board, word, r + 1, c, index + 1, visited) ||
            dfs(board, word, r - 1, c, index + 1, visited) ||
            dfs(board, word, r, c + 1, index + 1, visited) ||
            dfs(board, word, r, c - 1, index + 1, visited);

    // Backtrack
    visited[r][c] = false;

    return found;
}
}
