package AtoZDSA.BasicMath;

// Reverse bits
public class Problem_02 {
    public static long reverseBits(long n) {
		int[] bits = new int[32];
		for(int i = 0; i < 32; i++){
			if((n & (long) 1 << i) > 0){
				bits[i] = 1;
			}
		}
		for(int i =0; i < 16; i++){
			swap(i,31-i,bits);
		}

		long ans = 0;
		for(int i = 0; i < 32; i++){
			if(bits[i] == 1){
				ans += (long)1 << i;
			}
		}
		return ans;
	}

	public static void swap(int st,int ed,int[] bits){
		int temp = bits[st];
		bits[st] = bits[ed];
		bits[ed] = temp;
	}
}
