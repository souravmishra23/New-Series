package dp.minmax;

import java.util.Arrays;

public class FindMinPathInGrid {

    public static void main(String[] args) {
        int[][] grid = {
                {1, 2, 3},
                {4, 8, 2},
                {1, 5, 3}
        };
        boolean[][] visited = new boolean[grid.length][grid.length];
        System.out.println(minPathBrute(grid, 0, 0, visited));

        int[][] memo = new int[grid.length][grid.length];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        System.out.println(minPathMemo(grid, 0, 0, memo));

    }

   // int [][] dir = new int[][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    // TC exponential
    public static int minPathBrute(int [][] grid, int x, int y, boolean[][] visited) {
        if ((x == grid.length - 1 && y == grid.length - 1) ) {
            return grid[grid.length - 1][grid.length - 1];
        }
        if (x < 0 || x > grid.length - 1 || y < 0 || y > grid.length - 1 || visited[x][y]) {
            return Integer.MAX_VALUE;
        }
        visited[x][y] = true;
        int right = minPathBrute(grid, x, y + 1, visited);
        int down = minPathBrute(grid, x + 1, y, visited);
//        int left = minPathBrute(grid, x, y - 1, visited);
//        int up = minPathBrute(grid, x - 1, y, visited);
        // Unmark for other paths (backtracking)
        visited[x][y] = false;

        // Find minimum of all directions
        //int min = Math.min(Math.min(right, down), Math.min(left, up));
        int min = (Math.min(right, down));

        return grid[x][y] + (min == Integer.MAX_VALUE ? 0 : min);
    }
    // TC O(n2)
    public static int minPathMemo(int[][] grid, int x, int y, int[][] memo) {
        int n = grid.length;

        // Out of bounds
        if (x < 0 || x >= n || y < 0 || y >= n) {
            return Integer.MAX_VALUE;
        }

        // If destination is reached
        if (x == n - 1 && y == n - 1) {
            return grid[x][y];
        }

        // If result already computed
        if (memo[x][y] != -1) {
            return memo[x][y];
        }

        // Recursive calls: only right and down if no backtracking is allowed
        int right = minPathMemo(grid, x, y + 1, memo);
        int down = minPathMemo(grid, x + 1, y, memo);

        // If moving in 4 directions, also include:
        // int left = minPathMemo(grid, x, y - 1, memo);
        // int up = minPathMemo(grid, x - 1, y, memo);
        // and add visited[][] to prevent cycles

        int min = Math.min(right, down);

        memo[x][y] = grid[x][y] + (min == Integer.MAX_VALUE ? 0 : min);
        return memo[x][y];
    }

}
