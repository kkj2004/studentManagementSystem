package view.Student;

import dao.StudentDao;
import view.StudentFrame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class StudentInfo extends JFrame {

    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    StudentInfo frame = new StudentInfo();
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
    //学生登陆后的展示个人信息窗口
    public StudentInfo() throws SQLException {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        String StuName = StudentFrame.student.getName();
        StudentDao studentDao = new StudentDao();
        String StuDept = studentDao.getDept(StuName);
        String StuId = studentDao.getId(StuName);
        String StuAge = studentDao.getAge(StuName);
        String StuSex = studentDao.getSex(StuName);

        JLabel lblNewLabel = new JLabel("个人信息展示");
        lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        lblNewLabel.setBounds(139, 33, 126, 31);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("用户id：");
        lblNewLabel_1.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        lblNewLabel_1.setBounds(107, 90, 68, 31);
        contentPane.add(lblNewLabel_1);

        JLabel lblNewLabel_1_1 = new JLabel(StuId);
        lblNewLabel_1_1.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        lblNewLabel_1_1.setBounds(187, 91, 68, 31);
        contentPane.add(lblNewLabel_1_1);

        JLabel lblNewLabel_1_2 = new JLabel(" 姓  名：");
        lblNewLabel_1_2.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        lblNewLabel_1_2.setBounds(106, 123, 68, 31);
        contentPane.add(lblNewLabel_1_2);

        JLabel lblNewLabel_1_2_1 = new JLabel(StuName);
        lblNewLabel_1_2_1.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        lblNewLabel_1_2_1.setBounds(187, 123, 68, 31);
        contentPane.add(lblNewLabel_1_2_1);

        JLabel lblNewLabel_1_2_2 = new JLabel(" 性  别：");
        lblNewLabel_1_2_2.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        lblNewLabel_1_2_2.setBounds(104, 155, 68, 31);
        contentPane.add(lblNewLabel_1_2_2);

        JLabel lblNewLabel_1_2_1_1 = new JLabel(StuSex);
        lblNewLabel_1_2_1_1.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        lblNewLabel_1_2_1_1.setBounds(188, 152, 68, 31);
        contentPane.add(lblNewLabel_1_2_1_1);

        JLabel lblNewLabel_1_2_2_1 = new JLabel(" 年  龄：");
        lblNewLabel_1_2_2_1.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        lblNewLabel_1_2_2_1.setBounds(103, 188, 68, 31);
        contentPane.add(lblNewLabel_1_2_2_1);

        JLabel lblNewLabel_1_2_1_1_1 = new JLabel(StuDept);
        lblNewLabel_1_2_1_1_1.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        lblNewLabel_1_2_1_1_1.setBounds(181, 226, 155, 31);
        contentPane.add(lblNewLabel_1_2_1_1_1);

        JLabel lblNewLabel_1_2_2_1_1 = new JLabel(" 专  业：");
        lblNewLabel_1_2_2_1_1.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        lblNewLabel_1_2_2_1_1.setBounds(103, 225, 68, 31);
        contentPane.add(lblNewLabel_1_2_2_1_1);

        JLabel lblNewLabel_1_2_1_1_2 = new JLabel(StuAge);
        lblNewLabel_1_2_1_1_2.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        lblNewLabel_1_2_1_1_2.setBounds(182, 188, 68, 31);
        contentPane.add(lblNewLabel_1_2_1_1_2);

        JButton btnNewButton = new JButton("关闭");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CloseButton(e);
            }
        });
        btnNewButton.setBounds(329, 232, 97, 23);
        contentPane.add(btnNewButton);
    }
    //关闭这个窗体
    protected void CloseButton(ActionEvent e) {
        // TODO 自动生成的方法存根
        this.dispose();
    }

}
