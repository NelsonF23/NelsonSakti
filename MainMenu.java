package tictactoe;

import javax.swing.*;
import java.awt.*;

public class MainMenu extends JFrame {

    public MainMenu() {
        setTitle("Tic Tac Toe");
        setSize(350, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel root = new JPanel(new GridLayout(3,1,10,10));
        root.setBorder(BorderFactory.createEmptyBorder(30,30,30,30));
        root.setBackground(UIStyle.BG);

        JLabel title = new JLabel("TIC TAC TOE", SwingConstants.CENTER);
        title.setFont(UIStyle.TITLE);
        title.setForeground(UIStyle.TEXT);

        JButton startBtn = new JButton("Start Game");
        JButton historyBtn = new JButton("View History");

        startBtn.setFont(UIStyle.BUTTON);
        historyBtn.setFont(UIStyle.BUTTON);

        startBtn.setBackground(UIStyle.PRIMARY);
        historyBtn.setBackground(UIStyle.CARD);

        startBtn.setForeground(Color.WHITE);
        historyBtn.setForeground(UIStyle.TEXT);

        startBtn.setFocusPainted(false);
        historyBtn.setFocusPainted(false);

        startBtn.addActionListener(e -> {
            new PlayerForm();
            dispose();
        });

        historyBtn.addActionListener(e -> new HistoryView());

        root.add(title);
        root.add(startBtn);
        root.add(historyBtn);

        add(root);
        setVisible(true);
    }
}
