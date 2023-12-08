package Graph;

import java.util.ArrayList;
import java.util.List;

// Find the number of provinces
public class Problem_06 {
    public static int findNumOfProvinces(int[][] roads, int n) {
        int[] visited = new int[n];
        List<Integer>[] graph = new ArrayList[n];
        for(int i = 0; i < n; i++)
            graph[i] = new ArrayList<>();
        for(int i = 0; i < roads.length; i++){
            for(int j = 0; j < roads[i].length; j++){
                if(roads[i][j] == 1){
                    graph[i].add(j);
                    graph[j].add(i);
                }
            }
           
        }
        int provinces = 0;
        for(int i = 0; i < n; i++){
            if(visited[i] == 0){
                provinces++;
                dfs(i,graph,visited);
            }
        }
        return provinces;
    }

    public static void dfs(int node, List<Integer>[] graph, int[] visited){
        visited[node] = 1;
        List<Integer> adjL = graph[node];
        for(Integer a : adjL){
            if(visited[a] == 0)
                dfs(a,graph,visited);
        }
    }
}
