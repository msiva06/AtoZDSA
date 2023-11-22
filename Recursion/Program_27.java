import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// Word Break I
public class Program_27 {
    public static List< String > getAllValidSentences(String s, String []dict) {
        List<String> res = new ArrayList<>();
        Set<String> dictList = new HashSet();
        for(String str:dict){
            dictList.add(str);
        }
        res.addAll(generateValid(0,s,dictList));
        return res;
    }

    public static List<String> generateValid(int idx,String s,Set<String> dictList){
        if(idx == s.length()){
            List<String> emptyList = new ArrayList<>();
            emptyList.add("");
            return emptyList;
        }

        List<String> complete = new ArrayList<>();
        List<String> part = new ArrayList<>();
        for(int i = idx; i < s.length(); i++){
            String subStr = s.substring(idx,i+1);
            if(!dictList.contains(subStr)){
                continue;
            }
            part = generateValid(i+1, s, dictList);
            for(String p : part){
                if(p.length() == 0){
                    p = subStr + p;
                }
                else{
                    p = subStr + " " + p;
                }
                complete.add(p);
            }
            
        }
        return complete;
    }
}
