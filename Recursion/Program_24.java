// M-Coloring Problem
public class Program_24 {
    public static String graphColoring(int [][]mat, int m) {
        int n = mat.length;
        int[] color = new int[n];
        if(isValidColor(0,mat,m,n,color))
            return "YES";
        return "NO";
    }

    public static boolean isValidColor(int node,int[][] mat,int m, int n,int[] color){
        if(node == n){
            return true;
        }

        for(int col = 1; col <= m; col++){
            if(isValid(node,col,mat,color)){
                color[node] = col;
                boolean res = isValidColor(node + 1,mat,m,n,color);
                if(res)
                    return true;
                color[node] = 0;

            }
        }
        return false;
    }

    public static boolean isValid(int node,int col,int[][] mat,int[] color){
        int[] children = mat[node];
        for(int i = 0; i < children.length; i++){
            if(children[i] == 1){
               if(color[i] == col)
                    return false;
            } 
        }
        return true;
    }
}
