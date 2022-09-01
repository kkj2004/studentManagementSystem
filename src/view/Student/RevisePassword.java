package view.Student;

import java.awt.EventQueue;

import javax.swing.*;
import java.awt.Font;
import java.awt.Color;

import dao.AdminDao;
import dao.StudentDao;
import dao.TeacherDao;
import util.StrUtil;
import view.IndexFrame;
import view.StudentFrame;
import view.TeacherFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RevisePassword extends JFrame {
    private JTextField oldPasswordText;
    private JTextField newPasswordText;
    private JTextField againPasswordText;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    RevisePassword frame = new RevisePassword();
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
    //学生的修改密码窗体
    public RevisePassword() {
        setBounds(100, 100, 450, 300);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);
        JLabel lblNewLabel = new JLabel("当前用户");
        lblNewLabel.setFont(new Font("微软雅黑", Font.BOLD, 14));
        lblNewLabel.setBounds(70, 29, 77, 25);
        getContentPane().add(lblNewLabel);

        String userTypeStr = StudentFrame.userType.getName();
        String studentNameStr = StudentFrame.student.getName();

        JLabel lbladmin = new JLabel("【"+userTypeStr+"】"+studentNameStr);
        lbladmin.setForeground(new Color(255, 0, 0));
        lbladmin.setFont(new Font("微软雅黑", Font.BOLD, 14));
        lbladmin.setBounds(157, 29, 156, 25);
        getContentPane().add(lbladmin);

        JLabel lblNewLabel_1 = new JLabel("旧密码：");
        lblNewLabel_1.setFont(new Font("微软雅黑", Font.BOLD, 14));
        lblNewLabel_1.setBounds(70, 82, 77, 25);
        getContentPane().add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("新密码：");
        lblNewLabel_2.setFont(new Font("微软雅黑", Font.BOLD, 14));
        lblNewLabel_2.setBounds(70, 136, 77, 25);
        getContentPane().add(lblNewLabel_2);

        JLabel lblNewLabel_3 = new JLabel("再次输入");
        lblNewLabel_3.setFont(new Font("微软雅黑", Font.BOLD, 14));
        lblNewLabel_3.setBounds(70, 185, 77, 25);
        getContentPane().add(lblNewLabel_3);

        oldPasswordText = new JTextField();
        oldPasswordText.setBounds(145, 86, 168, 21);
        getContentPane().add(oldPasswordText);
        oldPasswordText.setColumns(10);

        newPasswordText = new JTextField();
        newPasswordText.setColumns(10);
        newPasswordText.setBounds(145, 140, 168, 21);
        getContentPane().add(newPasswordText);

        againPasswordText = new JTextField();
        againPasswordText.setColumns(10);
        againPasswordText.setBounds(145, 189, 168, 21);
        getContentPane().add(againPasswordText);

        JButton btnNewButton = new JButton("确认修改");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                confirmButton(e);
            }
        });
        btnNewButton.setBounds(66, 238, 97, 23);
        getContentPane().add(btnNewButton);

        JButton btnNewButton_1 = new JButton("重置");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resetButton(e);
            }
        });
        btnNewButton_1.setBounds(218, 238, 97, 23);
        getContentPane().add(btnNewButton_1);

        setVisible(true);

    }
    //确认按钮
    protected void confirmButton(ActionEvent e) {
        // TODO 自动生成的方法存根
        String oldPassword = this.oldPasswordText.getText();
        String newPassword = this.newPasswordText.getText();
        String againPassword = this.againPasswordText.getText();
        if(StrUtil.isEmpty(oldPassword)){
            JOptionPane.showMessageDialog(this,"请输入原密码");
            return;
        }
        if(StrUtil.isEmpty(newPassword)){
            JOptionPane.showMessageDialog(this,"请输入新密码");
            return;
        }
        if(StrUtil.isEmpty(againPassword)){
            JOptionPane.showMessageDialog(this,"请再次输入新密码");
            return;
        }
        if("系统管理员".equals(StudentFrame.userType.getName())){
            AdminDao adminDao = new AdminDao();
            JOptionPane.showMessageDialog(this,adminDao.revisePassword(String.valueOf(IndexFrame.admin),newPassword));
            return;
        }
        if("学生".equals(StudentFrame.userType.getName())){
            StudentDao studentDao = new StudentDao();
            JOptionPane.showMessageDialog(this,studentDao.revisePassword(String.valueOf(StudentFrame.student),newPassword));
            resetButton(e);
            return;
        }
        if("教师".equals(StudentFrame.userType.getName())){
            TeacherDao teacherDao = new TeacherDao();
            JOptionPane.showMessageDialog(this,teacherDao.revisePassword(String.valueOf(TeacherFrame.teacher),newPassword));
            resetButton(e);
            return;
        }
    }
    //重置按钮
    protected void resetButton(ActionEvent e) {
        // TODO 自动生成的方法存根
        this.oldPasswordText.setText("");
        this.newPasswordText.setText("");
        this.againPasswordText.setText("");
    }

}
