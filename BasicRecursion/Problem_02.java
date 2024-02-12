package AtoZDSA.BasicRecursion;

import java.util.ArrayList;
import java.util.List;

// Print n times
public class Problem_02 {
    public static List<String> printNtimes(int n){
        List<String> res = new ArrayList<>();
        print(res,n);
        return res;
    }

    public static void print(List<String> res,int n){
        if(n == 0)
            return;
        res.add("Coding Ninjas");
        print(res,n-1);
        return;
    }
}
