package AtoZDSA.Arrays.Easy;

// Move zeros to the end
public class Problem_06 {
    public static int[] moveZeros(int n, int []a) {
        int j = 0;
        for(int i = 0; i < n; i++){
            if(a[i] != 0){
                a[j] = a[i];
                j++;
            }
        }
        for(;j < n; j++){
            a[j] = 0;
        }
        return a;
    }
}
