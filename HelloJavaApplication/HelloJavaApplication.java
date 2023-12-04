package hellojavaapplication;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HelloJavaApplication extends JFrame {

    private JTextField usernameField;
    private JPasswordField passwordField;

    public HelloJavaApplication() {
        // Set judul frame
        setTitle("Login Form");

        // Set default close operation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set layout manager
        setLayout(new BorderLayout());

        // Panel untuk form login
        JPanel loginPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        loginPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Komponen untuk form login
        JLabel usernameLabel = new JLabel("Username:");
        JLabel passwordLabel = new JLabel("Password:");
        usernameField = new JTextField();
        passwordField = new JPasswordField();
        JButton loginButton = new JButton("Login");

        // Menambahkan komponen ke panel
        loginPanel.add(usernameLabel);
        loginPanel.add(usernameField);
        loginPanel.add(passwordLabel);
        loginPanel.add(passwordField);
        loginPanel.add(new JLabel()); // Placeholder
        loginPanel.add(loginButton);

        // Event handler untuk tombol login
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aksi yang diambil saat tombol login ditekan
                performLogin();
            }
        });

        // Menambahkan panel login ke frame
        add(loginPanel, BorderLayout.CENTER);

        // Pack frame
        pack();

        // Set lokasi tampilan di tengah layar
        setLocationRelativeTo(null);
    }

    private void performLogin() {
        // Mendapatkan nilai dari username dan password
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        // Contoh validasi sederhana (username: admin, password: admin)
        if (username.equals("admin") && password.equals("admin")) {
            JOptionPane.showMessageDialog(this, "Login berhasil!");
            // Tambahkan logika untuk menuju halaman utama atau aksi setelah login
        } else {
            JOptionPane.showMessageDialog(this, "Login gagal. Coba lagi.");
        }
    }

    public static void main(String[] args) {
        // Menjalankan aplikasi Swing di thread utama
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new HelloJavaApplication().setVisible(true);
            }
        });
    }
}

