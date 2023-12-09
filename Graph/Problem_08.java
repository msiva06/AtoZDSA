package Graph;

import java.util.LinkedList;
import java.util.Queue;

// Flood fill
public class Problem_08 {
    public static int[][] floodFill(int[][] image, int n, int m, int x, int y, int p) {
            int[][] visited = new int[n][m];
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    visited[i][j] = image[i][j];
                }
            }
            Queue<int[]> queue = new LinkedList<>();
            int original = image[x][y];
            queue.offer(new int[]{x,y});
            while(!queue.isEmpty()){
                int[] point = queue.poll();
                int r = point[0];
                int c = point[1];
                visited[r][c] = p;
                int[][] offset = {{0,1},{0,-1},{-1,0},{1,0}};
                for(int[] off:offset){
                    int nrow = r + off[0];
                    int ncol = c + off[1];
                    if(nrow >= 0 && ncol >= 0 && nrow < image.length && ncol < image[0].length
                    && image[nrow][ncol] == original && visited[nrow][ncol] != p){
                        queue.offer(new int[]{nrow,ncol});
                    }
                }
            }
            return visited;

        }
}
