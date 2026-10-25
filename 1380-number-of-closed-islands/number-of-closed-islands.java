class Solution {
    public int closedIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] == 0) {
                    if (dfs(grid, i, j)) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    private boolean dfs(int[][] grid, int row, int col) {
        int m = grid.length;
        int n = grid[0].length;

        // If outside the grid, this island touches the boundary
        if (row < 0 || col < 0 || row >= m || col >= n) {
            return false;
        }

        // Water or an already visited cell
        if (grid[row][col] == 1) {
            return true;
        }

        // Mark land as visited
        grid[row][col] = 1;

        // Explore all four directions
        boolean up = dfs(grid, row - 1, col);
        boolean down = dfs(grid, row + 1, col);
        boolean left = dfs(grid, row, col - 1);
        boolean right = dfs(grid, row, col + 1);

        // The island is closed only if all directions remain closed
        return up && down && left && right;
    }
}