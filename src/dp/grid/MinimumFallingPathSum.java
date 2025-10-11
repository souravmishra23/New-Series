package dp.grid;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinimumFallingPathSum {
    public static void main(String[] args) {
         int[][] matrix = {
            {2,1,3},
            {6,5,4},
            {7,8,9}
        };

        System.out.println(minFallingPathSum(matrix));
    }

    public static int minFallingPathSum(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();

        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = 1; i < n; i++) {
            ans.add(rec(m, n, 0, i, matrix));
        }

        System.out.println(ans);

        return Collections.min(ans);
    }

    public static int rec(int m, int n, int row, int col, int[][] matrix) {
        if (row < 0 || col < 0 || row >= m || col >= n) {
            return Integer.MAX_VALUE;
        }

        if (row == m - 1) {
            return matrix[row][col];
        }

        int a = rec(m, n, row + 1, col - 1, matrix);
        int b = rec(m, n, row + 1, col, matrix);
        int c = rec(m, n, row + 1, col + 1, matrix);
        return Math.min(a, Math.min(b, c)) + matrix[row][col];
    }



     public static int memo(int m, int n, int row, int col, int[][] matrix, Integer [][] dp) {
        if (row < 0 || col < 0 || row >= m || col >= n) {
            return Integer.MAX_VALUE;
        }

        if (row == m - 1) {
            return matrix[row][col];
        }

        if (dp[row][col] != null) {
            return dp[row][col];
        }

        int a = memo(m, n, row + 1, col - 1, matrix, dp);
        int b = memo(m, n, row + 1, col, matrix, dp);
        int c = memo(m, n, row + 1, col + 1, matrix, dp);
        return dp[row][col] = Math.min(a, Math.min(b, c)) + matrix[row][col];
    }
}
