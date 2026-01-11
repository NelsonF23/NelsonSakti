package tictactoe;

import javax.swing.*;
import java.awt.*;

public class GameUI extends JFrame {

    private Board board = new Board();
    private GameLogic logic = new GameLogic(board);
    private GameState state = GameState.PLAYING;
    private boolean turnX = true;
    private Score score = new Score();

    public GameUI(String p1, String p2) {

        setTitle("Tic Tac Toe");
        setSize(420, 580);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());
        getContentPane().setBackground(UIStyle.BG);

        JLabel status = new JLabel("Turn: " + p1, SwingConstants.CENTER);
        status.setFont(UIStyle.SUBTITLE);
        status.setForeground(UIStyle.TEXT);

        JLabel scoreLabel = new JLabel(
                "Score - " + p1 + ": 0 | " + p2 + ": 0",
                SwingConstants.CENTER
        );
        scoreLabel.setFont(UIStyle.SUBTITLE);
        scoreLabel.setForeground(UIStyle.MUTED);

        JPanel top = new JPanel(new GridLayout(2,1));
        top.setBackground(UIStyle.CARD);
        top.add(status);
        top.add(scoreLabel);

        JPanel grid = new JPanel(new GridLayout(3,3,14,14));
        grid.setBackground(UIStyle.BG);
        grid.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));

        JButton[] buttons = new JButton[9];

        for (int i = 0; i < 9; i++) {
            int idx = i;
            JButton btn = new JButton("");
            btn.setFont(UIStyle.GAME);
            btn.setBackground(UIStyle.CARD);
            btn.setForeground(UIStyle.ACCENT);
            btn.setFocusPainted(false);
            btn.setBorder(BorderFactory.createLineBorder(UIStyle.MUTED));

            btn.addActionListener(e -> {
                if (state != GameState.PLAYING) return;

                char sym = turnX ? 'X' : 'O';
                if (board.setCell(idx, sym)) {
                    btn.setText(String.valueOf(sym));

                    if (logic.checkWin(sym)) {
                        state = GameState.WIN;
                        String winner = turnX ? p1 : p2;

                        if (turnX) score.addWinP1();
                        else score.addWinP2();

                        scoreLabel.setText(
                                "Score - " + p1 + ": " + score.getScoreP1() +
                                " | " + p2 + ": " + score.getScoreP2()
                        );

                        HistoryManager.saveHistory(p1, p2, winner);

                        JOptionPane.showMessageDialog(this,
                                "Winner: " + winner);

                    } else if (board.isFull()) {
                        state = GameState.DRAW;
                        HistoryManager.saveHistory(p1, p2, "DRAW");
                        JOptionPane.showMessageDialog(this,"Draw!");
                    }

                    turnX = !turnX;
                    status.setText("Turn: " + (turnX ? p1 : p2));
                }
            });

            buttons[i] = btn;
            grid.add(btn);
        }

        JButton restartBtn = new JButton("New Game");
        JButton backBtn = new JButton("Back to Menu");

        restartBtn.setFont(UIStyle.BUTTON);
        restartBtn.setBackground(UIStyle.PRIMARY);
        restartBtn.setForeground(Color.WHITE);

        backBtn.setFont(UIStyle.BUTTON);
        backBtn.setBackground(UIStyle.CARD);
        backBtn.setForeground(UIStyle.TEXT);

        restartBtn.setFocusPainted(false);
        backBtn.setFocusPainted(false);

        restartBtn.addActionListener(e -> {
            board.reset();
            state = GameState.PLAYING;
            turnX = true;
            status.setText("Turn: " + p1);
            for (JButton b : buttons) b.setText("");
        });

        backBtn.addActionListener(e -> {
            dispose();
            new MainMenu();
        });

        JPanel bottom = new JPanel();
        bottom.setBackground(UIStyle.BG);
        bottom.add(restartBtn);
        bottom.add(backBtn);

        add(top, BorderLayout.NORTH);
        add(grid, BorderLayout.CENTER);
        add(bottom, BorderLayout.SOUTH);

        setVisible(true);
    }
}
