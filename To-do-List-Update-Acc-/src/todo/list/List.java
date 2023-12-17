package todo.list;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class List extends JPanel {

    List() {
        // Use a modern layout with centered alignment
        FlowLayout layout = new FlowLayout(FlowLayout.CENTER, 10, 10);
        this.setLayout(layout);

        // Set a dark background color
        this.setBackground(new Color(32, 33, 36)); // Dark mode background color

        // Add a subtle border for a sleek appearance
        this.setBorder(BorderFactory.createLineBorder(new Color(64, 224, 208), 2)); // Turquoise border

        // Maintain the preferred size
        this.setPreferredSize(new Dimension(400, 560));
    }

    public void updateNumbers() {
        Component[] listItems = this.getComponents();

        for (int i = 0; i < listItems.length; i++) {
            if (listItems[i] instanceof Task) {
                ((Task) listItems[i]).changeIndex(i + 1);
            }
        }
    }

    public void removeCompletedTasks() {
        for (Component c : getComponents()) {
            if (c instanceof Task) {
                if (((Task) c).getState()) {
                    remove(c);
                    updateNumbers();
                }
            }
        }
    }
}
