/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package todolist;

/**
 *
 * @author Saifuddin
 */
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class TodoListApp extends JFrame {

    private DefaultListModel<String> todoListModel;
    private JList<String> todoList;
    private JTextField taskField;

    public TodoListApp() {
        setTitle("ToDo List App");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        todoListModel = new DefaultListModel<>();
        todoList = new JList<>(todoListModel);
        JScrollPane scrollPane = new JScrollPane(todoList);
        scrollPane.setPreferredSize(new Dimension(200, 200));

        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(new Color(255, 255, 255));
        mainPanel.setLayout(null);

        JLabel titleLabel = new JLabel("ToDo List");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setBounds(150, 20, 150, 30);

        JLabel taskLabel = new JLabel("Task:");
        taskLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        taskLabel.setBounds(50, 80, 50, 30);

        taskField = new JTextField();
        taskField.setBounds(100, 80, 150, 30);

        JButton addButton = new JButton("Add Task");
        addButton.setFont(new Font("Arial", Font.PLAIN, 14));
        addButton.setBounds(270, 80, 100, 30);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addTask();
            }
        });

        JButton removeButton = new JButton("Remove Task");
        removeButton.setFont(new Font("Arial", Font.PLAIN, 14));
        removeButton.setBounds(270, 120, 120, 30);
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeTask();
            }
        });

        mainPanel.add(titleLabel);
        mainPanel.add(taskLabel);
        mainPanel.add(taskField);
        mainPanel.add(addButton);
        mainPanel.add(removeButton);
        mainPanel.add(scrollPane);

        add(mainPanel);
        setVisible(true);
    }

    private void addTask() {
        String task = taskField.getText().trim();
        if (!task.isEmpty()) {
            todoListModel.addElement(task);
            taskField.setText("");
        }
    }

    private void removeTask() {
        int selectedIndex = todoList.getSelectedIndex();
        if (selectedIndex != -1) {
            todoListModel.remove(selectedIndex);
        }
    }

    public static void main(String[] args) {
        new TodoListApp();
    }
}

