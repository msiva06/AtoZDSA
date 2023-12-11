package Graph;

import java.util.ArrayList;

// Detect cycle in directed graph(DFS)
public class Problem_14 {
    public static boolean detectCycleInDirectedGraph(int n, ArrayList < ArrayList < Integer >> edges) {
     int[] visited = new int[n+1];
     int[] path = new int[n+1];
     ArrayList<Integer> adjL[] = new ArrayList[n];
     for(int i = 0; i < n; i++){
       adjL[i] = new ArrayList<>();
     }
     for(int i = 0; i < edges.size();i++){
       int src = edges.get(i).get(0);
       int dest = edges.get(i).get(1);
       adjL[src-1].add(dest);
     }
     
     for(int i = 1; i <=n ;i++){
       if(visited[i] == 0){
         if(checkCycle(i,path,visited,adjL))
          return true;
       }
     }
     return false;
  }

  public static boolean checkCycle(int node,int[] path,int[] visited,ArrayList<Integer>[] adjL){
    visited[node] = 1;
    path[node] = 1;
    ArrayList<Integer> ad = adjL[node-1];
    for(Integer a : ad){
      if(visited[a] == 0){
        if(checkCycle(a,path,visited,adjL))
          return true;
      }
      else if(path[a] == 1){
        return true;
      }
    }
    path[node] = 0;
    return false;
  }
}
