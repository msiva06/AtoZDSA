// Frog Jump
public class Problem_03 {
    public static int frogJump(int n, int heights[]) {
        int[] memo = new int[n+1];
        Arrays.fill(memo,-1);
        memo[0] = 0;
        for(int i = 1; i < heights.length; i++){
            int oneJump = memo[i-1]+Math.abs(heights[i] - heights[i-1]);
            int twoJump = Integer.MAX_VALUE;
            if(i > 1)
                twoJump = memo[i-2]+Math.abs(heights[i] - heights[i-2]);
            memo[i] = Math.min(oneJump,twoJump);
        }
        return memo[n-1];
        //return minFrogJumpEnergy(n,heights,heights.length-1,memo);
    }

    public static int minFrogJumpEnergy(int n, int[] heights,int idx,int[] memo){
        if(idx == 0){
            return 0;
        }
        if(memo[idx] != -1)
            return memo[idx];
        
        int oneJump = minFrogJumpEnergy(n, heights, idx-1,memo) + Math.abs(heights[idx] - heights[idx-1]);
        int twoJump = Integer.MAX_VALUE;
        if(idx > 1)
            twoJump = minFrogJumpEnergy(n, heights, idx-2,memo) + Math.abs(heights[idx] - heights[idx-2]);
        memo[idx] =  Math.min(oneJump,twoJump);
        return memo[idx];

    }
}
