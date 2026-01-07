package graphs;

public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image == null || image.length == 0 || image[sr][sc] == color) {
            return image;
        }
        int given = image[sr][sc];
        dfs(image, given, sr, sc, color);
        return image;
    }

    void dfs(int[][] image, int given, int sr, int sc, int color) {
        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length) {
            return;
        }

        if (image[sr][sc] != given) {
            return;
        }

        image[sr][sc] = color;

        dfs(image, given, sr - 1, sc, color);
        dfs(image, given, sr + 1, sc, color);
        dfs(image, given, sr, sc - 1, color);
        dfs(image, given, sr, sc + 1, color);
    }
}
