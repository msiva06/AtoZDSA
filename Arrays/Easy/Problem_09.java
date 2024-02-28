package Arrays.Easy;

// Alternate numbers
public class Problem_09 {
    public static int[] alternateNumbers(int []a) {
        int pos  = 0, neg = 1;
        int[] res = new int[a.length];
        for(int i = 0; i < a.length; i++){
            if(a[i] < 0){
                res[neg] = a[i];
                neg += 2;
            }
            else{
                res[pos] = a[i];
                pos+=2 ;
            }
        }
        return res;
    }
}
