// String to Integer(atoi)
public class Program_08 {
    public int myAtoi(String s) {
        s = s.trim();
        if(s.length() == 0)
            return 0;
       
        int sign = 1;
        if(s.charAt(0) == '-')
        {
            sign = -1;
        }
        int num = 0;
        if(s.charAt(0) == '+' || s.charAt(0) == '-')
           num = strToInt(s,1,sign,0);
        else
           num = strToInt(s,0,sign,0);
        return num;
    }

    public int strToInt(String s, int idx, int sign, int finalNum){
        if(idx == s.length() || !Character.isDigit(s.charAt(idx))){
            return finalNum * sign;
        }
        int currNum = s.charAt(idx) - '0';
        if((finalNum > Integer.MAX_VALUE /10) || (finalNum == Integer.MAX_VALUE/10 && currNum > Integer.MAX_VALUE % 10) ){
            return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
        finalNum = finalNum * 10 + currNum;
        return strToInt(s,idx+1,sign,finalNum);
    }
}
