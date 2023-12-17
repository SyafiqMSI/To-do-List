package todo.list;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

public class TitleBar extends JPanel {

    TitleBar() {
        this.setPreferredSize(new Dimension(400, 80));
        this.setBackground(new Color(30, 30, 30)); // Warna latar belakang hitam untuk tampilan futuristik
        this.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED)); // Efek bevel untuk memberikan kesan futuristik

        JLabel titleText = new JLabel("To Do List");
        titleText.setPreferredSize(new Dimension(200, 60));
        titleText.setFont(new Font("Sans-serif", Font.BOLD, 20));
        titleText.setForeground(Color.white); // Warna teks putih
        titleText.setHorizontalAlignment(JLabel.CENTER);
        this.add(titleText);
    }

    // This method is just a placeholder; you should not throw an exception here.
    JLabel getTitleText() {
        return (JLabel) getComponent(0);
    }
}
