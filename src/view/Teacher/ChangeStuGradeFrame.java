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

public class ChangeStuGradeFrame extends JFrame {

    private JPanel contentPane;
    private JTextField StuName;
    private JTextField ChangeGrade;
    private JLabel PreStuGrade;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ChangeStuGradeFrame frame = new ChangeStuGradeFrame();
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
    public ChangeStuGradeFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("修改学生成绩");
        lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        lblNewLabel.setBounds(131, 15, 137, 30);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("学生姓名：");
        lblNewLabel_1.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        lblNewLabel_1.setBounds(90, 76, 84, 15);
        contentPane.add(lblNewLabel_1);

        JLabel lblNewLabel_1_1 = new JLabel("初始成绩：");
        lblNewLabel_1_1.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        lblNewLabel_1_1.setBounds(90, 108, 84, 15);
        contentPane.add(lblNewLabel_1_1);

        JLabel lblNewLabel_1_1_1 = new JLabel("修改为：");
        lblNewLabel_1_1_1.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        lblNewLabel_1_1_1.setBounds(98, 141, 84, 15);
        contentPane.add(lblNewLabel_1_1_1);

        StuName = new JTextField();
        StuName.setBounds(164, 72, 128, 21);
        contentPane.add(StuName);
        StuName.setColumns(10);

        ChangeGrade = new JTextField();
        ChangeGrade.setColumns(10);
        ChangeGrade.setBounds(171, 140, 128, 21);
        contentPane.add(ChangeGrade);

        PreStuGrade = new JLabel();
        PreStuGrade.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        PreStuGrade.setBounds(169, 110, 84, 15);
        contentPane.add(PreStuGrade);

        JButton btnNewButton = new JButton("查询");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    findStuGrade(e);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        btnNewButton.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        btnNewButton.setBounds(57, 179, 97, 23);
        contentPane.add(btnNewButton);

        JButton btnNewButton_1 = new JButton("修改");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    changeStuGrade(e);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        btnNewButton_1.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        btnNewButton_1.setBounds(195, 181, 97, 23);
        contentPane.add(btnNewButton_1);

        JButton btnNewButton_2 = new JButton("重置");
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resetButton(e);
            }
        });
        btnNewButton_2.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        btnNewButton_2.setBounds(58, 222, 97, 23);
        contentPane.add(btnNewButton_2);

        JButton btnNewButton_2_1 = new JButton("退出");
        btnNewButton_2_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                exitButton(e);
            }
        });
        btnNewButton_2_1.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        btnNewButton_2_1.setBounds(197, 226, 97, 23);
        contentPane.add(btnNewButton_2_1);
    }

    protected void findStuGrade(ActionEvent e) throws SQLException {
        // TODO 自动生成的方法存根
        TeacherDao teacherDao = new TeacherDao();
        String stuName = this.StuName.getText();
        String teacherName = TeacherFrame.teacher.getName();
        String courseName = teacherDao.getTeachCourse(teacherName);
        String preStuGrade = teacherDao.FindStuGrade(stuName, courseName);
        PreStuGrade.setText(preStuGrade);
    }

    protected void changeStuGrade(ActionEvent e) throws SQLException {
        // TODO 自动生成的方法存根
        TeacherDao teacherDao = new TeacherDao();
        String result = null;
        String stuName = this.StuName.getText();
        String teacherName = TeacherFrame.teacher.getName();
        String courseName = teacherDao.getTeachCourse(teacherName);
        int changeGrade = Integer.parseInt(this.ChangeGrade.getText());
        result = teacherDao.ChangeStuGrade(stuName,courseName,changeGrade);
        JOptionPane.showMessageDialog(this,result);
        this.resetButton(e);
    }

    protected void resetButton(ActionEvent e) {
        // TODO 自动生成的方法存根
        this.PreStuGrade.setText("");
        this.StuName.setText("");
        this.ChangeGrade.setText("");
    }

    protected void exitButton(ActionEvent e) {
        // TODO 自动生成的方法存根
        this.setVisible(false);
    }
}
