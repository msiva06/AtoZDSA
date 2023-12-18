package Arrays;

import java.util.ArrayList;
import java.util.List;

// Majority Element(> N/3)
public class Problem_14 {
    public static List< Integer > majorityElement(int []v) {
        List<Integer> res = new ArrayList<>();
        int maxLen = v.length / 3;
        int elem1 = Integer.MIN_VALUE, elem2= Integer.MIN_VALUE;
        int cnt1 = 0, cnt2 = 0;
        int right = 0;
        while(right < v.length){
            if(cnt1 == 0 && elem2 != v[right]){
                elem1 = v[right];
                cnt1 = 1;
            }
            else if(cnt2 == 0 && elem1 != v[right]){
                elem2 = v[right];
                cnt2 = 1;
            }
            else if(elem1 == v[right])
                cnt1++;
            else if(elem2 == v[right])
                cnt2++;
            else{
                cnt1--;
                cnt2--;
            }

            right++;
        }
        cnt1 = 0;
        cnt2 = 0;
        for(int i = 0; i < v.length; i++){
            if(v[i] == elem1)
                cnt1++;
            if(v[i] == elem2)
                cnt2++;
        }
        if(cnt1 > maxLen)
            res.add(elem1);
        if(cnt2 > maxLen)
            res.add(elem2);
        return res;
    }
}
