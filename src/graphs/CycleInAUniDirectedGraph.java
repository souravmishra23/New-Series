package graphs;

import java.util.List;

public class CycleInAUniDirectedGraph {
    

    public static String dfs(int node, int parent, int[] vis, List<List<Integer>> adj) {

        vis[node] = 1;

        for (Integer nbr: adj.get(node)) {
            if (vis[nbr] == 0) {
                if (dfs(nbr, node, vis, adj) == "Yes") {
                    return "Yes";
                }
            } else if (node != parent) {
                return "Yes";
            }
        }

        return "No";
    }


}
