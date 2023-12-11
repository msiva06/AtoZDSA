package Graph;

// Number of Islands
public class Problem_18 {
    public static int getTotalIslands(int[][] mat) 
	{
        int n = mat.length;
        int m = mat[0].length;
        int[][] visited = new int[n][m];
        int islands = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(mat[i][j] == 1 && visited[i][j] == 0){
                    islands += 1;
                    dfs(i,j,visited,mat);
                }
            }
        }
        return islands;
    }

    public static void dfs(int r,int c,int[][] visited,int[][] mat){
        visited[r][c] = 1;
        int[][] offset = {{0,1},{1,0},{0,-1},{-1,0},{1,1},{1,-1},{-1,1},{-1,-1}};
        for(int[] off : offset){
            int nr = r + off[0];
            int nc = c + off[1];
            if(nr >= 0 && nc >= 0 && nr < mat.length && nc < mat[0].length && mat[nr][nc] == 1 && visited[nr][nc] == 0)
            {
                dfs(nr,nc,visited,mat);
            }
        } 
    }
}
