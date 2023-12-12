package Graph;

import java.util.Arrays;
import java.util.List;

// Bellman Ford Algorithm
public class Problem_24 {
    public static int[] bellmonFord(int n, int m, int src, List<List<Integer>> edges) {
        int[] dist = new int[n+1];
        Arrays.fill(dist,100000000);
        dist[src] = 0;
        for(int v1 = 1; v1 < n; v1++){
            for(int i = 0; i < m; i++){
                int u = edges.get(i).get(0);
                int v = edges.get(i).get(1);
                int wt = edges.get(i).get(2);
                if(dist[u] != 1000000000 && (dist[u] + wt) < dist[v])
                    dist[v] = dist[u] + wt;
            }
        }

        // negative cycle check
        // for(int i = 0; i < edges.size(); i++){
        //         int u = edges.get(i).get(0);
        //         int v = edges.get(i).get(1);
        //         int wt = edges.get(i).get(2);
        //         if(dist[u] != 1000000000 && dist[u] + wt < dist[v]){
        //             int[] temp = new int[1];
        //             temp[0] = -1;
        //             return temp;
        //         }

        // }
        return dist;

    
    }
}
