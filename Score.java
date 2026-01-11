package tictactoe;

public class Score {
    private int scoreP1;
    private int scoreP2;

    public void addWinP1() {
        scoreP1++;
    }

    public void addWinP2() {
        scoreP2++;
    }

    public int getScoreP1() {
        return scoreP1;
    }

    public int getScoreP2() {
        return scoreP2;
    }
}
