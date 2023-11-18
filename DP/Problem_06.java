// House robber
public class Problem_06 {
    public int rob(int[] nums) {
        int[] memo = new int[nums.length];
        Arrays.fill(memo,-1);
        memo[0] = nums[0];
        for(int i = 1; i < nums.length; i++){
            int pick = nums[i];
            if(i >= 2){
                pick += memo[i-2];
            }
            int notpick = memo[i-1];
            memo[i] = Math.max(pick,notpick);
        }
        return memo[nums.length-1];
        //return maxCost(nums.length-1,nums,memo);
    }

    public int maxCost(int idx,int[] nums,int[] memo){
        if(idx == 0){
            return nums[idx];
        }
        if(idx < 0)
            return 0;
        if(memo[idx] != -1)
            return memo[idx];
        int pick = nums[idx];
        if(idx >= 2){
            pick += maxCost(idx - 2,nums,memo);
        }
        int notpick = maxCost(idx -1, nums,memo);
        memo[idx] =  Math.max(pick,notpick);
        return memo[idx];
    }
}
