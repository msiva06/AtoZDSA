package AtoZDSA.BasicHashing;

import java.util.HashMap;
import java.util.Map;

// Highest/Lowest frequency elements
public class Problem_02 {
    public static int[] getFrequencies(int []v) {
       Map<Integer,Integer> freq = new HashMap<>();
       for(int val : v){
           freq.put(val,freq.getOrDefault(val, 0)+1);
       }
       int maxElem = 0, maxValue = Integer.MIN_VALUE, minElem = Integer.MAX_VALUE, minValue = Integer.MAX_VALUE;
       for(Integer key : freq.keySet()){
           int value = freq.get(key);
           if(value > maxValue){
               maxValue = value;
               maxElem = key;
           }
           else if(value == maxValue){
               maxElem = Math.min(maxElem,key);
           }
           if(value < minValue){
               minValue = value;
               minElem = key;
           }
           else if(value == minValue){
               minElem = Math.min(minElem,key);
           }
           
       }
       int[] res = new int[2];
       res[1] = minElem;
       res[0] = maxElem;

       return res;

    }
}
