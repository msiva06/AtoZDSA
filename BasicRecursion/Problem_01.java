package AtoZDSA.BasicRecursion;

// 1 to N without Loop
public class Problem_01 {
    public static int[] printNos(int x) {
        int[] res = new int[x];
        recursive(x,res);
        return res;
    }

    public static void recursive(int num, int[] res){
        if(num == 0){
            return;
        }
        res[num-1] = num;
        recursive(num-1,res);
        return;
    }
}
