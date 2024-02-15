package AtoZDSA.Arrays.Easy;

//Check sorted array
public class Problem_03 {
    public static int isSorted(int n, int []a) {

        for(int i = 1; i < a.length; i++){
            if(a[i-1] > a[i])
                return 0;
        }
        return 1;
        
    }
}
