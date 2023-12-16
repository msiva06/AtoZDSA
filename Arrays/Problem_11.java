package Arrays;

import java.util.HashSet;
import java.util.Set;

// Two sum
public class Problem_11 {
    public static String read(int n, int []book, int target){
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < book.length; i++){
            int remain = target - book[i];
            if(set.contains(remain))
                return "YES";
            set.add(book[i]);
        }
        return "NO";
    }
}
