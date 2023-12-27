package Strings;

// Min characters for palindrome
public class Problem_03 {
    public static int minCharsforPalindrome(String str) {
        String revStr = reverse(str);
        String nStr = str + "#" + revStr;

        int[] lps = new int[nStr.length()];
        int i = 1, j= 0;
        while(i < nStr.length()){
            if(nStr.charAt(j) == nStr.charAt(i)){
                lps[i] = j+1;
                j++;
                i++;
            }
            else if(j >0){
                j = lps[j-1];
            }
            else{
                lps[i] = 0;
                i++;
            }
        }
        return str.length() - lps[lps.length-1];
    }

    public static String reverse(String s){
        StringBuilder sb = new StringBuilder();
        for(int i = s.length()-1; i>=0; i--){
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
