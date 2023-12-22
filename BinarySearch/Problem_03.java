package BinarySearch;

import java.util.Arrays;

// Aggressive cows
public class Problem_03 {
    public static int aggressiveCows(int []stalls, int k) {
        Arrays.sort(stalls);
        int low = 1;
        int n = stalls.length;
        int high = stalls[n-1] - stalls[0];
        int ans = 0;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(canConnectCows(stalls,k,mid)){
                ans = mid;
                low = mid+1;
            }
            else{
                high = mid - 1;
            }
        }
        return low;
    }

    public static boolean canConnectCows(int[] stalls,int cows,int dist){
        int cow = 1, lastDist = stalls[0];
        for(int i = 1; i < stalls.length; i++){
            if(stalls[i] - lastDist > dist){
                cow++;
                lastDist = stalls[i];
            }
            if(cow == cows)
                return true;
        }
        return false;
    }
}
