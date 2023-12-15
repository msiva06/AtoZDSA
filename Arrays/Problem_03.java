package Arrays;

// Sort 012
public class Problem_03 {
    public static void sort012(int[] arr)
    {
        int zeroPtr = 0, twoPtr = arr.length-1;
        int onePtr = 0;
        while(onePtr <= twoPtr){
            
            if(arr[onePtr] == 0){
                if(arr[zeroPtr] != 0){
                    swap(zeroPtr,onePtr,arr);  
                }
                zeroPtr++;
                onePtr++;
            }
            else if(arr[onePtr] == 1)
                onePtr++;
            else if(arr[onePtr] == 2){
                if(arr[twoPtr] != 2){
                    swap(onePtr,twoPtr,arr); 
                }
                twoPtr--;
            }
        }
    }

    public static void swap(int i,int j, int[] arr){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
}
