package Strings;

import java.util.ArrayList;
import java.util.List;

// Z algorithm
public class Problem_07 {
    public static List< Integer > search(String s, String pattern){
        List<Integer> ans = new ArrayList<>();
        int m = pattern.length();
        String nStr = pattern + "#" + s;
        int n = nStr.length();
        int[] z = new int[n];
        int left = 0, right = 0;
        for(int i = 1; i < n; i++){
            if(i > right){
                left = right = i;
                while(right < n && nStr.charAt(right) == nStr.charAt(right-left))
                    right++;
                z[i] = right - left;
                right--;
            }
            else{
                int pos = i - left;
                if(z[pos] < right-i+1)
                    z[i] = z[pos];
                else{
                    left = i;
                    while(right < n && nStr.charAt(right) == nStr.charAt(right-left))
                        right++;
                    z[i] = right - left;
                    right--;
                }
            }
        }
        for(int i = 0; i<z.length;i++){
            if(z[i] == m){
                ans.add(i+1-m-1);
            }
        }
        return ans;
    }
}
