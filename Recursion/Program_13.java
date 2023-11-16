public class Program_13 {
    public static List< String > generateString(int N) {
        List<String> res = new ArrayList<String>();
        generate("",res,N);
        return res;
    }

    public static void generate(String curr, List<String> res, int N){
        if(curr.length() == N){
            res.add(curr);
            return;
        }
        generate(curr + "0", res, N);
        if(curr.length() == 0 || curr.charAt(curr.length()-1) != '1')
            generate(curr + "1", res, N);
    }
}
