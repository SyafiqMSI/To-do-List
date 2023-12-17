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
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;

public class Footer extends JPanel {

    JButton addTask;
    JButton clear;
    JButton history;
    List list;
   
    private ArrayList<String> doneHistory = new ArrayList<>();
    private static Footer instance;
    private JButton hiss;
//    private HistoryTab hh;
    
    private void openLoginFrame() {
    Login loginFrame = new Login();
    loginFrame.setVisible(true);
    loginFrame.setLocationRelativeTo(null);
    JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
    currentFrame.dispose(); 
}
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
        
        hiss = new JButton("History");
        hiss.setBorder(BorderFactory.createEmptyBorder());
        hiss.setFont(new Font("Sans-serif", Font.PLAIN, 20));
        hiss.setVerticalAlignment(JButton.BOTTOM);
        hiss.setBackground(new Color(0, 128, 255)); // Warna biru tua
        hiss.setForeground(Color.black); // Warna teks putih
        hiss = new JButton();
//        hh = new HistoryTab();
//        hiss.add("History", hh);
        
        this.add(Box.createHorizontalStrut(20)); // Space between buttons
        clear = new JButton("Clear finished tasks");
        clear.setFont(new Font("Sans-serif", Font.PLAIN, 20));
        clear.setBorder(BorderFactory.createEmptyBorder());
        clear.setBackground(new Color(255, 69, 0)); // Warna oranye
        clear.setForeground(Color.black); // Warna teks putih
        this.add(clear);
        
        
        
        
        
    JButton loginButton = new JButton("LOG OUT");
    loginButton.addActionListener(e -> openLoginFrame());
    this.add(loginButton);
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
                addDoneHistory("Task completed: " + task.getTaskText());
            }
        });
    }
            
    );
    }

    
    
    


    public JButton getNewTask() {
        return addTask;
    }

    public JButton getHistory() {
        return history;
    }

    public JButton getClear() {
        return clear;
    }
    
    public static Footer getInstance() {
        if (instance == null) {
            instance = new Footer();
        }
        return instance;
    }
    
    public void taskCompleted(String taskText) {
//        hh.addCompletedTask(taskText);
    }

    public ArrayList<String> getDoneHistory() {
        return doneHistory;
    }

    // Menambahkan metode untuk menambahkan catatan ke Done History
    public void addDoneHistory(String taskNote) {
        doneHistory.add(taskNote);
    }
    
    
    
    
}