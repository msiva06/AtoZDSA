package Graph;

import java.util.ArrayList;

// Topological sort using DFS
public class Problem_17 {
    public static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> edges, int v, int e) 
    {
        ArrayList<Integer> topo = new ArrayList<>();
        int[] inDegree = new int[v];
        int[] visited = new int[v];
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

        for(int i = 0; i < v; i++){
            if(inDegree[i] == 0 && visited[i] == 0){
                dfs(topo,i,visited,inDegree,adj);
            }
        }
        return topo;
    }

    public static void dfs(ArrayList<Integer> topo,int node,int[] visited,int[] inDegree,ArrayList[] adj){
        visited[node] = 1;
        topo.add(node);
        ArrayList<Integer> ad = adj[node];
        for(Integer a : ad){
            if(visited[a] == 0){
                if(inDegree[a] > 0){
                    inDegree[a] -= 1;
                    if(inDegree[a] == 0){
                        dfs(topo,a,visited,inDegree,adj);
                    }
                }
            }   
        }
    }
}
