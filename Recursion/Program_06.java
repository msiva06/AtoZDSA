import java.util.ArrayList;
import java.util.List;
// Permutation Sequence
public class Program_06 {
    public String getPermutation(int n, int k) {
        List<String> num = new ArrayList<>();
        int fact = 1;
        for(int i = 1; i < n; i++){
            num.add(String.valueOf(i));
            fact *= i;
        }
        num.add(String.valueOf(n));
        k = k - 1;
        String ans = "";
        while(true){
            ans += num.get(k/fact);
            num.remove(k/fact);
            if(num.size() == 0)
                break;
            k %= fact;
            fact /= num.size();
        }
        return ans;
    }
}
