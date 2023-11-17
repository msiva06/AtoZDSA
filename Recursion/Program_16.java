// Subarrays with sum k
public class Program_16 {
    public static List< List < Integer > > subarraysWithSumK(int []a, long k) {
        int start = 0,end = 0;
        long sum = 0;
        List<List<Integer>> res = new ArrayList<>();
        
        while(end < a.length){
            List<Integer> subset = new ArrayList<>();
            while(sum + a[end] > k){
                sum -= a[start];
                start = start + 1; 
            }
            sum += a[end];
                
            if(sum == k){
                for(int i = start; i < end+1;i++){
                    subset.add(a[i]);
                }
                res.add(new ArrayList<>(subset));
            }
            end += 1;
        }
        return res;
    }
}
