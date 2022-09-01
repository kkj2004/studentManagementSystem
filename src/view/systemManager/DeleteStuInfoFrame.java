package view.systemManager;

import dao.StudentDao;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

public class DeleteStuInfoFrame extends JFrame {

    private JPanel contentPane;
    private JTextField DeleteStuName;
    private JTextField DeleteStuID;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    DeleteStuInfoFrame frame = new DeleteStuInfoFrame();
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
    public DeleteStuInfoFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        setLocationRelativeTo(null);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("删除学生");
        lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 30));
        lblNewLabel.setBounds(139, 37, 133, 57);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("删除学生姓名：");
        lblNewLabel_1.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        lblNewLabel_1.setBounds(97, 124, 114, 28);
        contentPane.add(lblNewLabel_1);

        JLabel lblNewLabel_1_1 = new JLabel("删除学生学号：");
        lblNewLabel_1_1.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        lblNewLabel_1_1.setBounds(97, 170, 114, 28);
        contentPane.add(lblNewLabel_1_1);

        DeleteStuName = new JTextField();
        DeleteStuName.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        DeleteStuName.setBounds(210, 130, 127, 21);
        contentPane.add(DeleteStuName);
        DeleteStuName.setColumns(10);

        DeleteStuID = new JTextField();
        DeleteStuID.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        DeleteStuID.setColumns(10);
        DeleteStuID.setBounds(210, 176, 127, 21);
        contentPane.add(DeleteStuID);

        JButton btnNewButton = new JButton("确认删除");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    deleteStu(e);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        btnNewButton.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        btnNewButton.setBounds(61, 219, 97, 23);
        contentPane.add(btnNewButton);

        JButton btnNewButton_1 = new JButton("重置");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resetButton(e);
            }
        });
        btnNewButton_1.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        btnNewButton_1.setBounds(191, 221, 97, 23);
        contentPane.add(btnNewButton_1);

        JButton btnNewButton_2 = new JButton("退出");
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                exitButton(e);
            }
        });
        btnNewButton_2.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        btnNewButton_2.setBounds(312, 221, 97, 23);
        contentPane.add(btnNewButton_2);
    }

    protected void deleteStu(ActionEvent e) throws SQLException {
        // TODO 自动生成的方法存根
        StudentDao studentDao = new StudentDao();
        String StuName = this.DeleteStuName.getText();
        int StuID = Integer.parseInt(this.DeleteStuID.getText());
        String result = studentDao.deleteStuInfo(StuName,StuID);
        JOptionPane.showMessageDialog(this,result);
        this.resetButton(e);
    }

    protected void resetButton(ActionEvent e) {
        // TODO 自动生成的方法存根
        this.DeleteStuID.setText("");
        this.DeleteStuName.setText("");
    }

    protected void exitButton(ActionEvent e) {
        // TODO 自动生成的方法存根
        this.setVisible(false);
    }

}
