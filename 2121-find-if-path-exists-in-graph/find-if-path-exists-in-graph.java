import java.util.*;
class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        return bfs(source, destination,graph);

    }
    public boolean bfs(int src,int dest,List<List<Integer>> adj){
        boolean []visited = new boolean[adj.size()];
        visited[src] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);
        while(!queue.isEmpty()){
            int node = queue.poll();
            if(node == dest){
                return true;
            }
            for(int neigh: adj.get(node)){
                if(!visited[neigh]){
                    visited[neigh] = true;
                    queue.add(neigh);
                }
            }
        }
        return false;
    }
    // public boolean dfs(int src,int dest,boolean []visited,List<List<Integer>> adj){
    //     if(src == dest){
    //         return true;
    //     }
    //     visited[src]= true;
    //     for(int neigh : adj.get(src)){
    //         if(!visited[neigh]){
    //             if (dfs(neigh, dest, visited,adj)) {
    //                 return true;
    //             }
    //         }
    //     }
    //     return false;
    // }
}