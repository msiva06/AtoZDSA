package Graph;

import java.util.ArrayList;
import java.util.HashSet;

// Distinct Islands
public class Problem_19 {
    public static int distinctIsland(int [][] arr, int n, int m) 
	{
		int[][] visited = new int[n][m];
		HashSet<ArrayList<String>> uniq = new HashSet<>();
		for(int i = 0; i < n; i++){
			for(int j = 0;  j < m; j++){
				if(visited[i][j] == 0 && arr[i][j] == 1)
				{
					ArrayList<String> uList = new ArrayList<>();
					dfs(i,j,visited,arr,uList,i,j);
					uList.stream().forEach(System.out::println);
					uniq.add(uList);
				}
			}
		}
		return uniq.size();
	}

	public static void dfs(int row,int col, int[][] visited,int[][] arr,ArrayList<String> uList,int row0,int col0){
		visited[row][col] = 1;
		int drow = row - row0;
		int dcol = col - col0;
		uList.add(drow + "" + dcol);
		int[][] offset = {{0,1},{0,-1},{-1,0},{1,0}};
		for(int[] off : offset)
		{
			int nrow = row + off[0];
			int ncol = col + off[1];
			if(nrow >= 0 && ncol >= 0 && nrow < arr.length && ncol < arr[0].length && visited[nrow][ncol] == 0 && arr[nrow][ncol] == 1)
				dfs(nrow,ncol,visited,arr,uList,row0,col0);
		}
	}
}
