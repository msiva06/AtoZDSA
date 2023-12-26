package Strings;

// Longest common Prefix
public class Problem_02 {
    public String longestCommonPrefix(String[] strs) {
        String res = "";
        if(strs == null || strs.length == 0)
            return res;
        for(int i = 0; i < strs[0].length(); i++){
            char c = strs[0].charAt(i);
            for(int j = 1; j < strs.length; j++){
                if(i == strs[j].length() || c != strs[j].charAt(i))
                    return strs[0].substring(0,i);
            }
        }
        return strs[0];
    }
}
