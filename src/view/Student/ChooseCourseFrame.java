package view.Student;

import dao.StudentDao;
import view.StudentFrame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

public class ChooseCourseFrame extends JFrame {

    private JPanel contentPane;
    private JTextField ChooseCourseName;
    private JTextField ChooseCourseID;
    private JButton btnNewButton;
    private JButton btnNewButton_1;
    private JButton btnNewButton_2;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ChooseCourseFrame frame = new ChooseCourseFrame();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public ChooseCourseFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        setLocationRelativeTo(null);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("请输入课程名称：");
        lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        lblNewLabel.setBounds(60, 78, 136, 15);
        contentPane.add(lblNewLabel);

        ChooseCourseName = new JTextField();
        ChooseCourseName.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        ChooseCourseName.setBounds(185, 77, 164, 21);
        contentPane.add(ChooseCourseName);
        ChooseCourseName.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("请输入课程编号：");
        lblNewLabel_1.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        lblNewLabel_1.setBounds(60, 122, 136, 15);
        contentPane.add(lblNewLabel_1);

        ChooseCourseID = new JTextField();
        ChooseCourseID.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        ChooseCourseID.setColumns(10);
        ChooseCourseID.setBounds(185, 118, 164, 21);
        contentPane.add(ChooseCourseID);

        btnNewButton = new JButton("选课");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    chooseCourse(e);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        btnNewButton.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        btnNewButton.setBounds(45, 195, 97, 23);
        contentPane.add(btnNewButton);

        btnNewButton_1 = new JButton("重置");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resetButton(e);
            }
        });
        btnNewButton_1.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        btnNewButton_1.setBounds(181, 197, 97, 23);
        contentPane.add(btnNewButton_1);

        btnNewButton_2 = new JButton("退出选课");
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                exitButton(e);
            }
        });
        btnNewButton_2.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        btnNewButton_2.setBounds(309, 197, 97, 23);
        contentPane.add(btnNewButton_2);
    }

    protected void chooseCourse(ActionEvent e) throws SQLException {
        // TODO 自动生成的方法存根
        StudentDao sd = new StudentDao();
        String courseID = this.ChooseCourseID.getText();
        String courseName = this.ChooseCourseName.getText();
        String studentID = sd.getId(StudentFrame.student.getName());
        String studentName = StudentFrame.student.getName();
        JOptionPane.showMessageDialog(this,sd.ChooseCourse(studentID,studentName,courseID,courseName));
        this.resetButton(e);
    }
    protected void exitButton(ActionEvent e) {
        // TODO 自动生成的方法存根
        this.dispose();
    }
    protected void resetButton(ActionEvent e) {
        // TODO 自动生成的方法存根
        this.ChooseCourseID.setText("");
        this.ChooseCourseName.setText("");
    }
}
