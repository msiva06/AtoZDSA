import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Longest increasing subsequence using binary search
public class Problem_43 {
    public static int longestIncreasingSubsequence(int arr[]) {
		List<Integer> res = new ArrayList<>();
		res.add(arr[0]);
		for(int i = 1; i < arr.length;i++){
			if(arr[i] > res.get(res.size()-1))
				res.add(arr[i]);
			else{
				int idx = Collections.binarySearch(res, arr[i]);
				if(idx < 0)
					idx = -idx - 1;
				res.set(idx,arr[i]);
			}
		}
		return res.size();
	}
}
