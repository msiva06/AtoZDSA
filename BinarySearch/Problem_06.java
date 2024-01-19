package BinarySearch;

// Search element in sorted rotated array
public class Problem_06 {
    public static int search(int arr[], int key) {
        int low = 0, high = arr.length-1;
        while(low <= high){
            int mid = (low + high)/2;
            if(arr[mid] == key)
                return mid;
            if(arr[mid] >= arr[low]){
                if(key >= arr[low] && key <= arr[mid])
                    high = mid-1;
                else    
                    low = mid+1;
            }
            else{
                if(key <= arr[high] && key >= arr[mid])
                    low = mid+1;
                else    
                    high = mid-1;
            }

        }
        return -1;
    }
}
