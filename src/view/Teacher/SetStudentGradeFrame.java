package view.Teacher;

import dao.TeacherDao;
import view.TeacherFrame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

public class SetStudentGradeFrame extends JFrame {

    private JPanel contentPane;
    private JTextField StuName;
    private JTextField StuGrade;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    SetStudentGradeFrame frame = new SetStudentGradeFrame();
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
    public SetStudentGradeFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        setLocationRelativeTo(null);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("录入学生成绩");
        lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        lblNewLabel.setBounds(131, 29, 135, 28);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("学生姓名：");
        lblNewLabel_1.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        lblNewLabel_1.setBounds(104, 89, 86, 28);
        contentPane.add(lblNewLabel_1);

        JLabel lblNewLabel_1_1 = new JLabel("成绩：");
        lblNewLabel_1_1.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        lblNewLabel_1_1.setBounds(104, 146, 86, 28);
        contentPane.add(lblNewLabel_1_1);

        StuName = new JTextField();
        StuName.setBounds(174, 95, 110, 21);
        contentPane.add(StuName);
        StuName.setColumns(10);

        StuGrade = new JTextField();
        StuGrade.setColumns(10);
        StuGrade.setBounds(174, 152, 110, 21);
        contentPane.add(StuGrade);

        JButton btnNewButton = new JButton("录入");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    setStudentGrade(e);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        btnNewButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        btnNewButton.setBounds(56, 212, 97, 23);
        contentPane.add(btnNewButton);

        JButton btnNewButton_1 = new JButton("重置");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resetButton(e);
            }
        });

        btnNewButton_1.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        btnNewButton_1.setBounds(187, 214, 97, 23);
        contentPane.add(btnNewButton_1);

        JButton btnNewButton_1_1 = new JButton("退出");
        btnNewButton_1_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                exitButton(e);
            }
        });
        btnNewButton_1_1.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        btnNewButton_1_1.setBounds(304, 214, 97, 23);
        contentPane.add(btnNewButton_1_1);
    }

    protected void setStudentGrade(ActionEvent e) throws SQLException {
        // TODO 自动生成的方法存根
        TeacherDao teacherDao = new TeacherDao();
        String stuName = this.StuName.getText();
        String teacherName = TeacherFrame.teacher.getName();
        int grade = Integer.parseInt(this.StuGrade.getText());
        String courseName = teacherDao.getTeachCourse(teacherName);
        JOptionPane.showMessageDialog(this,teacherDao.SetStudentGrade(stuName,courseName,grade));
        this.resetButton(e);
    }

    protected void resetButton(ActionEvent e) {
        // TODO 自动生成的方法存根
        this.StuName.setText("");
        this.StuGrade.setText("");
    }

    protected void exitButton(ActionEvent e) {
        // TODO 自动生成的方法存根
        this.setVisible(false);

    }
}
