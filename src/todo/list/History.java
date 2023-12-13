import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class History extends JDialog {

    private ArrayList<String> doneHistory;

    public History(JFrame parent, ArrayList<String> doneHistory) {
        super(parent, "Done History", true);
        this.doneHistory = doneHistory;

        initComponents();

        pack();
        setLocationRelativeTo(parent);
        setVisible(true);
    }

    private void initComponents() {
        JTextArea historyTextArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(historyTextArea);
        JButton closeButton = new JButton("Close");

        historyTextArea.setEditable(false);
        historyTextArea.setFont(new Font("Sans-serif", Font.PLAIN, 16));
        historyTextArea.setBackground(new Color(30, 30, 30));
        historyTextArea.setForeground(Color.white);

        for (String task : doneHistory) {
            historyTextArea.append(task + "\n");
        }

        closeButton.addActionListener(e -> dispose());

        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);
        add(closeButton, BorderLayout.SOUTH);
    }
}
