// Count good numbers
public class Program_10 {
    long mod = (long)1e9+7;
    public int countGoodNumbers(long n) {
        long goodNum = 1;
        long even = n/2 + n%2;
        long odd = n/2;
        goodNum = power(5,even) * power(4,odd);
        return (int)(goodNum % mod);
    }

    public long power(long num,long n){
        long p = n;
        long ans = 1;
        while(p > 0){
            if(p % 2 ==1){
                ans *= num;
                ans %= mod;
                p -= 1;
            }
            else{
                num *= num;
                num %= mod;
                p /= 2;
            }
        }
        return ans;
    }
}
