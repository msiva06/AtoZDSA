package Arrays;

import java.util.ArrayList;
import java.util.List;

// Pascal Triangle
public class Problem_02 {
    public static int[][] pascalTriangle(int N) {
        List<List<Integer>> pascal = new ArrayList<>();
        for(int row = 1; row <= N; row++){
            List<Integer> subPascal = new ArrayList<>();
            for(int col = 1; col <= row; col++){
                subPascal.add(nCr(row-1,col-1));
            }
            pascal.add(new ArrayList<>(subPascal));
        }
        int n = pascal.size();
        int[][] res = new int[n][];
        for(int i = 0; i < n; i++){
            int m = pascal.get(i).size();
            res[i] = new int[m];
            for(int j = 0; j < m; j++){
                res[i][j] = pascal.get(i).get(j);
            }
        }
        return res;
    }


    public static int nCr(int n, int c){
        long ans = 1;
        for(int i = 0; i < c; i++){
            ans *= (n - i);
            ans /= i+1;
        }
        return (int)ans;
    }
}
