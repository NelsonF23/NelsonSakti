package tictactoe;

import javax.swing.*;
import java.awt.*;

public class PlayerForm extends JFrame {

    public PlayerForm() {
        setTitle("Input Player");
        setSize(350, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel root = new JPanel(new GridLayout(5,1,10,10));
        root.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
        root.setBackground(UIStyle.BG);

        JTextField p1Field = new JTextField();
        JTextField p2Field = new JTextField();

        JButton startBtn = new JButton("Play");
        JButton backBtn = new JButton("Back");

        startBtn.setFont(UIStyle.BUTTON);
        backBtn.setFont(UIStyle.BUTTON);

        startBtn.setBackground(UIStyle.PRIMARY);
        backBtn.setBackground(Color.GRAY);

        startBtn.setForeground(Color.WHITE);
        backBtn.setForeground(Color.WHITE);

        startBtn.setFocusPainted(false);
        backBtn.setFocusPainted(false);

        startBtn.addActionListener(e -> {
            String p1 = p1Field.getText().trim();
            String p2 = p2Field.getText().trim();

            if (p1.isEmpty() || p2.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "Nama pemain tidak boleh kosong");
                return;
            }

            new GameUI(p1, p2);
            dispose(); 
        });

        backBtn.addActionListener(e -> {
            dispose();
            new MainMenu();
        });

        root.add(new JLabel("Player 1"));
        root.add(p1Field);
        root.add(new JLabel("Player 2"));
        root.add(p2Field);
        root.add(startBtn);
        root.add(backBtn);

        add(root);
        setVisible(true);
    }
}
