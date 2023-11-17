// IsSubset sum Present
public class Program_18 {
    public static boolean isSubsetPresent(int n, int k,int []a) {
        List<Integer> ds = new ArrayList<>();
        return isSubPresent(a, 0, ds, k);
    }

    public static boolean isSubPresent(int[] a,int idx,List<Integer> ds,int k){
        if(idx == a.length){
            if(k == 0)
                return true;
            return false;
        }
        ds.add(a[idx]);
        k -= a[idx];
        if(isSubPresent(a, idx+1, ds,k))
            return true;
        k += a[idx];
        ds.remove(ds.size()-1);
        if(isSubPresent(a, idx+1, ds,k))
            return true;
        return false;
    }
}
