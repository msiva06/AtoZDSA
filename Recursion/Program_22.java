// Rat maze
public class Program_22 {
    public static List<String> ratMaze(int [][]mat) {
        List<String> res = new ArrayList<>();
        findPath(res,mat,0,0,new StringBuilder());
        Collections.sort(res);
        return res;
      }
  
      public static void findPath(List<String> res,int[][] mat,int r,int c,StringBuilder sb){
          if(r == mat.length-1 && c == mat[0].length-1){
              if(mat[r][c] == 0)
                  return;
              String resStr = new String(sb);
              res.add(resStr);
              return;
          }
          if(r < 0 || r == mat.length || c < 0 || c == mat[0].length || mat[r][c] == 0){
              return;
          }
          int[][] offset = {{0,1},{1,0},{0,-1},{-1,0}};
          int val = mat[r][c];
          mat[r][c] = 0;
          for(int[] off : offset){
              int newRow = off[0];
              int newCol = off[1];
              if(newRow == 0 && newCol == 1){
                  sb.append("R");
              }
               if(newRow == 1 && newCol == 0){
                  sb.append("D");
              }
               if(newRow == 0 && newCol == -1){
                  sb.append("L");
              }
               if(newRow == -1 && newCol == 0){
                  sb.append("U");
              }
              findPath(res,mat,r+newRow,c+newCol,sb);
              sb.deleteCharAt(sb.length()-1);
              
          }
          mat[r][c] = val;
          
      }
}
