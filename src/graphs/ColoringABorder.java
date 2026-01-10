package graphs;

public class ColoringABorder {
    public int[][] colorBorder(int[][] grid, int r0, int c0, int color) {

        int m = grid.length;
        int n = grid[0].length;

        if (grid[r0][c0] == color) {
            return grid;
        }


        boolean [][] vis = new boolean[m][n]; 

        dfs(grid, r0, c0, vis, grid[r0][c0], color, m, n);

        return grid;
    }

    public void dfs(int[][] grid, int row, int col, boolean [][] vis, int color, int targetCol, int m, int n) {
        if (row < 0 || row >= m || col < 0 || col >= n || grid[row][col] != color || vis[row][col]) {
            return;
        }

        vis[row][col] = true;

        boolean border = false;

        if (row == 0 || row == m - 1 || col == 0 || col == n - 1 || grid[row + 1][col] != color || grid[row - 1][col] != color
            || grid[row][col + 1] != color || grid[row][col - 1] != color) {
                border = true;
        }

        dfs(grid, row + 1, col, vis, color, targetCol, m, n);
        dfs(grid, row - 1, col, vis, color, targetCol, m, n);
        dfs(grid, row, col + 1, vis, color, targetCol, m, n);
        dfs(grid, row, col - 1, vis, color, targetCol, m, n);

        if (border) {
            grid[row][col] = targetCol;
        }
    }
}
