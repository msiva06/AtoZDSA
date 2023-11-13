import java.util.ArrayList;
import java.util.List;

// Palindrome partitioning
public class Program_05 {
     public List<List<String>> partition(String s) {
        List<String> part = new ArrayList<>();
        List<List<String>> ans = new ArrayList<>();
        findPartition(s,part,ans,0);
        return ans;
    }

    public void findPartition(String s,List<String> part,List<List<String>> ans,int idx){
        if(idx == s.length()){
            ans.add(new ArrayList<>(part));
            return;
        }
        for(int i = idx; i < s.length(); i++){
            String subStr = s.substring(idx, i+1);
            if(checkPalindrome(subStr)){
                part.add(subStr);
                findPartition(s,part,ans,i+1);
                part.remove(part.size()-1);
            }
        }
    }

    public boolean checkPalindrome(String s){
        int left = 0, right = s.length()-1;
        while(left < right){
            if(s.charAt(left) != s.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }
}
