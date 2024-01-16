package Arrays;

// Remove Duplicates from sorted array
public class Problem_23 {
    public static int removeDuplicates(int[] arr,int n) {
		int prev = -1,ind = -1;
        for(int i = 0; i < arr.length; i++){
			int curr = arr[i];
			if(curr == prev){
				continue;
			}

			else{
				ind++;
			}
			prev = curr;
		}
		return ind+1;
    }
}
