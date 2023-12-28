package Strings;

//Compare Version Numbers
public class Problem_05 {
    public static int compareVersions(String a, String b) 
    {
        int start1 = 0, end1 = 0;
        int start2 = 0, end2 = 0;
        a = removeLastZeroes(a);
        b = removeLastZeroes(b);
        while(true){
            while(end1 < a.length() && a.charAt(end1) != '.')
                end1++;
            while(end2 < b.length() && b.charAt(end2) != '.')
                end2++;
            if(end1 > end2)
                return 1;
            if(end2 > end1)
                return -1;
            for(int i = start1;i < end1; i++){
                if(a.charAt(i) < b.charAt(i))
                    return -1;
                if(b.charAt(i) < a.charAt(i))
                    return 1;
            }
                
           
            if(end1 == a.length() && end2 == b.length())
                return 0;
            if(end1 == a.length())
                return -1;
            if(end2 == b.length())
                return 1;
            start1 = end1;
            start2 = end2;
            end1++;
            end2++;
        }
    }

    public static String removeLastZeroes(String s){
        int p = s.length()-1;
        for(int i = s.length()-1; i >= 1; i-= 2){
            if(s.charAt(i) == '0' && s.charAt(i-1) == '.'){
                p -= 2;
            }
            else
                break;
        }
        return s.substring(0,p+1);
    }
}
