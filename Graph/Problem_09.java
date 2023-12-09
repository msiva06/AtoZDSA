package Graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Detect cycle in undirected graph(BFS)
public class Problem_09 {
    boolean detectCycle(int V, List<List<Integer>> adj) {
           int[] parent = new int[V];
           Arrays.fill(parent,-1);
           int[] visited = new int[V];
           for(int i = 0; i < V; i++){
               if(visited[i] == 0){
                   if(isCycle(i,visited,parent,adj))
                    return true;
               }
               
           }
           return false;
        }

        boolean isCycle(int source,int[] visited,int[] parent,List<List<Integer>> adj){
            Queue<int[]> queue = new LinkedList<>();
            queue.offer(new int[]{source,-1});
            while(!queue.isEmpty()){
                int[] popped = queue.poll();
                int src = popped[0];
                int par = popped[1];
                if(visited[src] == 1)
                    return true;
                visited[src] = 1;
                List<Integer> adjL = adj.get(src);
                for(Integer a : adjL){
                    if(visited[a] == 0)
                    {
                        queue.offer(new int[]{a,src});
                        parent[a] = src;
                    }
                    else if(a != par)
                        return true;
                }
            }
            return false;
        }
}
