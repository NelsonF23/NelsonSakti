package tictactoe;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class HistoryView extends JFrame {

    private JTextArea area;

    public HistoryView() {
        setTitle("Match History");
        setSize(450, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel root = new JPanel(new BorderLayout(10,10));
        root.setBackground(UIStyle.BG);
        root.setBorder(BorderFactory.createEmptyBorder(15,15,15,15));

        JLabel title = new JLabel("MATCH HISTORY", SwingConstants.CENTER);
        title.setFont(UIStyle.TITLE);
        title.setForeground(UIStyle.TEXT);

        area = new JTextArea();
        area.setEditable(false);
        area.setFont(UIStyle.SUBTITLE);
        area.setBackground(UIStyle.CARD);
        area.setForeground(UIStyle.TEXT);

        JScrollPane scroll = new JScrollPane(area);

        JButton clearBtn = new JButton("Clear History");
        clearBtn.setFont(UIStyle.BUTTON);
        clearBtn.setBackground(Color.RED.darker());
        clearBtn.setForeground(Color.WHITE);
        clearBtn.setFocusPainted(false);

        clearBtn.addActionListener(e -> {
            int confirm = JOptionPane.showConfirmDialog(
                    this,
                    "Yakin ingin menghapus semua history?",
                    "Confirm",
                    JOptionPane.YES_NO_OPTION
            );

            if (confirm == JOptionPane.YES_OPTION) {
                HistoryManager.clearHistory();
                loadHistory();
            }
        });

        JPanel bottom = new JPanel();
        bottom.setBackground(UIStyle.BG);
        bottom.add(clearBtn);

        root.add(title, BorderLayout.NORTH);
        root.add(scroll, BorderLayout.CENTER);
        root.add(bottom, BorderLayout.SOUTH);

        add(root);

        loadHistory();

        new Timer(2000, e -> loadHistory()).start();

        setVisible(true);
    }

    private void loadHistory() {
        area.setText("");
        List<String> history = HistoryManager.readHistory();
        for (String h : history) {
            area.append(h + "\n");
        }
    }
}
