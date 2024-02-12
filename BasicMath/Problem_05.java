package AtoZDSA.BasicMath;

// Sum of all divisors
public class Problem_05 {
    public static int sumOfAllDivisors(int n){
        
        int sum = 0;
        for(int i = 1; i <= n; i++){
            sum += divisors(i);
        }
        return sum;
    }

    public static int divisors(int n){
        int sum = 0;
        int sqrt = (int)Math.sqrt(n);
        for(int i = 1; i <= sqrt; i++){
            if(n % i == 0){
                sum += i;
                if(n/i != i){
                     sum += (n/i); 
                }
            }
        }
        return sum;
    }
}
