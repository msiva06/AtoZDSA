package Graph;

import java.util.ArrayList;
import java.util.List;

// Number of Connected components in an undirected graph
public class Problem_03 {
    public int countComponents(int n, int[][] edges) {
        List<Integer>[] graph = new ArrayList[n];
        for(int i = 0; i < n;i++)
            graph[i] = new ArrayList<>();
        for(int i = 0; i < edges.length; i++){
            graph[edges[i][0]].add(edges[i][1]);
            graph[edges[i][1]].add(edges[i][0]);
        }
        int[] visited = new int[n];
        int count = 0;
        for(int i = 0; i < n; i++){
            if(visited[i] == 0){
                count++;
                dfs(visited,i,graph);
            }
        }
        return count;
    }

    public static void dfs(int[] visited,int node,List<Integer>[] graph){
        visited[node] = 1;
        List<Integer> adjList = graph[node];
        for(Integer n : adjList){
            if(visited[n] == 0)
                dfs(visited,n,graph);
        }
    }
}
