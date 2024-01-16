package Arrays;

// Trapping rain water
public class Problem_22 {
    public static long getTrappedWater(long []arr, int n) {
        long maxLeft = 0, maxRight = 0;
        int left = 0,right = arr.length-1;
        long res = 0;
        while(left <= right){
            if(arr[left] <= arr[right]){
                if(maxLeft < arr[left]){
                    maxLeft = arr[left];
                }
                else{
                    res += maxLeft - arr[left];
                }
                left++;
            }
            else{
                if(maxRight < arr[right]){
                    maxRight = arr[right];
                }
                else{
                    res += maxRight- arr[right];
                }
                right--;
            }
        }
        return res;
    }
}
