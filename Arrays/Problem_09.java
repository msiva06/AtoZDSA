package Arrays;

import java.util.ArrayList;

// Missing and repeating numbers
public class Problem_09 {
    public static int[] missingAndRepeating(ArrayList<Integer> arr, int n) {
        int[] hash = new int[n+1];
        int[] numbers = new int[2];
        for(int i= 0; i < arr.size();i++){
            int idx = arr.get(i);
            hash[idx] += 1;
        }

        for(int i = 1; i <= n; i++){
            if(hash[i] == 0){
                numbers[0] = i;
            }
            if(hash[i] > 1){
                numbers[1] = i;
            }
        }
        return numbers;
    }
}
