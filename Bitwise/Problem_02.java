package Bitwise;

// Flipping an Image
public class Problem_02 {
    public static int[][] flipAndInvertImage(int[][] image) {

        int[][] res = new int[image.length][image[0].length];
        int xor = 1;
        for(int i = 0; i < image.length; i++){
           for(int j = 0; j < image[0].length; j++){
              res[i][j] = xor ^ image[i][j];
           }
        }
  
        for(int i = 0; i < res.length;i++){
           int left = 0, right = res[i].length-1;
           while(left < right){
              int temp = res[i][left];
              res[i][left] = res[i][right];
              res[i][right] = temp;
              left++;
              right--;
           }
        }
        return res;
     }
}
