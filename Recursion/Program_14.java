// Generate Parantheses
public class Program_14 {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();  
        generate(n,res,new StringBuilder(),0,0);
        return res;
    }

    public void generate(int n, List<String> res,StringBuilder sb,int left,int right){
        if(left == n && right == n){
            res.add(new String(sb));
            return;
        }
        if(left < n){
            sb.append("(");
            generate(n,res,sb,left+1,right);
            sb.deleteCharAt(sb.length()-1);
        }
        if(right < left){
           sb.append(")");
            generate(n,res,sb,left,right+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
