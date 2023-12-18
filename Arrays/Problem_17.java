package Arrays;

import java.util.ArrayList;
import java.util.List;

// Count Inversions
public class Problem_17 {
    public static long getInversions(long arr[], int n) {
        return mergeSort(arr,0,arr.length-1);
    }

    public static int mergeSort(long[] arr,int low,int high){
        int count = 0;
        if(low >= high)
            return count;
        int mid = low + (high - low)/2;
        count += mergeSort(arr,low,mid);
        count += mergeSort(arr, mid+1, high);
        count += merge(arr,low,mid,high);
        return count;
    }

    public static int merge(long[] arr,int low,int mid,int high){
        int left = low, right = mid+1;
        int count = 0;
        List<Long> temp = new ArrayList<>();
        while(left <= mid && right <= high){
            if(arr[left] <= arr[right]){
                temp.add(arr[left]);
                left++;
            }
            else{
                count += mid - left + 1;
                temp.add(arr[right]);
                right++;
            }
        }
        while(left <= mid){
            temp.add(arr[left]);
            left++;
        }
        while(right <= high){
            temp.add(arr[right]);
            right++;
        }
        for(int i = low; i <= high; i++){
            arr[i] = temp.get(i-low);
        }
        return count;
    }
}
