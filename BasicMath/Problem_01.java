package AtoZDSA.BasicMath;

// Count Digits
public class Problem_01 {
    public static int countDigits(int n){
        int num = n;
        int count = 0;
        while(n > 0){
            int digit = n % 10;
            if(digit != 0 && num % digit == 0)
                count++;
            n = n / 10;
        }
        return count;
    }
    
}
