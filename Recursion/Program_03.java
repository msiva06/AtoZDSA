import java.util.ArrayList;
import java.util.List;

// Combination Sum
public class Program_03 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> combination = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        findCombinations(candidates,combination,ans,target,0);
        return ans;
    }

    public void findCombinations(int[] candidates,List<Integer> combination,List<List<Integer>> ans,int target,int idx){
        if(idx == candidates.length){
            if(target == 0)
                ans.add(new ArrayList<>(combination));
            return;
        }
        if(candidates[idx] <= target){
            combination.add(candidates[idx]);
            findCombinations(candidates,combination,ans,target-candidates[idx],idx);
            combination.remove(combination.size()-1);
        }   
        findCombinations(candidates,combination,ans,target,idx+1);
    }
}
