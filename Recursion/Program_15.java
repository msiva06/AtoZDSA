// Power set
public class Program_15 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsetFinal = new ArrayList<>();
        int subsetcount = (int) Math.pow(2,nums.length);
            for(int i = 0; i < subsetcount; i++){
                List<Integer> subs = new ArrayList<>();
                for(int j = 0; j < nums.length; j++){
                    if(getBit(i,j) == 1){
                        subs.add(nums[j]);
                    }
                }
                subsetFinal.add(subs);
            }  
        return subsetFinal;
    }

    public int getBit(int num,int bit){
        int temp = 1 << bit;
        temp &= num;
        return temp == 0 ? 0 : 1;
    }
}
