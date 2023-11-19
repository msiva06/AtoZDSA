// Word Search
public class Program_21 {
    public static boolean present(char [][]board, String word, int n, int m) {

        for(int row = 0; row < n; row++){
            for(int col = 0; col < m; col++){
                if(isPresent(board,word,row,col)){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isPresent(char[][] board,String word,int row,int col){
        if(word.length() == 0)
            return true;
        if(row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] != word.charAt(0))
            return false;
        int[][] offset = {{0,1},{0,-1},{-1,0},{1,0}};
        char c = board[row][col];
        board[row][col] = '*';
        for(int[] off : offset){
            int newRow = row + off[0];
            int newCol = col + off[1];
            boolean res = isPresent(board,word.substring(1),newRow,newCol);
            if(res)
                return true;
        }
        board[row][col] = c;
        return false;
    }
}
