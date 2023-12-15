package Arrays;

import java.util.Arrays;

// Merge Two Sorted Arrays Without Extra Space
public class Problem_07 {
    public static void mergeTwoSortedArraysWithoutExtraSpace(long []a, long []b){
        int aLen = a.length;
        int bLen = b.length;
        int aPtr = a.length -1, bPtr = 0;
        while(aPtr >= 0 && bPtr < b.length){
            if(a[aPtr] > b[bPtr]){
                swap(aPtr,bPtr,a,b);
                 aPtr--;
                 bPtr++;
            }
            else
            break;
           
        }
        Arrays.sort(a);
        Arrays.sort(b);
    }

    public static void swap(int left,int right,long[]a,long[] b){
        long temp = a[left];
        a[left] = b[right];
        b[right] = temp;
    }
}
