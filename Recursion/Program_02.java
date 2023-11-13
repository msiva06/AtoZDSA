import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Subsets II
public class Program_02 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<Integer> ds = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        subsetsWithDupCalc(nums,ds,ans,0);
        return ans;
    }

    public void subsetsWithDupCalc(int[] nums,List<Integer> ds,List<List<Integer>> ans,int idx){
        ans.add(new ArrayList<>(ds));
        for(int i = idx; i < nums.length; i++){
            if(i != idx && nums[i-1] == nums[i])
                continue;
            ds.add(nums[i]);
            subsetsWithDupCalc(nums,ds,ans,i+1);
            ds.remove(ds.size()-1);
        }
    }
}
