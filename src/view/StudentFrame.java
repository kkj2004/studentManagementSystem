package view;

import model.Student;
import model.UserType;
import view.Student.ChooseCourseFrame;
import view.Student.FindGradeFrame;
import view.Student.RevisePassword;
import view.Student.StudentInfo;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JButton;
//学生登陆后的界面
public class StudentFrame extends JFrame {

    private JPanel contentPane;
    public static UserType userType;
    public static Student student;

    /**
     * Launch the application.
     */

    /**
     * Create the frame.
     */
    public StudentFrame(UserType u,Student s) {
        userType = u;
        student = s;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        setLocationRelativeTo(null);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("当前用户：");
        lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        lblNewLabel.setBounds(94, 31, 96, 29);
        contentPane.add(lblNewLabel);
//        "【学生】xxx"
        JLabel lblxxx = new JLabel("【"+u.getName()+"】"+s.getName());
        lblxxx.setForeground(new Color(255, 0, 0));
        lblxxx.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        lblxxx.setBounds(200, 31, 114, 29);
        contentPane.add(lblxxx);

        JButton btnNewButton = new JButton("个人信息");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    studentInfo(e);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        btnNewButton.setFont(new Font("宋体", Font.PLAIN, 13));
        btnNewButton.setBounds(25, 108, 113, 29);
        contentPane.add(btnNewButton);

        JButton btnNewButton_1 = new JButton("成绩查询");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                findGrade(e);
            }
        });
        btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 13));
        btnNewButton_1.setBounds(313, 108, 113, 29);
        contentPane.add(btnNewButton_1);

        JButton btnNewButton_1_1 = new JButton("修改密码");
        btnNewButton_1_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                revisePassword(e);
            }
        });
        btnNewButton_1_1.setFont(new Font("宋体", Font.PLAIN, 13));
        btnNewButton_1_1.setBounds(246, 185, 113, 29);
        contentPane.add(btnNewButton_1_1);

        JButton btnNewButton_1_2 = new JButton("退出系统");
        btnNewButton_1_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                exitButton(e);
            }
        });
        btnNewButton_1_2.setFont(new Font("宋体", Font.PLAIN, 13));
        btnNewButton_1_2.setBounds(77, 185, 113, 29);
        contentPane.add(btnNewButton_1_2);

        JButton btnNewButton_1_2_1 = new JButton("选课");
        btnNewButton_1_2_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                chooseCourse(ae);
            }
        });
        btnNewButton_1_2_1.setFont(new Font("宋体", Font.PLAIN, 13));
        btnNewButton_1_2_1.setBounds(169, 108, 113, 29);
        contentPane.add(btnNewButton_1_2_1);
    }

    private void exitButton(ActionEvent e) {
        this.dispose();
        LoginFrame loginFrame = new LoginFrame();
        loginFrame.setVisible(true);
    }


    private void chooseCourse(ActionEvent ae) {
        // TODO 自动生成的方法存根
        ChooseCourseFrame chooseCourseFrame = new ChooseCourseFrame();
        chooseCourseFrame.setVisible(true);
    }
    //查询成绩方法
    protected void findGrade(ActionEvent e) {
        // TODO 自动生成的方法存根
        FindGradeFrame findGradeFrame = new FindGradeFrame();
        findGradeFrame.setVisible(true);
    }

    //修改密码方法
    private void revisePassword(ActionEvent e) {
        RevisePassword revisePassword = new RevisePassword();
        revisePassword.setVisible(true);
    }
    //查看学生信息方法
    protected void studentInfo(ActionEvent e) throws SQLException {
        // TODO 自动生成的方法存根
        StudentInfo studentInfo = new StudentInfo();
        studentInfo.setVisible(true);
    }


}
