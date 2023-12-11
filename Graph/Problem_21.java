package Graph;

import java.util.ArrayList;
import java.util.Arrays;

// Bipartite graph using DFS
public class Problem_21 {
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

        for(int i = 0; i < n; i++){
            if(color[i] == -1){
                if(dfs(i,0,color,adjL) == false)
                    return false;
            }
        }
        return true;
    }

    public static boolean dfs(int node,int col,int[] color,ArrayList[] adjL){
        color[node] = col;
        ArrayList<Integer> ad = adjL[node];
        for(Integer a : ad){
            if(color[a] == -1){
                color[a] = color[node] == 0 ? 1 : 0;
                if(dfs(a,color[a],color,adjL) == false)
                    return false;
            }
            else if(color[a] == color[node])
                return false;
        }
        return true;
    }
}
