package AtoZDSA.Arrays.Easy;

// Left rotate array by one
public class Problem_04 {
    static int[] rotateArray(int[] arr, int n) {
        int first = arr[0];
        for(int i = 1; i < arr.length; i++){
            arr[i-1] = arr[i];
        }
        arr[arr.length-1] = first;
        return arr;

    }
}
