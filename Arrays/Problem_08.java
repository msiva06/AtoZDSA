package Arrays;

import java.util.ArrayList;

// Find duplicate in array
public class Problem_08 {
    public static int findDuplicate(ArrayList<Integer> arr, int n){
       int[] hash = new int[n+1];
       int elem = 0;
       for(int i = 0; i < arr.size();i++){
           int idx = arr.get(i);
           hash[idx]+=1;
           if(hash[idx] > 1)
           {
               elem = idx;
               break;
           }
           
       }
       return elem;
    }
}
