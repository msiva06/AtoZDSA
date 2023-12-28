package Strings;

import java.util.ArrayList;
import java.util.List;

// KMP algorithm
public class Problem_06 {
    public static List< Integer > stringMatch(String text, String pattern) {
        List<Integer> ans = new ArrayList<>();
        int m = pattern.length();
        int[] lps = new int[m];
        int i = 1, j = 0;
        while(i < m){
            if(pattern.charAt(j) == pattern.charAt(i)){
                lps[i] = j+1;
                i++;
                j++;
            }
            else if(j > 0){
                j = lps[j-1];
            }
            else{
                lps[i] = 0;
                i++;
            }
        }
       i=0;
       j =0;
       while(i < text.length()){
           if(text.charAt(i) == pattern.charAt(j)){
               i++;
               j++;
           }
           else if(j > 0){
               j = lps[j-1];
           }
           else{
               i++;
           }
           if(j == m){
               ans.add(i-m+1);
               j = lps[j-1];

           }
       }
       return ans;

    }
}
