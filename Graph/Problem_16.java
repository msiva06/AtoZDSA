package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// Topological sort using BFS
public class Problem_16 {
    public static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> edges, int v, int e) 
    {
        ArrayList<Integer> topo = new ArrayList<>();
        int[] inDegree = new int[v];
        ArrayList[] adj = new ArrayList[v];
        for(int i = 0 ; i < v; i++){
            adj[i] = new ArrayList<>();
        }
        for(int i  = 0; i  < e; i++){
            int src =  edges.get(i).get(0);
            int dest = edges.get(i).get(1);
            adj[src].add(dest);
            inDegree[dest] +=1;
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < v; i++){
            if(inDegree[i] == 0)
                queue.offer(i);
        }
        while(!queue.isEmpty()){
            int node = queue.poll();
            topo.add(node);
            ArrayList<Integer> ad = adj[node];
            for(Integer a : ad){
                if(inDegree[a] > 0)
                    inDegree[a] -= 1;
                if(inDegree[a] == 0){
                    queue.offer(a);
                }
            }
        }
        return topo;
    }
}
