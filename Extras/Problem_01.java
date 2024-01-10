package Extras;

// Plates between Candles
public class Problem_01 {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int n = s.length();
        int q = queries.length;
        int[] res = new int[q];
        int[] prefixPlates = new int[n];
        int[] leftPlate = new int[n];
        int[] rightPlate = new int[n];
        prefixPlates[0] = s.charAt(0) == '*' ? 1 : 0;
        leftPlate[0] = s.charAt(0) == '|' ? 0: -1;
        for(int i = 1; i < n; i++){
            prefixPlates[i] = s.charAt(i) == '*' ? prefixPlates[i-1] + 1 : prefixPlates[i-1];
            leftPlate[i] = s.charAt(i) == '|' ? i : leftPlate[i-1];
        }
        rightPlate[n-1] = s.charAt(n-1) == '|' ? n-1 : n;
        for(int i = n-2; i >=0; i--){
            rightPlate[i] = s.charAt(i) == '|' ? i : rightPlate[i+1];
        }
        
        for(int i = 0; i < queries.length; i++){
            int left = queries[i][0];
            int right = queries[i][1];
            int start = rightPlate[left];
            int end = leftPlate[right];
            int plateCount = (start >= end) ? 0 : prefixPlates[end] - prefixPlates[start];
            res[i] = plateCount;
        }
        return res;
    }
}
