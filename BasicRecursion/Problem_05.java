package AtoZDSA.BasicRecursion;

import java.util.ArrayList;
import java.util.List;

// Factorial of numbers less than N
public class Problem_05 {
    public static List<Long> factorialNumbers(long n) {
        long res = 1, count = 1;
        List<Long> ans = new ArrayList<>();
        while(res <= n/count){
            res *= count;
            ans.add(res);
            count++;
            
        }
        return ans;
    }
}
