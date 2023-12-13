package todo.list;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

public class Task extends JPanel {

    JLabel index;
    JTextField taskName;
    JButton done;

    private boolean checked;

    Task() {
        this.setPreferredSize(new Dimension(400, 30));
        this.setBackground(new Color(30, 30, 30)); // Warna latar belakang hitam untuk tampilan futuristik

        this.setLayout(new BorderLayout());

        checked = false;

        index = new JLabel("");
        index.setPreferredSize(new Dimension(30, 30));
        index.setHorizontalAlignment(JLabel.CENTER);
        index.setForeground(Color.white); // Warna teks putih
        this.add(index, BorderLayout.WEST);

        taskName = new JTextField("");
        taskName.setBorder(BorderFactory.createEmptyBorder());
        taskName.setBackground(new Color(40, 40, 40)); // Warna latar belakang abu-abu tua
        taskName.setForeground(Color.white); // Warna teks putih
        taskName.setFont(taskName.getFont().deriveFont(12f)); // Ukuran font yang lebih kecil

        this.add(taskName, BorderLayout.CENTER);

        done = new JButton("Done");
        done.setPreferredSize(new Dimension(60, 30));
        done.setBorder(BorderFactory.createEmptyBorder());
        done.setFocusPainted(false);
        done.setBackground(new Color(0, 128, 255)); // Warna biru tua
        done.setForeground(Color.white); // Warna teks putih
        done.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED)); // Efek bevel untuk memberikan kesan futuristik

        this.add(done, BorderLayout.EAST);
    }

    public void changeIndex(int num) {
        this.index.setText(num + "");
        this.revalidate();
    }

    public JButton getDone() {
        return done;
    }

    public boolean getState() {
        return checked;
    }
   
    
    public String getTaskText() {
        return taskName.getText();
    }
  
   

    public void changeState() {
        this.setBackground(new Color(0, 255, 0)); // Warna hijau untuk tampilan futuristik
        taskName.setBackground(new Color(0, 255, 0));
        checked = true;
        revalidate();
        
//        String historyEntry = "Task completed: " + taskName.getText();
//        Footer.getInstance().addDoneHistory(historyEntry);
    }
}
