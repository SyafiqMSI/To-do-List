package todo.list;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

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
    JButton delete;

    private boolean checked;
    private Task task;

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
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        done = new JButton("Done");
        done.setPreferredSize(new Dimension(50, 40));
        done.setBorder(BorderFactory.createEmptyBorder());
        done.setHorizontalAlignment(JLabel.CENTER);
        done.setFocusPainted(false);
        done.setBackground(new Color(0, 128, 255)); // Warna biru tua
        done.setForeground(Color.white); // Warna teks putih
        done.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED)); // Efek bevel untuk memberikan kesan futuristik

        done.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                done.setBackground(new Color(255, 69, 0)); // Warna oranye
                done.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                done.setBackground(new Color(0, 128, 255));
            }
        });
        this.add(done, BorderLayout.EAST);
        buttonPanel.add(done);
        
        delete = new JButton("Delete");
        delete.setPreferredSize(new Dimension(50, 40));
        delete.setBorder(BorderFactory.createEmptyBorder());
        delete.setFocusPainted(false);
        delete.setBackground(new Color(255, 0, 0)); // Red color for delete button
        delete.setForeground(Color.white);
        delete.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));

        delete.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseEntered(java.awt.event.MouseEvent evt) {
            delete.setBackground(new Color(139, 0, 0)); // Dark red on hover
            delete.setCursor(new Cursor(Cursor.HAND_CURSOR));
        }

        public void mouseExited(java.awt.event.MouseEvent evt) {
            delete.setBackground(new Color(255, 0, 0));
        }
    });
    
    delete.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Handle delete button click
            List parentList = (List) getParent();
            parentList.removeTask(Task.this);
        }
    });
    
    this.add(buttonPanel, BorderLayout.EAST);
    buttonPanel.add(delete);

    }
    
    private String email; // Menambahkan variabel email di kelas Task
    
    public Task(String email) {
    // Inisialisasi variabel dan komponen lainnya
    this.email = email;
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

    // Menambahkan metode untuk mengatur nilai email
    public void setEmail(String email) {
        this.email = email;
    }
    
    public void changeState() {
    this.setBackground(new Color(0, 255, 0)); // Warna hijau untuk tampilan futuristik
    taskName.setBackground(new Color(0, 255, 0));
    checked = true;
    revalidate();
    // Call methods on 'this.task'
    saveDoneTaskToFile(getTaskText());
    String historyEntry = "Task completed: " + taskName.getText();
    Footer.getInstance().taskCompleted(historyEntry);


}
    
    
    private void saveDoneTaskToFile(String taskText) {
        String dir = "C:\\Users\\AS\\Documents\\NetBeansProjects\\To-do-List-Update-Acc-\\user\\donetask";
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String currentDate = dateFormat.format(new Date());
        
        File userFile = new File(dir,currentDate+".txt"); // Use the stored email

        // Check if the file already exists
        if (!userFile.exists()) {
            try {
                // If the file doesn't exist, create a new one
                userFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
                // Handle the exception as needed for your application
            }
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(userFile, true))) {
            writer.write(taskText);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception as needed for your application
        }
    }

    private void tambahhistory(String TaskText){
        
    }
}