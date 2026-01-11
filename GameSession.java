package tictactoe;

public class GameSession {
    private Player player1;
    private Player player2;
    private GameState state;

    public GameSession(Player p1, Player p2) {
        this.player1 = p1;
        this.player2 = p2;
        this.state = GameState.PLAYING;
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public GameState getState() {
        return state;
    }

    public void setState(GameState state) {
        this.state = state;
    }
    
    
}
