package AtoZDSA.BasicRecursion;

// Sum of first N numbers
public class Problem_04 {
    public static long sumFirstN(long n) {
        if(n == 0)
            return 0;
        long sum = 0;
        sum = n + sumFirstN(n-1);
        return sum;
    }
}
