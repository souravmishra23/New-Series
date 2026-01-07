package graphs;

import java.util.ArrayList;
import java.util.List;

public class CourseSchedule {
    
    public static void main(String [] args) {
        
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }


        for (int i = 0; i < prerequisites.length; i++) {
            int u = prerequisites[i][0];
            int v = prerequisites[i][1];

            adj.get(u).add(v);
        }

        int[] vis = new int[numCourses];
        int[] path_vis = new int[numCourses];

        for(int i = 0; i < numCourses; i++){
            if(vis[i] == 0){
                if(dfs(adj, i, vis, path_vis) == true) return false;
            }
        }
        return true;
    }

    public boolean dfs(List<List<Integer>> adj, int node, int[] vis, int[] path_vis) {
        vis[node] = 1;
        path_vis[node] = 1;

        for (Integer it: adj.get(node)) {
            if (vis[node] == 0) {
                if (dfs(adj, it, vis, path_vis)) return true;
            } else if (path_vis[node] == 1) {
                return true;
            }
        }

        path_vis[node] = 0;
        return false;
    }


}
