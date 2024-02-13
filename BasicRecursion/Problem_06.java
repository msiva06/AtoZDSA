package AtoZDSA.BasicRecursion;

// Reverse array
public class Problem_06 {
    public static int[] reverseArray(int n, int []nums) {
        int[] rev = new int[n];
        reverse(rev,nums,n,n-1);
        return rev;

    }

    public static void reverse(int[] rev,int[] nums,int n,int idx){
        if(idx < 0)
            return;
        rev[n-idx-1]= nums[idx];
        reverse(rev,nums,n,idx-1);
        return;
    }
}
