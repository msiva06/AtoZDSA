package Bitwise;

// Find the difference
public class Problem_01 {
    public static int extraCharcterIndex(String str1, String str2) {

        int result = 0;
        for(int i =0; i < str1.length(); i++){
            result ^= (char)str1.charAt(i);
        }

        for(int i = 0; i < str2.length(); i++){
            result ^=(char)str2.charAt(i);
        }

        if(str1.length() > str2.length()){
            return str1.indexOf((char) result);
        }
        else{
            return str2.indexOf((char)result);
        }

    }
}
