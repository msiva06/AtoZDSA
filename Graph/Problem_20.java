package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// Bipartite graph using BFS
public class Problem_20 {
    public static boolean isGraphBirpatite(ArrayList<ArrayList<Integer>> edges) {
        int n = edges.size();
        int[] color = new int[n];
        Arrays.fill(color,-1);

        ArrayList[] adjL = new ArrayList[n];
        for(int i = 0; i < n; i++){
            adjL[i] = new ArrayList<>();
        }
        for(int i= 0; i < edges.size(); i++){
            for(int j = 0; j < edges.get(i).size();j++){
                if(edges.get(i).get(j) == 1){
                    adjL[i].add(j);
                }
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        color[0] = 0;
        while(!queue.isEmpty()){
            int node = queue.poll();
            ArrayList<Integer> ad = adjL[node];
            for(Integer a : ad){
                if(color[a] == -1){
                    color[a] = color[node] == 0 ? 1:0;
                    queue.offer(a);
                }
                else if(color[a] == color[node])
                    return false;
            }
        }
        return true;
    }
}
