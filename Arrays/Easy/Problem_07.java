package AtoZDSA.Arrays.Easy;

import java.util.ArrayList;
import java.util.List;

// Merge 2 sorted array
public class Problem_07 {
    public static List< Integer > sortedArray(int []a, int []b) {
        int aPtr = 0, bPtr = 0;
        List<Integer> res = new ArrayList<>();

        while(aPtr < a.length && bPtr < b.length){
            if(a[aPtr] < b[bPtr]){
                if(res.isEmpty() || res.get(res.size()-1) != a[aPtr]){
                    res.add(a[aPtr]);
                }
                aPtr++;
            }
            else if(b[bPtr] < a[aPtr]){
                if(res.isEmpty() || res.get(res.size()-1) != b[bPtr]){
                    res.add(b[bPtr]);
                }
                
                bPtr++;
            }
            else{
                if(res.isEmpty() || res.get(res.size()-1) != a[aPtr]){
                    res.add(a[aPtr]);
                }
                aPtr++; 
            }
        }

        while(aPtr < a.length){
            if(res.isEmpty() || res.get(res.size()-1) != a[aPtr]){
                res.add(a[aPtr]); 
            }
            aPtr++;
        }

         while(bPtr < b.length){
            if(res.isEmpty() || res.get(res.size()-1) != b[bPtr]){
                res.add(b[bPtr]); 
            }
            bPtr++;
        }
        return res;
    }
}
