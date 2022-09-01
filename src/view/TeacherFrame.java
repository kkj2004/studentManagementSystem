package view;

import model.Student;
import model.Teacher;
import model.UserType;
import view.Teacher.*;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

public class TeacherFrame extends JFrame {

    private JPanel contentPane;
    public static UserType userType;
    public static Teacher teacher;

    /**
     * 教师登录后界面
     */

    /**
     * Create the frame.
     */
    public TeacherFrame(UserType u,Teacher t) {
        userType = u;
        teacher = t;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 647, 435);
        setLocationRelativeTo(null);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("当前用户：");
        lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        lblNewLabel.setBounds(201, 50, 86, 33);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("【"+u.getName()+"】"+t.getName());
        lblNewLabel_1.setForeground(Color.RED);
        lblNewLabel_1.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        lblNewLabel_1.setBounds(266, 50, 86, 33);
        contentPane.add(lblNewLabel_1);

        JButton btnNewButton = new JButton("录入成绩");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setStuGrade(e);
            }
        });
        btnNewButton.setBounds(50, 156, 118, 41);
        contentPane.add(btnNewButton);

        JButton btnNewButton_1 = new JButton("查询成绩");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                findStuGrade(e);
            }
        });
        btnNewButton_1.setBounds(50, 261, 118, 41);
        contentPane.add(btnNewButton_1);

        JButton btnNewButton_2 = new JButton("修改成绩");
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                changeStuGrade(e);
            }
        });
        btnNewButton_2.setBounds(225, 156, 118, 41);
        contentPane.add(btnNewButton_2);

        JButton btnNewButton_2_1 = new JButton("查询授课信息");
        btnNewButton_2_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    findTeachInfo(e);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        btnNewButton_2_1.setBounds(225, 261, 118, 41);
        contentPane.add(btnNewButton_2_1);

        JButton btnNewButton_2_2 = new JButton("修改密码");
        btnNewButton_2_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                revisePassword(e);
            }
        });
        btnNewButton_2_2.setBounds(416, 261, 118, 41);
        contentPane.add(btnNewButton_2_2);

        JButton btnNewButton_2_3 = new JButton("退出登录");
        btnNewButton_2_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                exitButton(e);
            }
        });
        btnNewButton_2_3.setBounds(416, 156, 118, 41);
        contentPane.add(btnNewButton_2_3);
    }

    private void exitButton(ActionEvent e) {
        this.setVisible(false);
        LoginFrame loginFrame = new LoginFrame();
        loginFrame.setVisible(true);
    }

    protected void findTeachInfo(ActionEvent e) throws SQLException {
        // TODO 自动生成的方法存根
        FindCourseInfoFrame findCourseInfoFrame = new FindCourseInfoFrame();
        findCourseInfoFrame.setVisible(true);
    }

    //修改密码
    private void revisePassword(ActionEvent e) {
        // TODO 自动生成的方法存根
        RevisePassword revisePassword = new RevisePassword();
        revisePassword.setVisible(true);
    }
    protected void setStuGrade(ActionEvent e) {
        // TODO 自动生成的方法存根
        SetStudentGradeFrame setStudentGradeFrame = new SetStudentGradeFrame();
        setStudentGradeFrame.setVisible(true);
    }
    protected void findStuGrade(ActionEvent e) {
        // TODO 自动生成的方法存根
        FindStuGradeFrame findStuGradeFrame = new FindStuGradeFrame();
        findStuGradeFrame.setVisible(true);
    }
    protected void changeStuGrade(ActionEvent e) {
        // TODO 自动生成的方法存根
        ChangeStuGradeFrame changeStuGradeFrame = new ChangeStuGradeFrame();
        changeStuGradeFrame.setVisible(true);
    }
}
