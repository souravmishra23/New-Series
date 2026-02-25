package arrays;

public class Points {
    public static void main(String[] args) {

        String[][] mat = {
                {"RD", "RD", "D"},
                {"D",  "D",  "D"},
                {"R",  "R",  "-"}
        };

        int ans = countBrokenConnections(mat);
        System.out.println(ans);
    }

    private static int countBrokenConnections(String[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        int count = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                // Check RIGHT connection
                if (mat[i][j].contains("R")) {
                    if (j + 1 >= cols || !mat[i][j + 1].contains("R")) {
                        count++;
                    }
                }

                // Check DOWN connection
                if (mat[i][j].contains("D")) {
                    if (i + 1 >= rows || !mat[i + 1][j].contains("D")) {
                        count++;
                    }
                }
            }
        }

        return count;
    }
}
