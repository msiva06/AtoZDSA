package AtoZDSA.Arrays.Easy;

import java.util.ArrayList;
import java.util.Collections;

// Rotate array
public class Problem_05 {
    public static ArrayList<Integer> rotateArray(ArrayList<Integer> arr, int k) {
        ArrayList<Integer> temp = new ArrayList<>(Collections.nCopies(arr.size(),0));
        int n = arr.size();
        for(int i = 0; i < arr.size(); i++){
            temp.set((i+n-k)%n, arr.get(i));
        }
        return temp;
    }
}
