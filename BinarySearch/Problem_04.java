package BinarySearch;

// Median in a row-wise sorted matrix
public class Problem_04 {
    public static int findMedian(int matrix[][], int m, int n) {
        int low = 1, high = 1000000000;
        while(low <= high){
            int mid = low + (high - low)/2;
            int cnt = 0;
            for(int i = 0; i < m; i++){
                cnt += countSmaller(matrix[i],mid,n);
            }
            if(cnt <= (n * m) / 2){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return low;
     }
 
     public static int countSmaller(int[] a, int val, int m){
         int low = 0, high = m-1;
         while(low <= high){
             int mid = low +(high - low)/2;
             if(a[mid] <= val){
                 low = mid+1;
             }
             else{
                 high = mid -1;
             }
         }
         return low;
     }
}
