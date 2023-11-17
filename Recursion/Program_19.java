// Combination Sum III
public class Program_19 {
    static ArrayList<ArrayList<Integer>> combinationSum3(int k, int n) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> ds = new ArrayList<>();
        generateComb(res,ds,k,n,1);
        return res;
 
     }
 
     public static void generateComb(ArrayList<ArrayList<Integer>> res,ArrayList<Integer> ds,int size,int n,int idx){
         if(ds.size() == size){
             if(n == 0)
             {
                     res.add(new ArrayList<>(ds));
             }
             return;
         }
         for(int i = idx; i <= 9; i++){
             if(!ds.isEmpty() && ds.contains(i)){
                 continue;
             }
             if(i > n)
                 break;
             ds.add(i);
             n -= i;
             generateComb(res,ds,size,n,i+1);
             n += i;
             ds.remove(ds.size()-1);
         }
     }
}
