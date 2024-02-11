package AtoZDSA.BasicMath;

// Check palindrome
public class Problem_03 {
    public static boolean palindromeNumber(int n){
        int rev = reverse(n);
        return rev == n;
    }

    public static int reverse(int n){
        int num = 0;
        while(n > 0){
            int digit = n % 10;
            num = num * 10 + digit;
            n /= 10; 
        }
        return num;
    }
}
