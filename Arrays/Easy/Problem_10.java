package Arrays.Easy;

import java.util.ArrayList;
import java.util.List;

// Superior Elements
public class Problem_10 {
    public static List< Integer > superiorElements(int []a) {
        List<Integer> res = new ArrayList<>();
        res.add(a[a.length-1]);
        int max = a[a.length-1];
        for(int i = a.length-2; i >= 0; i--){
            if(a[i] > max){
                max = a[i];
                res.add(max);
            }
        }
        return res;
    }
}
