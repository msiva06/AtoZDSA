package Arrays;

import java.util.ArrayList;

// Zero Matrix
public class Problem_01 {
    public static ArrayList<ArrayList<Integer>> zeroMatrix(ArrayList<ArrayList<Integer>> matrix, Integer n, Integer m) {
        int col0 = matrix.get(0).get(0);
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(matrix.get(i).get(j) == 0){
                    matrix.get(i).set(0,0);
                    if(j != 0)
                        matrix.get(0).set(j,0);
                    else
                        col0 = 0;
                }

            }
        }

        for(int i = 1; i < n; i++){
            for(int j = 1; j < m; j++){
                if(matrix.get(i).get(j) != 0){
                    if(matrix.get(0).get(j) == 0 || matrix.get(i).get(0) == 0)
                        matrix.get(i).set(j,0);
                }
            }
        }

        if(matrix.get(0).get(0) == 0){
            for(int j = 0; j < m; j++){
                matrix.get(0).set(j,0);
            }
                
        }

        if(col0 == 0){
            for(int i = 0; i < n; i++){
                matrix.get(i).set(0,0);
            }
        }
        return matrix;
    }
}
