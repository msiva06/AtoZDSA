package Arrays;

import java.util.ArrayList;

// Rotate Matrix clockwise
public class Problem_06 {
    public static void rotateMatrix(ArrayList<ArrayList<Integer>> mat, int n, int m) {
        int rowSt = 0, colSt = 0;
        while(rowSt < n && colSt < m){
            if(rowSt == n-1 || colSt == m-1)
                break;
            int previous = mat.get(rowSt+1).get(colSt);
            int curr;
            for(int j = colSt; j < m; j++){
                curr = mat.get(rowSt).get(j);
                mat.get(rowSt).set(j,previous);
                previous = curr;
            }
            rowSt++;
            for(int i = rowSt; i < n; i++){
                curr = mat.get(i).get(m-1);
                mat.get(i).set(m-1,previous);
                previous = curr;
            }
            m--;
            if(rowSt < n){
                 for(int j = m-1; j >= colSt; j--){
                    curr = mat.get(n-1).get(j);
                    mat.get(n-1).set(j,previous);
                    previous = curr;
                 }
            }
           
            n--;
            if(colSt < m){
                for(int i = n-1; i >= rowSt; i--){
                curr = mat.get(i).get(colSt);
                mat.get(i).set(colSt,previous);
                previous = curr;
                }
            }
        colSt++;
            
        }
    }
}
