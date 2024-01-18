package BinarySearch;

import java.util.ArrayList;

// Single element in a sorted array
public class Problem_05 {
    public static int singleNonDuplicate(ArrayList<Integer> arr)
    {
        int low = 0, high = arr.size()-1;
        while(low < high){
            int mid = low + (high - low) /2;
            if(mid % 2 == 1)
                mid--;
            if(arr.get(mid) == arr.get(mid+1)){
                low = mid + 2;
            }
            else{
                high = mid;
            }
        }
        return arr.get(low);
    }
}
