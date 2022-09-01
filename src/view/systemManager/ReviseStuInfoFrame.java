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

public class ReviseStuInfoFrame extends JFrame {

    private JPanel contentPane;
    private JTextField ChangeStuSex;
    private JTextField ChangeStuAge;
    private JTextField ChangeStuDept;
    private JTextField ChangeStuPassword;
    private JTextField Changewho;


    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ReviseStuInfoFrame frame = new ReviseStuInfoFrame();
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
    public ReviseStuInfoFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 339);
        setLocationRelativeTo(null);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("修改学生信息");
        lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        lblNewLabel.setBounds(136, 10, 144, 28);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_1_1_1 = new JLabel("  性  别：");
        lblNewLabel_1_1_1.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        lblNewLabel_1_1_1.setBounds(100, 95, 81, 15);
        contentPane.add(lblNewLabel_1_1_1);

        ChangeStuSex = new JTextField();
        ChangeStuSex.setBounds(179, 93, 113, 24);
        contentPane.add(ChangeStuSex);

        JLabel lblNewLabel_1_1_1_1 = new JLabel("  年  龄：");
        lblNewLabel_1_1_1_1.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        lblNewLabel_1_1_1_1.setBounds(100, 138, 81, 15);
        contentPane.add(lblNewLabel_1_1_1_1);

        ChangeStuAge = new JTextField();
        ChangeStuAge.setBounds(179, 136, 113, 24);
        contentPane.add(ChangeStuAge);

        JLabel lblNewLabel_1_1_1_1_1 = new JLabel("  专  业：");
        lblNewLabel_1_1_1_1_1.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        lblNewLabel_1_1_1_1_1.setBounds(100, 180, 81, 15);
        contentPane.add(lblNewLabel_1_1_1_1_1);

        ChangeStuDept = new JTextField();
        ChangeStuDept.setBounds(179, 178, 113, 24);
        contentPane.add(ChangeStuDept);

        JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("  密  码：");
        lblNewLabel_1_1_1_1_1_1.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        lblNewLabel_1_1_1_1_1_1.setBounds(100, 218, 81, 15);
        contentPane.add(lblNewLabel_1_1_1_1_1_1);

        ChangeStuPassword = new JTextField();
        ChangeStuPassword.setBounds(179, 212, 113, 24);
        contentPane.add(ChangeStuPassword);

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
        btnNewButton.setBounds(30, 260, 97, 23);
        contentPane.add(btnNewButton);

        JButton btnNewButton_1 = new JButton("重置");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resetButton(e);
            }
        });
        btnNewButton_1.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        btnNewButton_1.setBounds(155, 260, 97, 23);
        contentPane.add(btnNewButton_1);

        JButton btnNewButton_1_1 = new JButton("退出");
        btnNewButton_1_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                exitButton(e);
            }
        });
        btnNewButton_1_1.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        btnNewButton_1_1.setBounds(277, 260, 97, 23);
        contentPane.add(btnNewButton_1_1);

        JLabel lblNewLabel_1_2 = new JLabel("请输入修改学生姓名：");
        lblNewLabel_1_2.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        lblNewLabel_1_2.setBounds(9, 59, 172, 15);
        contentPane.add(lblNewLabel_1_2);

        Changewho = new JTextField();
        Changewho.setBounds(175, 57, 113, 24);
        contentPane.add(Changewho);

        JLabel lblNewLabel_2 = new JLabel("修改后：");
        lblNewLabel_2.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        lblNewLabel_2.setBounds(30, 95, 67, 15);
        contentPane.add(lblNewLabel_2);
    }

    protected void confirmButton(ActionEvent e) throws SQLException {
        // TODO 自动生成的方法存根
        StudentDao studentDao = new StudentDao();
        String ChangeWho = this.Changewho.getText();
        String StuSex = this.ChangeStuSex.getText();
        int StuAge = Integer.parseInt(this.ChangeStuAge.getText());
        String StuDept = this.ChangeStuDept.getText();
        String StuPassword = this.ChangeStuPassword.getText();
        String result = studentDao.reviseStuInfo(ChangeWho,StuSex,StuAge,StuDept,StuPassword);
        JOptionPane.showMessageDialog(this,result);
        this.resetButton(e);
    }

    protected void resetButton(ActionEvent e) {
        // TODO 自动生成的方法存根
        this.Changewho.setText("");
        //this.ChangeStuID.setText("");
        this.ChangeStuAge.setText("");
        this.ChangeStuDept.setText("");
        this.ChangeStuSex.setText("");
        this.ChangeStuPassword.setText("");
    }

    protected void exitButton(ActionEvent e) {
        // TODO 自动生成的方法存根
        this.setVisible(false);
    }
}
