// Minimum Elements
public class Problem_20 {
    public static int minimumElements(int num[], int x) {
        int n = num.length;
        int[][] memo = new int[n][x+1];
        for(int i = 0; i <= x; i++){
            if(i % num[0] == 0)
                memo[0][i] = i / num[0];
            else
                memo[0][i] = (int)Math.pow(10,9);
        }

        for(int i = 1; i < n; i++){
            for(int j = 0; j <= x;j++){
                int notpick = memo[i-1][j];
                int pick = (int) Math.pow(10,9);
                if(num[i] <= j){
                    pick = 1 + memo[i][j-num[i]];
                }
                memo[i][j] = Math.min(pick,notpick);
            }
        }
        return memo[n-1][x] == (int) Math.pow(10,9) ? -1:memo[n-1][x];
    //     for(int i = 0; i < n; i++)
    //         Arrays.fill(memo[i],-1);
    //   int minNum = minElem(n-1,num,x,memo);
    //   if(minNum == (int)Math.pow(10,9))
    //     return -1;
    //   return minNum;
    }

    public static int minElem(int idx,int[] num, int x,int[][] memo){
        if(idx == 0){
            if(x % num[idx] == 0)
                return x /num[idx];
            return (int)Math.pow(10,9);
        }
        if(memo[idx][x] != -1)
            return memo[idx][x];
        int notpick = 0 + minElem(idx-1,num,x,memo);
        int pick = (int)Math.pow(10,9);
        if(num[idx] <= x){
            pick = 1 + minElem(idx, num, x - num[idx],memo);
        }
        memo[idx][x] = Math.min(pick,notpick);
        return memo[idx][x];
    }
}
