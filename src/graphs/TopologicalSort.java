package graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TopologicalSort {
    public static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> edges, int v, int e) {
        ArrayList<Integer> ans = new ArrayList<>();

         List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }

        for (ArrayList<Integer> edge: edges) {
            int U = edge.get(0);
            int V = edge.get(1);
            adj.get(U).add(V);
        }

        boolean [] vis = new boolean[v];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < v; i++) {
            if (!vis[i]) {
                dfs(adj, st, i, vis);
            }
        }

        while (!st.isEmpty()) {
            ans.add(st.pop());
        }

        return ans;

    }

    private static void dfs(List<List<Integer>> adj, Stack<Integer> st, int i, boolean[] vis) {
      vis[i] = true;

      for (Integer nbr: adj.get(i)) {
        if (!vis[nbr]) {
            vis[nbr] = true;
            dfs(adj, st, nbr, vis);
        }
      }

      st.push(i);
    }

}
