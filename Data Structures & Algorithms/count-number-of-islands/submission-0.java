class Solution {
   public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int islands = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {

                if (grid[r][c] == '1') {
                    islands++;

                    // Visit the entire island
                    dfs(grid, r, c);
                }
            }
        }

        return islands;
    }

    private void dfs(char[][] grid, int r, int c) {
        // Boundary check
        if (r < 0 || r >= grid.length ||
            c < 0 || c >= grid[0].length ||
            grid[r][c] != '1') {
            return;
        }

        // Mark as visited
        grid[r][c] = '0';

        // Up
        dfs(grid, r - 1, c);

        // Down
        dfs(grid, r + 1, c);

        // Left
        dfs(grid, r, c - 1);

        // Right
        dfs(grid, r, c + 1);
    }
}
