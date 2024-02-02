package AtoZDSA.SlidingWindow;

// Count subarrays with k ones
public class Problem_02 {
    public static int subarrayWithSum(int []arr, int k) {
        
        int sum = 0;
        int count = 0;
        int[] prefix = new int[arr.length+1];
        prefix[0] = 1;
        for(int i = 0; i < arr.length; i++){
            sum += arr[i];
            if(sum >= k){
                count += prefix[sum - k];
            }
             
            prefix[sum]++;
        }
        return count;
    }
}
