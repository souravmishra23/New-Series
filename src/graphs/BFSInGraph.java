package graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFSInGraph {
    public static void main(String[] args) {
        System.out.println();
    }

    public static List<Integer> bfsTraversal(int n, List<List<Integer>> adj){
        List<Integer> bfs = new ArrayList<>();

        boolean [] vis = new boolean[adj.size()];

        Queue<Integer> queue = new LinkedList<>();

        queue.offer(0);
        vis[0] = true;
        bfs.add(0);

        while (!queue.isEmpty()) {
            Integer node = queue.poll();

            for (Integer nbrs: adj.get(node)) {
                if (!vis[nbrs]) {
                    vis[nbrs] = true;
                    queue.offer(nbrs);
                    bfs.add(nbrs);
                }
            }
        }

        return bfs;
    }
}
