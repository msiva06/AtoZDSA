package BinarySearch;

// Allocate Books
public class Problem_02 {
    public static long ayushGivesNinjatest(int n, int m, int[] time) {
        long maxTime = Long.MIN_VALUE;
        long sum = 0;
        for(int i = 0;  i < time.length; i++){
            sum += time[i];
            maxTime = Math.max(maxTime,time[i]);
        }
        long low = maxTime, high = sum;
        while(low <= high){
            long mid = low + (high - low)/2;
            if(occupyChapters(time,mid) <= n){
                high = mid-1;
            }
            else if(occupyChapters(time,mid) > n){
                low = mid+1;
            }
        }
        return low;
    }

    public static long occupyChapters(int[] time,long dist){
        long currTime = 0, days = 1;
        for(int i = 0; i <time.length; i++){
            if(currTime + time[i] > dist){
                days++;
                currTime = (long)time[i];
            }
            else
                currTime += (long)time[i];
        }
        return days;
    }
}
