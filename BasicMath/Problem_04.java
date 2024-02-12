package AtoZDSA.BasicMath;

// GCD or HCF
public class Problem_04 {
    public static int calcGCD(int n, int m){
        if(m == 0){
            return n;
        }
        return calcGCD(m, n % m);
     }
}
