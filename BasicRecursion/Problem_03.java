package AtoZDSA.BasicRecursion;

// N to 1 without loop
public class Problem_03 {
    public static int[] printNos(int x) {
        int[] res = new int[x];
        print(res,x,x);
        return res;
    }

    public static void print(int[] res,int x,int n){
        if(x == 0)
            return;
        res[x-1] = n - x + 1;
        print(res,x-1,n);
        return;
    }
}
