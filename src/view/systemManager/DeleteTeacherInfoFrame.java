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

public class DeleteTeacherInfoFrame extends JFrame {

    private JPanel contentPane;
    private JTextField DeleteTeacherName;
    private JTextField DeleteTeacherID;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    DeleteTeacherInfoFrame frame = new DeleteTeacherInfoFrame();
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
    public DeleteTeacherInfoFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        setLocationRelativeTo(null);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("删除教师");
        lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 30));
        lblNewLabel.setBounds(137, 28, 133, 57);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("删除教师姓名：");
        lblNewLabel_1.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        lblNewLabel_1.setBounds(73, 116, 114, 28);
        contentPane.add(lblNewLabel_1);

        DeleteTeacherName = new JTextField();
        DeleteTeacherName.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        DeleteTeacherName.setColumns(10);
        DeleteTeacherName.setBounds(181, 122, 127, 21);
        contentPane.add(DeleteTeacherName);

        JLabel lblNewLabel_1_1 = new JLabel("删除教师编号：");
        lblNewLabel_1_1.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        lblNewLabel_1_1.setBounds(73, 166, 114, 28);
        contentPane.add(lblNewLabel_1_1);

        DeleteTeacherID = new JTextField();
        DeleteTeacherID.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        DeleteTeacherID.setColumns(10);
        DeleteTeacherID.setBounds(181, 172, 127, 21);
        contentPane.add(DeleteTeacherID);

        JButton btnNewButton = new JButton("确认删除");
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
        btnNewButton.setBounds(46, 219, 97, 23);
        contentPane.add(btnNewButton);

        JButton btnNewButton_1 = new JButton("重置");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resetButton(e);
            }
        });
        btnNewButton_1.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        btnNewButton_1.setBounds(183, 221, 97, 23);
        contentPane.add(btnNewButton_1);

        JButton btnNewButton_2 = new JButton("退出");
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                exitButton(e);
            }
        });
        btnNewButton_2.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        btnNewButton_2.setBounds(302, 221, 97, 23);
        contentPane.add(btnNewButton_2);
    }

    protected void confirmButton(ActionEvent e) throws SQLException {
        // TODO 自动生成的方法存根
        TeacherDao teacherDao = new TeacherDao();
        String TeacherName = this.DeleteTeacherName.getText();
        String TeacherID = this.DeleteTeacherID.getText();
        String result = teacherDao.DeleteTeacher(TeacherName,TeacherID);
        JOptionPane.showMessageDialog(this,result);
        this.resetButton(e);
    }

    protected void resetButton(ActionEvent e) {
        // TODO 自动生成的方法存根
        this.DeleteTeacherID.setText("");
        this.DeleteTeacherName.setText("");
    }

    protected void exitButton(ActionEvent e) {
        // TODO 自动生成的方法存根
        this.dispose();
    }

}
