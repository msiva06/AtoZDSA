// Maximum sum of non adjacent elements
public class Problem_05 {
    public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {
		int[] memo = new int[nums.size()];
		Arrays.fill(memo,-1);
		memo[0] = nums.get(0);
		for(int i = 1; i < nums.size();i++){
			int notPick = memo[i-1];
			int pick = nums.get(i);
			if(i > 1){
				pick += memo[i-2];
			}
			memo[i] = Math.max(pick,notPick);
		}
		return memo[nums.size()-1];
		// return maxSum(nums.size()-1,nums,memo);
	}

	public static int maxSum(int idx,ArrayList<Integer> nums,int[] memo){
		if(idx == 0)
			return nums.get(idx);
		if(idx < 0)
			return 0;
		if(memo[idx] != -1)
			return memo[idx];
		int pick = nums.get(idx) + maxSum(idx-2,nums,memo);
		int notPick = maxSum(idx-1,nums,memo);
		memo[idx] = Math.max(pick,notPick);
		return memo[idx];
	}
}
