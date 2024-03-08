package Arrays.Easy;

// Spiral Matrix
public class Problem_11 {
    public static int[] spiralMatrix(int [][]MATRIX) {
        int rows = MATRIX.length;
         int cols = MATRIX[0].length;
         int[] res = new int[rows * cols];
         int idx = 0;
         int rowst = 0, rowEnd = rows-1, colst = 0, colEnd = cols-1;
 
         while(rowst < rows && colst < cols && rowEnd >= 0 && colEnd >= 0){
             for(int col = colst; col <= colEnd && idx < res.length; col++){
                 res[idx++] = MATRIX[rowst][col];
             }
            
             rowst++;
             for(int row = rowst; row <= rowEnd && idx < res.length; row++){
                 res[idx++] = MATRIX[row][colEnd];
             }   
             colEnd--;
 
             for(int col = colEnd; col >= colst && idx < res.length; col--){
                 res[idx++] = MATRIX[rowEnd][col];
             }
 
             rowEnd--;
             for(int row = rowEnd; row >= rowst && idx < res.length; row--){
                 res[idx++] = MATRIX[row][colst];
             }
             colst++;
         }
         return res;
 
     }
}
