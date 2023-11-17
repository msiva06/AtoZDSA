// More subsequences
public class Program_17 {
    public static String moreSubsequence(int n, int m, String a, String b) {
        char[] achar = a.toCharArray();
        char[] bchar = b.toCharArray();
        int aSubCount= subsets(a);
        int bSubCount = subsets(b);
        if(aSubCount >= bSubCount)
            return a;
        return b;
    }

    public static int subsets(String s) {
     Map<Character,Integer> map = new HashMap<>();
     for(int i = 0; i < s.length(); i++){
         map.put(s.charAt(i),-1);
     }

     int levelCount = 0, allCount = 0;
     for(int i = 0; i < s.length();i++){
         char c = s.charAt(i);
         if(i == 0){
             levelCount = 1;
             allCount = 1;
             map.put(c, levelCount);
             continue;
         }
         levelCount = allCount + 1;
         if(map.get(c) < 0){
             allCount = allCount + levelCount;
         }
         else{
             allCount = allCount + levelCount - map.get(c);
         }
         map.put(c,levelCount);
     }
     return allCount;
        
    }
}
