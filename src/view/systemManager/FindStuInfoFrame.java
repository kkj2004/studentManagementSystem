package view.systemManager;

import dao.StudentDao;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

public class FindStuInfoFrame extends JFrame {

    private JPanel contentPane;
    private JTextField FindStuName;
    private JLabel lblNewLabel_1_1_1;
    private JLabel lblNewLabel_1_1_1_1;
    private JLabel lblNewLabel_1_1_1_2;
    private JLabel lblNewLabel_1_1_1_1_1;


    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FindStuInfoFrame frame = new FindStuInfoFrame();
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
    public FindStuInfoFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 355);
        setLocationRelativeTo(null);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("查询学生信息");
        lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        lblNewLabel.setBounds(127, 24, 147, 50);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("请输入查找的学生姓名：");
        lblNewLabel_1.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        lblNewLabel_1.setBounds(23, 97, 167, 15);
        contentPane.add(lblNewLabel_1);

        FindStuName = new JTextField();
        FindStuName.setBounds(181, 91, 118, 21);
        contentPane.add(FindStuName);
        FindStuName.setColumns(10);

        JLabel lblNewLabel_1_1 = new JLabel("学号：");
        lblNewLabel_1_1.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        lblNewLabel_1_1.setBounds(127, 136, 46, 15);
        contentPane.add(lblNewLabel_1_1);

        lblNewLabel_1_1_1 = new JLabel();
        lblNewLabel_1_1_1.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        lblNewLabel_1_1_1.setBounds(181, 136, 46, 15);
        contentPane.add(lblNewLabel_1_1_1);

        JLabel lblNewLabel_1_1_2 = new JLabel("性别：");
        lblNewLabel_1_1_2.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        lblNewLabel_1_1_2.setBounds(127, 169, 46, 15);
        contentPane.add(lblNewLabel_1_1_2);

        lblNewLabel_1_1_1_1 = new JLabel();
        lblNewLabel_1_1_1_1.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        lblNewLabel_1_1_1_1.setBounds(181, 171, 46, 15);
        contentPane.add(lblNewLabel_1_1_1_1);

        JLabel lblNewLabel_1_1_2_1 = new JLabel("年龄：");
        lblNewLabel_1_1_2_1.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        lblNewLabel_1_1_2_1.setBounds(127, 199, 46, 15);
        contentPane.add(lblNewLabel_1_1_2_1);

        lblNewLabel_1_1_1_2 = new JLabel();
        lblNewLabel_1_1_1_2.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        lblNewLabel_1_1_1_2.setBounds(181, 201, 46, 15);
        contentPane.add(lblNewLabel_1_1_1_2);

        JLabel lblNewLabel_1_1_2_1_1 = new JLabel("专业：");
        lblNewLabel_1_1_2_1_1.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        lblNewLabel_1_1_2_1_1.setBounds(127, 227, 46, 15);
        contentPane.add(lblNewLabel_1_1_2_1_1);

        lblNewLabel_1_1_1_1_1 = new JLabel();
        lblNewLabel_1_1_1_1_1.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        lblNewLabel_1_1_1_1_1.setBounds(180, 225, 150, 15);
        contentPane.add(lblNewLabel_1_1_1_1_1);

        JButton btnNewButton = new JButton("查询");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    findStuInfo(e);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        btnNewButton.setBounds(38, 262, 97, 23);
        contentPane.add(btnNewButton);

        JButton btnNewButton_1 = new JButton("重置");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resetButton(e);
            }
        });
        btnNewButton_1.setBounds(158, 262, 97, 23);
        contentPane.add(btnNewButton_1);

        JButton btnNewButton_1_1 = new JButton("退出");
        btnNewButton_1_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                exitButton(e);
            }
        });
        btnNewButton_1_1.setBounds(283, 262, 97, 23);
        contentPane.add(btnNewButton_1_1);
    }

    protected void findStuInfo(ActionEvent e) throws SQLException {
        // TODO 自动生成的方法存根
        StudentDao studentDao = new StudentDao();
        String name = this.FindStuName.getText();
        String StuID = studentDao.getId(name);
        String StuAge = studentDao.getAge(name);
        String StuSex = studentDao.getSex(name);
        String StuDept = studentDao.getDept(name);
        this.lblNewLabel_1_1_1.setText(StuID);
        this.lblNewLabel_1_1_1_1.setText(StuSex);
        this.lblNewLabel_1_1_1_1_1.setText(StuDept);
        this.lblNewLabel_1_1_1_2.setText(StuAge);


    }

    protected void resetButton(ActionEvent e) {
        // TODO 自动生成的方法存根
        this.FindStuName.setText("");
        this.lblNewLabel_1_1_1.setText("");
        this.lblNewLabel_1_1_1_1.setText("");
        this.lblNewLabel_1_1_1_1_1.setText("");
        this.lblNewLabel_1_1_1_2.setText("");
    }

    protected void exitButton(ActionEvent e) {
        // TODO 自动生成的方法存根
        this.setVisible(false);
    }
}
