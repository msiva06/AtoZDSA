import java.util.Arrays;

// Ninja's Training
public class Problem_07 {
     public static int ninjaTraining(int n, int points[][]) {
        int[][] memo = new int[n][4];
        for(int i = 0; i < memo.length; i++){
            Arrays.fill(memo[i],-1);
        }
        memo[0][0] = Math.max(points[0][1],points[0][2]);
        memo[0][1] = Math.max(points[0][0], points[0][2]);
        memo[0][2] = Math.max(points[0][1], points[0][0]);
        memo[0][3] = Math.max(Math.max(points[0][0],points[0][1]),points[0][2]);
        for(int day = 1; day < memo.length; day++){
            for(int last = 0; last < memo[0].length; last++){
                int maxi = 0;
                for(int task = 0; task < 3; task++){
                    if(last != task){
                        int activity = points[day][task] + memo[day-1][task];
                        maxi = Math.max(activity,maxi);
                    }
                }
                memo[day][last] = maxi;
            }
        }
        return memo[n-1][3];
        //return ninTrain(n-1,3,points,memo);
    }

    public static int ninTrain(int day,int last,int[][] points,int[][] memo){
        if(day == 0){
            int maxi = 0;
            for(int i = 0; i < 3; i++){
                if(i != last){
                    maxi = Math.max(maxi,points[0][i]);
                }
            }
            return memo[day][last] = maxi;
        }
        if(memo[day][last] != -1)
            return memo[day][last];
        int maxi = 0;
        for(int i = 0; i < 3; i++){
            if(i != last){
                int actPoints = points[day][i] + ninTrain(day-1,i,points,memo);
                maxi = Math.max(maxi,actPoints);
            }
        }
        return memo[day][last] = maxi;
    }   
}
