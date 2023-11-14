import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Permutations
public class Program_07 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        generatePermutations(res,nums,0);
        return res;
    }

    public void generatePermutations(List<List<Integer>> res,int[] nums,int idx){
        if(idx == nums.length){
            res.add(new ArrayList<>(Arrays.stream(nums).boxed().toList()));
            return;
        }
        for(int i = idx; i < nums.length; i++){
            swap(nums,i,idx);
            generatePermutations(res,nums,idx+1);
            swap(nums,i,idx);
        }
    }

    public void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
