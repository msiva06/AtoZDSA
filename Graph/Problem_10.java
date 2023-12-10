package Graph;

import java.util.Arrays;
import java.util.List;

// Detect cycle in undirected graph(DFSß)
public class Problem_10 {
     boolean detectCycle(int V, List<List<Integer>> adj) {
            int[] visited = new int[V];
            int[] parent = new int[V];
            Arrays.fill(parent,-1);
            for(int i = 0; i < V; i++){
                if(visited[i] == 0){
                    if(isCycle(i,parent,adj,visited))
                        return true;
                }
            }
            return false;
        }

        boolean isCycle(int source,int[] parent,List<List<Integer>> adj,int[] visited){
            visited[source] = 1;

            List<Integer> adjL = adj.get(source);
            for(Integer a : adjL){
                if(visited[a] == 0){
                    parent[a] = source;
                    if(isCycle(a,parent,adj,visited))
                        return true;
                }
                else if(a != parent[source]){
                    return true;
                }
            }
            return false;
        }
}
