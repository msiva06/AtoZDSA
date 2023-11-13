import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Combination Sum II
public class Program_04 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer> combination = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        findCombination(candidates,target,0,ans,combination);
        return ans;
    }

    public void findCombination(int[] candidates,int target,int idx,List<List<Integer>> ans,List<Integer> combination){
        if(target == 0){
            ans.add(new ArrayList<>(combination));
            return;
        }
        for(int i = idx; i < candidates.length; i++){
            if(i != idx && candidates[i] == candidates[i-1])
                continue;
            if(candidates[i] > target)
                break;  
            if(candidates[i] <= target){
                combination.add(candidates[i]);
                findCombination(candidates,target - candidates[i],i+1,ans,combination);
                combination.remove(combination.size()-1);
            }
        }
    }
}
