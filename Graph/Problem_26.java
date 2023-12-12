package Graph;

import java.util.ArrayList;
import java.util.PriorityQueue;

// Prim's Algorithm
public class Problem_26 {
    public static ArrayList<ArrayList<Integer>> calculatePrimsMST(int n, int m, ArrayList<ArrayList<Integer>> g)
    {
        int[] visited = new int[n+1];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Pair>[] adjL = new ArrayList[n+1];
        for(int i = 0; i <= n; i++){
            adjL[i] = new ArrayList<>();
        }
        for(int i = 0; i < m; i++){
            int src = g.get(i).get(0);
            int dest = g.get(i).get(1);
            int wt = g.get(i).get(2);
            adjL[src].add(new Pair(dest,wt));
            adjL[dest].add(new Pair(src,wt));
        }
        pq.offer(new int[]{0,1,-1});
        while(!pq.isEmpty()){
            int[] popped = pq.poll();
            int wt = popped[0];
            int node = popped[1];
            int parent = popped[2];
            if(visited[node] == 1)
                continue;
            if(parent != -1){
                ArrayList<Integer> sub = new ArrayList<>();
                sub.add(parent);
                sub.add(node);
                sub.add(wt);
                res.add(new ArrayList<>(sub));
            }
            visited[node] = 1;
            ArrayList<Pair> adj = adjL[node];
            for(Pair p : adj){
                if(visited[p.node] == 0){
                    pq.offer(new int[]{p.weight,p.node,node});
                }
            }
        }
        return res;
    }
}
