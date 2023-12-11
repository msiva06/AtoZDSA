package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// Detect cycle in directed graph(BFS,Topo with Kahn's Algo)
public class Problem_15 {
    public static boolean detectCycleInDirectedGraph(int n, ArrayList < ArrayList < Integer >> edges) {
     int[] inDegree = new int[n+1];

     ArrayList<Integer> adjL[] = new ArrayList[n];
     for(int i = 0; i < n; i++){
       adjL[i] = new ArrayList<>();
     }
     for(int i = 0; i < edges.size();i++){
       int src = edges.get(i).get(0);
       int dest = edges.get(i).get(1);
       adjL[src-1].add(dest);
       inDegree[dest] += 1;
     }

     Queue<Integer> queue = new LinkedList<>();
     for(int i  = 1; i < inDegree.length;i++){
       if(inDegree[i] == 0)
        queue.offer(i);
     }
     
     int cnt = 0;
     while(!queue.isEmpty()){
       int node = queue.poll();
       cnt++;
       ArrayList<Integer> ad = adjL[node-1];
       for(Integer a : ad){
         inDegree[a] -= 1;
         if(inDegree[a] == 0)
          queue.offer(a);
       }
     }
     if(cnt == n)
        return false;
     return true;
  }
}
