package Graph;

import java.util.LinkedList;
import java.util.Queue;

// Rotting oranges
public class Problem_07 {
    public static int minTimeToRot(int[][] grid, int n, int m) {
		int[][] visited = new int[n][m];
		Queue<int[]> queue = new LinkedList<>();
		int cntFresh = 0;
		for(int i = 0; i < n; i++){
			for(int j = 0; j < m; j++){
				if(grid[i][j] == 2){
					visited[i][j] = 2;
					queue.offer(new int[]{i,j,0});
				}
				if(grid[i][j] == 1)
					cntFresh++;
			}
		}
		int cnt = 0;
		int minTime = 0;
		while(!queue.isEmpty()){
				int[] rot = queue.poll();
				int r = rot[0];
				int c = rot[1];
				int time = rot[2];
				minTime = Math.max(minTime,time);
				int[][] offset = {{0,1},{0,-1},{-1,0},{1,0}};
				for(int[] off :offset){
					int nrow = r + off[0];
					int ncol = c + off[1];
					
					if(nrow >= 0 && nrow < grid.length && ncol >= 0 && ncol < grid[0].length &&
						grid[nrow][ncol] == 1 && visited[nrow][ncol] == 0){
							visited[nrow][ncol] = 2;
							cnt++;
							queue.offer(new int[]{nrow,ncol,time+1});
					}
				}
		}
		return cnt == cntFresh ? minTime : -1;

	}
}
