package AtoZDSA.BasicMath;

// Prime Number check
public class Problem_06 {
    public static String isPrime(int num) {
		int sqrt = (int) Math.sqrt(num);
		if(num == 1)
			return "NO";
		for(int i = 2; i <= sqrt; i++){
			if(num % i == 0)
				return "NO";
		}
		return "YES";

	}
}
