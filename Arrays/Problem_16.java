package Arrays;

import java.util.ArrayList;

// Reverse pairs
public class Problem_16 {
    public static int reversePairs(ArrayList<Integer> arr) 
    {
        return mergeSort(arr,0,arr.size()-1);
    }

    public static int mergeSort(ArrayList<Integer> arr,int low,int high){
        int count = 0;
        if(low >= high)
            return count;
        int mid = low + (high - low)/2;
        count += mergeSort(arr,low,mid);
        count += mergeSort(arr,mid+1,high);
        count += countPair(arr,low,mid,high);
        merge(arr,low,mid,high);
        return count;
    }


    public static int countPair(ArrayList<Integer> arr,int low,int mid,int high){
        int right = mid+1;
        int count = 0;
        for(int i = low; i <= mid; i++){
            while(right <= high && arr.get(i) > 2 * arr.get(right))
            {
                right++;
            }
            count += right - (mid+1);
        }
        return count;
    }
    public static void merge(ArrayList<Integer> arr,int low,int mid,int high){
        int left = low, right = mid+1;
        int count = 0;
        ArrayList<Integer> temp = new ArrayList<>();
        while(left <= mid && right <= high){
            if(arr.get(left) > arr.get(right)){
                temp.add(arr.get(right));
                right++;
            }
            else {
                temp.add(arr.get(left));
                left++;
            }
        }
        while(left <= mid){
            temp.add(arr.get(left));
            left++;
        }

        while(right <= high){
            temp.add(arr.get(right));
            right++;
        }

        for(int i = low; i <= high;i++){
            arr.set(i,temp.get(i-low));
        }

    }
}
