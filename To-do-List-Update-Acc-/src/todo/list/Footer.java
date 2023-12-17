package todo.list;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Footer extends JPanel {

    JButton addTask;
    JButton clear;
    JButton history;
    HistoryDialog historyDialog;
    List list;
    
    
    

    private ArrayList<String> doneHistory = new ArrayList<>();
    private static Footer instance;


    Footer() {
        this.setPreferredSize(new Dimension(400, 60));
        this.setBackground(new Color(30, 30, 30)); // Warna latar belakang hitam untuk tampilan futuristik
        this.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED)); // Efek bevel untuk memberikan kesan futuristik

        addTask = new JButton("Add Task");
        addTask.setBorder(BorderFactory.createEmptyBorder());
        addTask.setFont(new Font("Sans-serif", Font.PLAIN, 20));
        addTask.setVerticalAlignment(JButton.BOTTOM);
        addTask.setBackground(new Color(0, 128, 255)); // Warna biru tua
        addTask.setForeground(Color.black); // Warna teks putih
        this.add(addTask);

        history = new JButton("History");
        history.setBorder(BorderFactory.createEmptyBorder());
        history.setFont(new Font("Sans-serif", Font.PLAIN, 20));
        history.setBackground(new Color(128, 128, 128)); // Warna abu-abu
        history.setForeground(Color.black); // Warna teks putih
        this.add(history);

        this.add(Box.createHorizontalStrut(20)); // Space between buttons
        clear = new JButton("Clear finished tasks");
        clear.setFont(new Font("Sans-serif", Font.PLAIN, 20));
        clear.setBorder(BorderFactory.createEmptyBorder());
        clear.setBackground(new Color(255, 69, 0)); // Warna oranye
        clear.setForeground(Color.black); // Warna teks putih
        this.add(clear);

        list = new List();

    // Menambahkan ActionListener untuk tombol "Done"
    addTask.addActionListener(e -> {
        Task task = new Task();
        list.add(task);
        list.updateNumbers();

        task.getDone().addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                task.changeState();
                list.updateNumbers();
                revalidate();

                // Menambahkan catatan ke Done History
            }
        });
    });
    
    history.addActionListener(e -> showHistoryDialog());
    }

   


    public JButton getNewTask() {
        return addTask;
    }
    
    public static Footer getInstance() {
        if (instance == null) {
            instance = new Footer();
        }
        return instance;
    }

    public void showHistoryDialog() {
        System.out.println("Showing History Dialog");
        System.out.println("doneHistory: " + doneHistory);

        if (historyDialog == null) {
            historyDialog = new HistoryDialog((JFrame) SwingUtilities.getWindowAncestor(this), doneHistory);
        } else {
            historyDialog.dispose();
            historyDialog = new HistoryDialog((JFrame) SwingUtilities.getWindowAncestor(this), doneHistory);
        }
    }


    public JButton getClear() {
        return clear;
    }

    public ArrayList<String> getDoneHistory() {
        return doneHistory;
    }

    // Menambahkan metode untuk menambahkan catatan ke Done History
    public void addDoneHistory(String taskNote) {
        doneHistory.add(taskNote);
    }
    
    public JButton getHistory() {
        return history;
    }
    
    
}