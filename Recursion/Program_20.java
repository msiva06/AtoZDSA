// Combinations of Letter phone number
public class Program_20 {
    public static List<String> letterCombinations(String a) {
        Map<Character,List<String>> map = new HashMap<>();
        List<String> res = new ArrayList<>();
        map.put('1',Arrays.asList("1"));
        map.put('2',Arrays.asList("a","b","c"));
        map.put('3',Arrays.asList("d","e","f"));
        map.put('4',Arrays.asList("g","h","i"));
        map.put('5',Arrays.asList("j","k","l"));
        map.put('6',Arrays.asList("m","n","o"));
        map.put('7',Arrays.asList("p","q","r","s"));
        map.put('8',Arrays.asList("t","u","v"));
        map.put('9',Arrays.asList("w","x","y","z"));
        map.put('0',Arrays.asList("0"));
        generateString(res,map,a,0,new StringBuilder());
        return res;
     }
 
     public static void generateString(List<String> res,Map<Character,List<String>> map,String a, int idx,StringBuilder sb){
         if(idx == a.length()){
             res.add(new String(sb));
             return;
         }
         char c = a.charAt(idx);
         List<String> letters = map.get(c);
         for(String letter : letters){
             sb.append(letter);
             generateString(res,map,a,idx+1,sb);
             sb.deleteCharAt(sb.length()-1);
         }
         
     }
}
