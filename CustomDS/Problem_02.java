package CustomDS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Time based key value store
public class Problem_02 {
    class TimeStamp {
	
	Map<String,List<String>> values;
	Map<String,List<Integer>> times;
	public TimeStamp() {
		values = new HashMap<>();
		times = new HashMap<>();
	}

	// Set TimeStamp data variables
	public void setValue(String key, String value, int timestamp) {

		if(values.containsKey(key)){
			if(timestamp > times.get(key).get(times.get(key).size()-1) && 
			!value.equals(values.get(key).get(values.get(key).size()-1))){
				values.get(key).add(value);
				times.get(key).add(timestamp);
			}
		}
		else{
			values.computeIfAbsent(key, k -> new ArrayList<>()).add(value);
			times.computeIfAbsent(key, k-> new ArrayList<>()).add(timestamp);
		}
	}

	// Get the value for the given key and timestamp
	public String getValue(String key, int timeStamp) {
		int idx = -1;
		if(!values.containsKey(key))
			return "";
		else{
			idx = binarySearch(times.get(key).size(),key,timeStamp);
		}

		if(idx > -1){
			return values.get(key).get(idx);
		}
		return "";
		
	}

	public int binarySearch(int n,String key,int timestamp){
		int left = 0, right = n, mid = 0;
		while(left < right){
			mid = (left) +(right - left)/2;
			if(!(times.get(key).get(mid) > timestamp)){
				left = mid + 1;
			}
			else{
				right = mid;
			}
		}
		return left-1;
	}
}
}
