import java.util.ArrayList;
import java.util.List;

// Expression Add Operators
public class Program_26 {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        generate(0,"",0,0,num,res,target);
        return res;
    }

    public void generate(int idx,String path,long resSoFar,long prevNum,String num,List<String> res,int target){
        if(idx == num.length()){
            if(target == resSoFar){
                res.add(path);
            }
            return;
        }

        for(int i = idx; i < num.length(); i++){
            if(i != idx && num.charAt(idx) == '0')
                break;
            long currNum = Long.parseLong(num.substring(idx,i+1));
            if(idx == 0){
                generate(i+1,path + currNum,currNum,currNum,num,res,target);
            }
            else{
                generate(i+1,path + "+" + currNum, resSoFar + currNum, +currNum,num,res,target);
                generate(i+1,path + "-" + currNum, resSoFar - currNum, -currNum,
                num,res,target);
                generate(i+1,path + "*" + currNum, resSoFar - prevNum + prevNum * currNum, prevNum * currNum, num,res, target);
            }
        }
    }
}
