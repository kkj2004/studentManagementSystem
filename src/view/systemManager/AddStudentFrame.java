package view.systemManager;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.StudentDao;
import util.StrUtil;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddStudentFrame extends JFrame {

    private JPanel contentPane;
    private JTextField NewAddStuName;
    private JTextField NewAddStuPassword;
    private JTextField NewAddStuID;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AddStudentFrame frame = new AddStudentFrame();
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
    //管理员界面关于学生的增加窗体
    public AddStudentFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        setLocationRelativeTo(null);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("姓名：");
        lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        lblNewLabel.setBounds(117, 150, 58, 15);
        contentPane.add(lblNewLabel);

        NewAddStuName = new JTextField();
        NewAddStuName.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        NewAddStuName.setBounds(160, 147, 127, 21);
        contentPane.add(NewAddStuName);
        NewAddStuName.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("登陆密码：");
        lblNewLabel_1.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        lblNewLabel_1.setBounds(90, 178, 81, 15);
        contentPane.add(lblNewLabel_1);

        NewAddStuPassword = new JTextField();
        NewAddStuPassword.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        NewAddStuPassword.setColumns(10);
        NewAddStuPassword.setBounds(160, 177, 127, 21);
        contentPane.add(NewAddStuPassword);

        JButton btnNewButton = new JButton("确认新增");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AddStuLogin(e);
            }
        });
        btnNewButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        btnNewButton.setBounds(44, 225, 97, 23);
        contentPane.add(btnNewButton);

        JButton btnNewButton_1 = new JButton("重置");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resetButton(e);
            }
        });
        btnNewButton_1.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        btnNewButton_1.setBounds(178, 225, 97, 23);
        contentPane.add(btnNewButton_1);

        JLabel lblNewLabel_2 = new JLabel("增加学生界面");
        lblNewLabel_2.setFont(new Font("微软雅黑", Font.PLAIN, 30));
        lblNewLabel_2.setBounds(112, 34, 185, 57);
        contentPane.add(lblNewLabel_2);

        JLabel lblNewLabel_3 = new JLabel("学号：");
        lblNewLabel_3.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        lblNewLabel_3.setBounds(117, 119, 58, 15);
        contentPane.add(lblNewLabel_3);

        NewAddStuID = new JTextField();
        NewAddStuID.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        NewAddStuID.setColumns(10);
        NewAddStuID.setBounds(160, 116, 127, 21);
        contentPane.add(NewAddStuID);

        JButton btnNewButton_1_1 = new JButton("退出");
        btnNewButton_1_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                exitButton(e);
            }
        });
        btnNewButton_1_1.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        btnNewButton_1_1.setBounds(299, 227, 97, 23);
        contentPane.add(btnNewButton_1_1);
    }
    protected void exitButton(ActionEvent e) {
        // TODO 自动生成的方法存根
        this.setVisible(false);
    }

    //增加学生信息
    protected void AddStuLogin(ActionEvent e) {
        // TODO 自动生成的方法存根
        String id = this.NewAddStuID.getText();
        String name = this.NewAddStuName.getText();
        String password = this.NewAddStuPassword.getText();
        if(StrUtil.isEmpty(id)) {
            JOptionPane.showMessageDialog(this,"学生的id不能为空哦！");
            return;
        }
        if(StrUtil.isEmpty(name)) {
            JOptionPane.showMessageDialog(this,"学生的姓名不能为空哦！");
            return;
        }
        if(StrUtil.isEmpty(password)) {
            JOptionPane.showMessageDialog(this,"学生的密码不能为空哦！");
            return;
        }
        StudentDao studentDao = new StudentDao();
        JOptionPane.showMessageDialog(this, studentDao.addStuLogin(id, name, password));
        this.resetButton(e);
    }
    //重置按钮
    protected void resetButton(ActionEvent e) {
        // TODO 自动生成的方法存根
        this.NewAddStuID.setText("");
        this.NewAddStuName.setText("");
        this.NewAddStuPassword.setText("");
    }
}
