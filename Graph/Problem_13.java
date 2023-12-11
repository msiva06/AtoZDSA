package Graph;

import java.util.LinkedList;
import java.util.Queue;

// Matrix traps
public class Problem_13 {
    public static int matrixTraps(int n,int m, int [][]Matrix) {
       int[][] visited = new int[n][m];
       Queue<int[]> queue = new LinkedList<>();
       for(int i = 0; i < n; i++){
           if(Matrix[i][0] == 0 && visited[i][0] == 0){
               visited[i][0] = 1;
               queue.offer(new int[]{i,0});
           }
           if(Matrix[i][m-1] == 0 && visited[i][m-1] == 0){
               visited[i][m-1] = 1;
               queue.offer(new int[]{i,m-1});
           }
       }
       for(int j = 0; j < m;j++)
        {
            if(Matrix[0][j] == 0 && visited[0][j] == 0){
                    visited[0][j] = 1;
                    queue.offer(new int[]{0,j});
            }
            if(Matrix[n-1][j] == 0 && visited[n-1][j] == 0){
                visited[n-1][j] = 1;
                queue.offer(new int[]{n-1,j});
            }
        }       
        int traps = 0;
       while(!queue.isEmpty()){
           int[] popped = queue.poll();
           int r = popped[0];
           int c = popped[1];
           int[][] offset = {{0,1},{-1,0},{0,-1},{1,0}};
           for(int[] off : offset){
               int nrow = r + off[0];
               int ncol = c + off[1];
               if(nrow >= 0 && ncol >= 0 && nrow < Matrix.length && ncol < Matrix[0].length && 
               Matrix[nrow][ncol] == 0 && visited[nrow][ncol] == 0){
                   visited[nrow][ncol] = 1;
                   queue.offer(new int[]{nrow,ncol});
               }
           }
       }
       for(int i = 0; i < n; i++){
           for(int j = 0; j < m; j++){
               if(visited[i][j] == 0 && Matrix[i][j] == 0)
                traps++;
           }
       }
       return traps;
    }
}
