import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// N Queens
public class Program_23 {
    public static List< List< Integer > > nQueens(int n)
    {
        int[][] board = new int[n][n];
        List<List<Integer>> res = new ArrayList<>();
        int[] lowerDiag = new int[2 * n -1];
        int[] upperDiag = new int[2 * n - 1];
        int[] leftRow = new int[n];
        generateQueens(0,board,res,lowerDiag,upperDiag,leftRow);
        return res;
    }

    public static void generateQueens(int col,int[][] board,List<List<Integer>> res,
    int[] lowerDiag,int[] upperDiag,int[] leftRow){
        if(col == board.length){
            res.addAll(construct(board));
            return;
        }

        for(int row = 0; row < board.length;row++){
            int n = board.length;
            if(lowerDiag[row + col] == 0 && leftRow[row] == 0 && upperDiag[n-1+col-row] == 0){
                board[row][col] = 1;
                lowerDiag[row + col] = 1;
                leftRow[row] = 1;
                upperDiag[n-1+col-row] = 1;
                generateQueens(col+1, board, res, lowerDiag,upperDiag,leftRow);
                board[row][col] = 0;
                lowerDiag[row + col] = 0;
                leftRow[row] = 0;
                upperDiag[n-1+col-row] = 0;
            }
        }
    }

    public static List<List<Integer>> construct(int[][] board){
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < board.length;i++){
            List<Integer> ds = IntStream.of(board[i]).boxed().collect(Collectors.toList());
            res.add(new ArrayList<>(ds));
        }
        return res;
    }
}
