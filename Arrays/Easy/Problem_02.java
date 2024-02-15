package AtoZDSA.Arrays.Easy;

// Second Largest number
public class Problem_02 {
    public static int[] getSecondOrderElements(int n, int []a) {
        int maxi = Integer.MIN_VALUE, mini = Integer.MAX_VALUE, smaxi =Integer.MIN_VALUE, smini = Integer.MAX_VALUE;
        for(int arr : a){
            mini = Math.min(mini,arr);
            maxi = Math.max(maxi,arr);
        }
  
        for(int arr : a){
            if(arr != mini && arr< smini)
              smini =  arr;
            if(arr != maxi && arr > smaxi)
              smaxi = arr;
        }
        return new int[]{smaxi,smini};
      }
}
