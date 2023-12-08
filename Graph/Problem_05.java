package Graph;

import java.util.ArrayList;
import java.util.List;

// DFS
public class Problem_05 {
    public static ArrayList<ArrayList<Integer>> depthFirstSearch(int v, int e, ArrayList<ArrayList<Integer>> edges) {
        int[] visited = new int[v];
        List<Integer>[] graph = new ArrayList[v];
        for(int i = 0; i < v; i++)
            graph[i] = new ArrayList<>();
        
        for(int i = 0; i < edges.size(); i++){
            graph[edges.get(i).get(0)].add(edges.get(i).get(1));
            graph[edges.get(i).get(1)].add(edges.get(i).get(0));
        }
        ArrayList<ArrayList<Integer>> finalRes = new ArrayList<>();
        for(int i = 0; i < v; i++){
            if(visited[i] == 0){
                ArrayList<Integer> res = new ArrayList<>();
                dfs(i,res,graph,visited);
                finalRes.add(new ArrayList<>(res));
            }
        }
        return finalRes;
    }

    public static void dfs(int node,ArrayList<Integer> res,List<Integer>[] graph,int[] visited){
        visited[node] = 1;
        res.add(node);
        List<Integer> adjL = graph[node];
        for(Integer a : adjL){
            if(visited[a] == 0){
                dfs(a,res,graph,visited);
            }
        }
    }
}
