package Arrays;

import java.util.ArrayList;

// Search in a 2D Matrix
public class Problem_10 {
    static boolean searchMatrix(ArrayList<ArrayList<Integer>> mat, int target) {
        int n = mat.size();
        int m = mat.get(0).size();
        int row = 0;
        while(row < n){
            if(mat.get(row).get(0) <= target && mat.get(row).get(m-1) >= target){
                int left = 0, right = m-1;
                while(left <= right){
                    int mid = left + (right - left) / 2;
                    if(mat.get(row).get(mid) > target){
                        right = mid -1;
                    }
                    else if(mat.get(row).get(mid) < target){
                        left = mid+1;
                    }
                    else{
                        return true;
                    }
                }
                return false;
            }
            else
                row++;
        }
        return false;
    }
}
