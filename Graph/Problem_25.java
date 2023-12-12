package Graph;

import java.util.ArrayList;

// Floyd Warshall algorithm
public class Problem_25 {
    static int floydWarshall(int n, int m, int src, int dest, ArrayList<ArrayList<Integer>> edges) {
    int[][] cost = new int[n+1][n+1];
    for(int i = 1; i <= n; i++){
      for(int j = 1; j <= n; j++){
        if(i == j)
          cost[i][j] = 0;
        else
          cost[i][j] = 1000000000;
      }
    }

    for(int i = 0; i < m; i++){
      int u = edges.get(i).get(0);
      int v = edges.get(i).get(1);
      int wt = edges.get(i).get(2);
      cost[u][v] = wt;
    }

    for(int k = 1; k <= n; k++){
      for(int i = 1; i <= n; i++){
        for(int j = 1; j <= n; j++){
          if(cost[i][k] != 1000000000 && cost[k][j] != 1000000000)
            cost[i][j] = Math.min(cost[i][j],cost[i][k] + cost[k][j]);
        }
      }
    }
    return cost[src][dest];
    
  }
}
