package dp.grid;

import java.util.List;

public class Triangle {
    public static void main(String [] args) {

    }


    public static int minimumTotal(List<List<Integer>> triangle) {
        Integer [][] dp = new Integer[triangle.size()][triangle.size()];
        return 0;
    }

    public static int rec(int i, int j, List<List<Integer>> triangle) {
        if (i == triangle.size() - 1) {
            return triangle.get(i).get(j);
        }


        int right = rec(i + 1, j, triangle);
        int down = rec(i + 1, j + 1, triangle);

        return Math.min(right, down) + triangle.get(i).get(j);
    }




    public static int memo(int i, int j, List<List<Integer>> triangle, Integer [][] dp) {
        if (i == triangle.size() - 1) {
            return triangle.get(i).get(j);
        }

        if (dp[i][j] != null) {
            return dp[i][j];
        }

        int right = memo(i + 1, j, triangle, dp);
        int down = memo(i + 1, j + 1, triangle, dp);

        return dp[i][j] = Math.min(right, down) + triangle.get(i).get(j);
    }
}
