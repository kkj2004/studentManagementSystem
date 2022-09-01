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

public class AddTeacherFrame extends JFrame {

    private JPanel contentPane;
    private JTextField NewTeacherName;
    private JTextField NewTeacherPassword;
    private JTextField NewTeacherCourseName;
    private JTextField NewTeacherID;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AddTeacherFrame frame = new AddTeacherFrame();
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
    public AddTeacherFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        setLocationRelativeTo(null);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("增加教师界面");
        lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        lblNewLabel.setBounds(118, 10, 148, 33);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("姓名：");
        lblNewLabel_1.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        lblNewLabel_1.setBounds(100, 103, 58, 15);
        contentPane.add(lblNewLabel_1);

        NewTeacherName = new JTextField();
        NewTeacherName.setBounds(157, 102, 138, 21);
        contentPane.add(NewTeacherName);
        NewTeacherName.setColumns(10);

        JLabel lblNewLabel_1_1 = new JLabel("密码：");
        lblNewLabel_1_1.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        lblNewLabel_1_1.setBounds(100, 138, 58, 15);
        contentPane.add(lblNewLabel_1_1);

        NewTeacherPassword = new JTextField();
        NewTeacherPassword.setColumns(10);
        NewTeacherPassword.setBounds(157, 137, 138, 21);
        contentPane.add(NewTeacherPassword);

        JLabel lblNewLabel_1_1_1 = new JLabel("授课名称：");
        lblNewLabel_1_1_1.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        lblNewLabel_1_1_1.setBounds(78, 177, 80, 15);
        contentPane.add(lblNewLabel_1_1_1);

        NewTeacherCourseName = new JTextField();
        NewTeacherCourseName.setColumns(10);
        NewTeacherCourseName.setBounds(157, 171, 138, 21);
        contentPane.add(NewTeacherCourseName);

        JButton btnNewButton = new JButton("增加");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    addTeacher(e);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        btnNewButton.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        btnNewButton.setBounds(60, 216, 97, 23);
        contentPane.add(btnNewButton);

        JButton btnNewButton_1 = new JButton("重置");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resetButton(e);
            }
        });
        btnNewButton_1.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        btnNewButton_1.setBounds(181, 218, 97, 23);
        contentPane.add(btnNewButton_1);

        JButton btnNewButton_2 = new JButton("退出");
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                exitButton(e);
            }
        });
        btnNewButton_2.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        btnNewButton_2.setBounds(295, 218, 97, 23);
        contentPane.add(btnNewButton_2);

        JLabel lblNewLabel_1_2 = new JLabel("教师编号：");
        lblNewLabel_1_2.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        lblNewLabel_1_2.setBounds(77, 70, 81, 15);
        contentPane.add(lblNewLabel_1_2);

        NewTeacherID = new JTextField();
        NewTeacherID.setColumns(10);
        NewTeacherID.setBounds(156, 65, 138, 21);
        contentPane.add(NewTeacherID);
    }

    protected void addTeacher(ActionEvent e) throws SQLException {
        // TODO 自动生成的方法存根
        TeacherDao teacherDao = new TeacherDao();
        int TeacherID = Integer.parseInt(this.NewTeacherID.getText());
        String TeacherName = this.NewTeacherName.getText();
        String TeacherPassword = this.NewTeacherPassword.getText();
        String TeachCourseName = this.NewTeacherCourseName.getText();
        String result = teacherDao.AddTeacher(TeacherID,TeacherName,TeacherPassword,TeachCourseName);
        JOptionPane.showMessageDialog(this,result);
        this.resetButton(e);
    }

    protected void resetButton(ActionEvent e) {
        // TODO 自动生成的方法存根
        this.NewTeacherCourseName.setText("");
        this.NewTeacherName.setText("");
        this.NewTeacherPassword.setText("");
        this.NewTeacherID.setText("");
    }

    protected void exitButton(ActionEvent e) {
        // TODO 自动生成的方法存根
        this.dispose();
    }

}
