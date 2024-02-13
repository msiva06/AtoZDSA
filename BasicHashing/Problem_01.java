package AtoZDSA.BasicHashing;

// Count freq in a range
public class Problem_01 {
    public static int[] countFrequency(int n, int x, int []nums){
        int[] res = new int[n];
        for(int num : nums){
            if(num <= n)
                res[num-1]++;
        }
        return res;
    }
}
