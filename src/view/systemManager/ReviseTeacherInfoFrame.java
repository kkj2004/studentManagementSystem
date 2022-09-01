package view.systemManager;

import dao.TeacherDao;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

public class ReviseTeacherInfoFrame extends JFrame {

    private JPanel contentPane;
    private JTextField TeacherName;
    private JTextField ChangeTeacherCourse;
    private JTextField ChangeTeachID;
    private JTextField ChangeTeacherPassword;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ReviseTeacherInfoFrame frame = new ReviseTeacherInfoFrame();
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
    public ReviseTeacherInfoFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        setLocationRelativeTo(null);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("修改教师信息");
        lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        lblNewLabel.setBounds(130, 31, 144, 28);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_1_2 = new JLabel("请输入修改教师姓名：");
        lblNewLabel_1_2.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        lblNewLabel_1_2.setBounds(23, 80, 172, 15);
        contentPane.add(lblNewLabel_1_2);

        TeacherName = new JTextField();
        TeacherName.setBounds(179, 71, 113, 24);
        contentPane.add(TeacherName);

        JLabel lblNewLabel_2 = new JLabel("\u4FEE\u6539\u540E\uFF1A");
        lblNewLabel_2.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        lblNewLabel_2.setBounds(23, 116, 67, 15);
        contentPane.add(lblNewLabel_2);

        JLabel lblNewLabel_1_1_1 = new JLabel("  授课科目：");
        lblNewLabel_1_1_1.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        lblNewLabel_1_1_1.setBounds(88, 118, 107, 15);
        contentPane.add(lblNewLabel_1_1_1);

        ChangeTeacherCourse = new JTextField();
        ChangeTeacherCourse.setBounds(179, 107, 113, 24);
        contentPane.add(ChangeTeacherCourse);

        JLabel lblNewLabel_1_1_1_1 = new JLabel("  科目编号：");
        lblNewLabel_1_1_1_1.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        lblNewLabel_1_1_1_1.setBounds(88, 162, 107, 15);
        contentPane.add(lblNewLabel_1_1_1_1);

        ChangeTeachID = new JTextField();
        ChangeTeachID.setBounds(179, 153, 113, 24);
        contentPane.add(ChangeTeachID);

        JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("    密  码：");
        lblNewLabel_1_1_1_1_1_1.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        lblNewLabel_1_1_1_1_1_1.setBounds(98, 192, 81, 15);
        contentPane.add(lblNewLabel_1_1_1_1_1_1);

        ChangeTeacherPassword = new JTextField();
        ChangeTeacherPassword.setBounds(179, 183, 113, 24);
        contentPane.add(ChangeTeacherPassword);

        JButton btnNewButton = new JButton("确认修改");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    confirmButton(e);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        btnNewButton.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        btnNewButton.setBounds(34, 217, 97, 23);
        contentPane.add(btnNewButton);

        JButton btnNewButton_1 = new JButton("重置");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resetButton(e);
            }
        });
        btnNewButton_1.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        btnNewButton_1.setBounds(161, 217, 97, 23);
        contentPane.add(btnNewButton_1);

        JButton btnNewButton_1_1 = new JButton("退出");
        btnNewButton_1_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                exitButton(e);
            }
        });
        btnNewButton_1_1.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        btnNewButton_1_1.setBounds(285, 219, 97, 23);
        contentPane.add(btnNewButton_1_1);
    }

    protected void confirmButton(ActionEvent e) throws SQLException {
        // TODO 自动生成的方法存根
        TeacherDao teacherDao = new TeacherDao();
        String TeacherName = this.TeacherName.getText();
        String TeachCourseName = this.ChangeTeacherCourse.getText();
        int TeachCourseID = Integer.parseInt(this.ChangeTeachID.getText());
        String TeacherPassword = this.ChangeTeacherPassword.getText();
        String result = teacherDao.reviseTeacherInfo(TeacherName,TeachCourseName,TeachCourseID,TeacherPassword);
        JOptionPane.showMessageDialog(this,result);
        this.resetButton(e);
    }

    protected void resetButton(ActionEvent e) {
        // TODO 自动生成的方法存根
        this.ChangeTeacherCourse.setText("");
        this.TeacherName.setText("");
        this.ChangeTeacherPassword.setText("");
        this.ChangeTeachID.setText("");
    }

    protected void exitButton(ActionEvent e) {
        // TODO 自动生成的方法存根
        this.dispose();
    }

}
