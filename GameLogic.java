package tictactoe;

public class GameLogic {
    private Board board;

    public GameLogic(Board board) {
        this.board = board;
    }

    public boolean checkWin(char s) {
        int[][] win = {
            {0,1,2},{3,4,5},{6,7,8},
            {0,3,6},{1,4,7},{2,5,8},
            {0,4,8},{2,4,6}
        };

        for (int[] w : win) {
            if (board.getCell(w[0]) == s &&
                board.getCell(w[1]) == s &&
                board.getCell(w[2]) == s) {
                return true;
            }
        }
        return false;
    }
}
