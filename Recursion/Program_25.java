// Sudoku solver
public class Program_25 {
    public static boolean sudokuSolver(int board[][]){

        /* Don't write main() function.
         * Don't read input, it is passed as function argument.
         * Don't print output and return output as specified in the question.
         */
        if(solve(board))
            return true;
        return false;
    }

    public static boolean solve(int[][] board){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == 0){
                    for(int k = 1; k <= 9; k++){
                        if(isValid(board,i,j,k)){
                            board[i][j] = k;
                            boolean res = solve(board);
                            if(res)
                                return true;
                            board[i][j] = 0;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isValid(int[][] board,int r,int c,int num){
        for(int i = 0; i < 9; i++){
            if(board[r][i] == num || board[i][c] == num || board[3 *(r/3) + i/3][3 * (c/3) + i%3] == num)
                return false;
        }
        return true;
    }
}
