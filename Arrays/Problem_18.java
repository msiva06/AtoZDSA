package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 4 Sum
public class Problem_18 {
    public static List<List<Integer>> fourSum(int []nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            if(i > 0 && nums[i] == nums[i-1])
                continue;
            for(int j = i +1; j < nums.length; j++){
                if(j != i+1 && nums[j] == nums[j-1])
                    continue;
                int sum = nums[i] + nums[j];
                int left = j+1, right = nums.length-1;
                while(left < right){
                    int totSum = sum + nums[left] + nums[right];
                    if(totSum > target){
                        right--;
                    }
                    else if(totSum < target){
                        left++;
                    }
                    else{
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[left]);
                        temp.add(nums[right]);
                        res.add(new ArrayList<>(temp));
                        left++;
                        right--;
                        while(left < right && nums[left] == nums[left-1]) 
                            left++;
                        while(left < right && nums[right] == nums[right+1])
                            right--;
                    }
                }
            
            }
        }
        return res;
    }
}
