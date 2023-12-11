package Graph;

// Replace '0' with 'X' 
public class Problem_12 {
    public static void replaceOWithX(char matrix[][]) {
        int n = matrix.length;
        int m =  matrix[0].length;
        int[][] visited = new int[n][m];
            for(int j = 0; j < m; j++){
                if(matrix[0][j] == 'O' && visited[0][j] == 0 ){
                    notReplace(0,j,visited,matrix);
                }

                if( matrix[n-1][j] == 'O' && visited[n-1][j] == 0)
                    notReplace(n-1,j,visited,matrix);
            }

            for(int i = 0; i < n; i++){
                if(matrix[i][0] == 'O' && visited[i][0] == 0)
                    notReplace(i,0,visited,matrix);
                if(matrix[i][m-1] == 'O' && visited[i][m-1] == 0)
                    notReplace(i,m-1,visited,matrix);
            }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m;j++){
                if(matrix[i][j] == 'O' && visited[i][j]==0)
                    matrix[i][j] = 'X';
            }
        }
    }

    public static void notReplace(int row,int col,int[][] visited, char[][] matrix){
        
        visited[row][col]  = 1;
        int[][] offset = {{0,1},{-1,0},{1,0},{0,-1}};
        for(int[] off : offset){
            int nrow = row + off[0];
            int ncol = col + off[1];
            if(nrow >=0  &&  ncol >=  0 && nrow < matrix.length && ncol < matrix[0].length && matrix[nrow][ncol] == 'O' && visited[nrow][ncol] == 0){
                notReplace(nrow,ncol,visited,matrix);
            } 
        }
    }
}
