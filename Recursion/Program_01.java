import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// Subset sum
public class Program_01 {
    public static List<Integer> subsetSums(List<Integer> arr, int N) {
        List<Integer> subsetSum = new ArrayList<>();
        subsetSumCalc(arr,0,0,subsetSum);
        Collections.sort(subsetSum);
        return subsetSum;
    }

    public static void subsetSumCalc(List<Integer> arr,int index,int sum,List<Integer> subsetSum){
        if(index == arr.size()){
            subsetSum.add(sum);
            return;
        }
        subsetSumCalc(arr,index+1,sum + arr.get(index),subsetSum);
        subsetSumCalc(arr,index+1,sum,subsetSum);
    }
    public static void main(String[] args) {
        System.out.println(subsetSums(Arrays.asList(5,2,1), 3));
    }
}   
