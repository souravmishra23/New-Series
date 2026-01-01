package graphs;

import java.util.ArrayList;
import java.util.List;

public class DFSInGraph {

    public static ArrayList<ArrayList<Integer>> depthFirstSearch(int v, int e, ArrayList<ArrayList<Integer>> edges) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();


        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }

        for (ArrayList<Integer> edge: edges) {
            int U = edge.get(0);
            int V = edge.get(1);
            adj.get(U).add(V);
            adj.get(V).add(U);
        }

        boolean [] visited = new boolean[v];

        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                ArrayList<Integer> dfs = new ArrayList<>();
                dfs(adj, dfs, i, visited);
                ans.add(dfs);
            }
        }

        return ans;
    }

    public static void dfs(List<List<Integer>> adj, ArrayList<Integer> dfs, Integer v, boolean [] vis) {
        vis[v] = true;
        dfs.add(v);
        for (Integer nbr: adj.get(v)) {
            if (!vis[nbr])
                dfs(adj, dfs, nbr, vis);
        }
    }
}
