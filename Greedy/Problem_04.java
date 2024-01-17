package Greedy;

import java.util.Arrays;

// Job sequencing problem
public class Problem_04 {
    public static int[] jobScheduling(int [][]jobs) {
        Arrays.sort(jobs,(a,b) -> b[2] - a[2]);
        int maxDead = 0;
        for(int i = 0; i < jobs.length; i++){
            maxDead = Math.max(maxDead,jobs[i][1]);
        }

        int[] complete = new int[maxDead+1];
        for(int i = 1; i < complete.length; i++){
            complete[i] = -1;
        }

        int cjobs = 0, profit = 0;
        for(int i = 0; i < jobs.length; i++){
            for(int j = jobs[i][1]; j > 0; j--){
                if(complete[j] == -1){
                    complete[j] = jobs[i][0];
                    cjobs += 1;
                    profit += jobs[i][2];
                    break;
                }
            }
        }
        int[] ans = new int[2];
        ans[0] = cjobs;
        ans[1] = profit;
        return ans;
    }
}
