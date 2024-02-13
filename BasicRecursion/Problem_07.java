package AtoZDSA.BasicRecursion;

public class Problem_07 {
    public static boolean isPalindrome(String str) {
        if(str.length() == 1){
            return true;
        }
        int left = 0, right = str.length()-1;
        if(str.length() == 2 && str.charAt(left) == str.charAt(right)){
            return true;
        }
        if(str.charAt(left) != str.charAt(right)){
            return false;
        }
        return isPalindrome(str.substring(left+1,right));
    }
}
