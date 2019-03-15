import java.util.ArrayList;

/**
 * Created by pradyumna on 2/22/19.
 * https://leetcode.com/problems/n-queens/
 */
public class NQueens {

    private boolean validQueenPosition(ArrayList<String> board, int row, int col) {
        return true;
    }

    private boolean solveNQueensUtil (ArrayList<ArrayList<String>> possibleBoards, ArrayList<String> board, int row, int a) {
        if (row > a) {
            return possibleBoards.add(new ArrayList<>(board));
        }

        String currentRow = board.get(row);
        for (int col = 0; col < a; col++) {
            Character position = currentRow.charAt(col);
            if (validQueenPosition(board, row, col)) {
                String updatedRow = currentRow.substring(0, col)+'Q'+currentRow.substring(col+1);
                board.add(row, updatedRow);
                solveNQueensUtil(possibleBoards, board, row+1, a);
            }
        }
        return true;
    }


    public ArrayList<ArrayList<String>> solveNQueens(int a) {

        return null;



    }



}
