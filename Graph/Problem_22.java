package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

// Strongly connected components(Kosaraju's algorithm)
public class Problem_22 {
    public static List<List<Integer>> stronglyConnectedComponents(int n, int[][] edges) {
        List<Integer>[] adjL = new ArrayList[n];
        for(int i = 0; i < n; i++){
            adjL[i] = new ArrayList<>();
        }
        int[] visited = new int[n];
        for(int i =0; i < edges.length; i++){
            int src = edges[i][0];
            int dest = edges[i][1];
            adjL[src].add(dest);
        }

        Stack<Integer> topoSort = new Stack<Integer>();
        for(int i = 0; i < n; i++){
            if(visited[i] == 0){
                dfs(i,topoSort,visited,adjL);
            }
        }

        List<Integer>[] revAdjL = new ArrayList[n];
        for(int i = 0; i < n; i++){
            revAdjL[i] = new ArrayList<>();
        }
        for(int i = 0; i < edges.length; i++){
            int src = edges[i][0];
            int dest = edges[i][1];
            revAdjL[dest].add(src);
        }
        Arrays.fill(visited,0);
        List<List<Integer>> res = new ArrayList<>();
        while(!topoSort.isEmpty()){
            int node = topoSort.pop();
            if(visited[node] == 0){
                List<Integer> sub = new ArrayList<>();
                revdfs(node,sub,visited,revAdjL);
                res.add(new ArrayList<>(sub));
            }
        }
        return res;

    }

    public static void revdfs(int node,List<Integer> sub,int[] visited,List<Integer>[] revAdjL){
        visited[node] = 1;
        sub.add(node);
        List<Integer> adj = revAdjL[node];
        for(Integer a : adj){
            if(visited[a] == 0){
                revdfs(a,sub,visited,revAdjL);
            }
        }
    }

    public static void dfs(int src,Stack<Integer> st, int[] visited,List<Integer>[] adjL){
        visited[src] = 1;
        List<Integer> ad = adjL[src];
        for(Integer a : ad){
            if(visited[a] == 0){
                dfs(a,st,visited,adjL);
            }
        }
        st.push(src);
    }
}
