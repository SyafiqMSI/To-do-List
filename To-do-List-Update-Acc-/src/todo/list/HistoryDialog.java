package todo.list;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class HistoryDialog extends JDialog {

    private ArrayList<String> doneHistory;
    private JTextArea historyTextArea;  // Buat sebagai variabel instance

    public HistoryDialog(JFrame parent, ArrayList<String> doneHistory) {
        super(parent, "Done History", true);
        this.doneHistory = doneHistory;

        initComponents();

        pack();
        setLocationRelativeTo(parent);
        setVisible(true);
    }

    private void initComponents() {
        historyTextArea = createHistoryTextArea();  // Gunakan variabel instance
        JButton closeButton = createCloseButton();

        setLayout(new BorderLayout());
        add(new JScrollPane(historyTextArea), BorderLayout.CENTER);
        add(closeButton, BorderLayout.SOUTH);

        // Mengatur ukuran jendela
        setPreferredSize(new Dimension(600, 400));
        setMinimumSize(new Dimension(400, 300));
        setResizable(true);

        updateHistoryTextArea();  // Tambahkan pemanggilan ini untuk memperbarui konten
    }

    public void updateHistoryTextArea() {
        historyTextArea.setText("");  // Bersihkan terlebih dahulu
        for (String task : doneHistory) {
            historyTextArea.append(task + "\n");
        }
    }

    private JTextArea createHistoryTextArea() {
        JTextArea historyTextArea = new JTextArea();
        historyTextArea.setEditable(false);
        historyTextArea.setFont(new Font("Sans-serif", Font.PLAIN, 16));
        historyTextArea.setBackground(new Color(30, 30, 30));
        historyTextArea.setForeground(Color.black);

        return historyTextArea;
    }

    private JButton createCloseButton() {
        JButton closeButton = new JButton("Close");
        closeButton.addActionListener(e -> dispose());

        return closeButton;
    }
}
