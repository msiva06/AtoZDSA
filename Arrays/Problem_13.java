package Arrays;

// Majority Element
public class Problem_13 {
    public static int majorityElement(int []v) {
        int elem = -1;
        int occur = 0;
        int left = 0,right = 0;
        while(right < v.length){
            if(elem == -1){
                elem = v[right];
            }
            if(v[right] == elem){
                occur++;
            }
            else{
                occur--;
            }
            if(occur == 0){
                left++;
                while(v[left] == elem)
                  left++;
                elem = v[left];
                occur = 1;
            }
            right++;
        }
        return elem;
     }
}
