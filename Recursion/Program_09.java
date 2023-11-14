public class Program_09 {
    public double myPow(double x, int n) {
        long pow = n;
        if(pow < 0){
            pow *= -1;
        }
        double ans = 1.0;
        while(pow > 0){
            if(pow % 2 == 1){
                ans = ans * x;
                pow -= 1;
            }
            else{
                x = x * x;
                pow /= 2;
            }
        }
        if(n < 0){
            ans = (double) 1.0 / (double) ans;
        }
        return ans;
    }
}
