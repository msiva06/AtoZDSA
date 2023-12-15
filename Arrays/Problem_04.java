package Arrays;

import java.util.Collections;
import java.util.List;

// Next greater Permutation
public class Problem_04 {
    public static List< Integer > nextGreaterPermutation(List< Integer > A) {
        int bp = -1;
        int n = A.size();
        for(int i = A.size() - 2; i >= 0; i--){
            if(A.get(i) < A.get(i+1))
            {
                bp = i;
                break;
            }
        }
        if(bp == -1)
           Collections.reverse(A);
        else{
            for(int i = A.size()-1; i > bp; i--){
            if(A.get(i) > A.get(bp)){
                int temp = A.get(bp);
                A.set(bp,A.get(i));
                A.set(i,temp);
                break;
            }
        }
        List<Integer> subL = A.subList(bp+1, n);
        Collections.reverse(subL);
        }
        return A;
    }
}
