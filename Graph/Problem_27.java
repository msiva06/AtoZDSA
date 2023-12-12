package Graph;

import java.util.Arrays;

class DSU{
        int[] parent;
        int[] rank;
        public DSU(int n){
            parent = new int[n];
            rank = new int[n];
            for(int i = 0; i < n ;i++){
                parent[i] = i;
            }
        }
    
        public  int findParent(int u){
            if(parent[u] == u)
                return u;
            return parent[u] = findParent(parent[u]);
        }
    
        public  void union(int u,int v){
            int parU = findParent(u);
            int parV = findParent(v);
            if(parU == parV)
                return;
            if(rank[parU] < rank[parV])
            {
                parent[parU] = parV;
            }
            else if(rank[parV] < rank[parU]){
                parent[parV] = parU;
            }
            else{
                parent[parV] = parU;
                rank[parU]++;
            }
        }
    }
// Kruskal's algorithm(MST)
public class Problem_27 {
    public static int kruskalMST(int n,int [][]edges) {
        Arrays.sort(edges,(a,b) -> a[2]-b[2]);
        DSU d = new DSU(n+1);
        int sum = 0;
        for(int i = 0; i < edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];
            int parU = d.findParent(u);
            int parV = d.findParent(v);
            if(parU == parV)
                continue;
            sum += wt;
            d.union(u,v);
        }
        return sum;
    }
}
