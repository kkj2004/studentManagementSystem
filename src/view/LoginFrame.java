package view;
import dao.AdminDao;
import dao.StudentDao;
import dao.TeacherDao;
import model.Admin;
import model.Student;
import model.Teacher;
import model.UserType;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/*
* Main界面
*
* */

public class LoginFrame extends JFrame {

    private JPanel contentPane;
    private JTextField adminName;
    private JPasswordField adminPassword;
    private JComboBox adminTypeComb;
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    LoginFrame frame = new LoginFrame();
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
    public LoginFrame() {
        setTitle("登陆界面");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        setLocationRelativeTo(null);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("学生信息管理系统");
        lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 30));
        lblNewLabel.setBounds(101, 10, 277, 54);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("用户名");
        lblNewLabel_1.setBounds(101, 90, 58, 25);
        contentPane.add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("密码");
        lblNewLabel_2.setBounds(101, 141, 58, 15);
        contentPane.add(lblNewLabel_2);

        JLabel lblNewLabel_3 = new JLabel("用户类别");
        lblNewLabel_3.setBounds(101, 191, 58, 15);
        contentPane.add(lblNewLabel_3);

        adminName = new JTextField();
        adminName.setBounds(169, 92, 139, 21);
        contentPane.add(adminName);
        adminName.setColumns(10);

        adminPassword = new JPasswordField();
        adminPassword.setBounds(169, 138, 139, 21);
        contentPane.add(adminPassword);
        adminPassword.setColumns(10);

        adminTypeComb = new JComboBox();
        adminTypeComb.setModel(new DefaultComboBoxModel(new UserType[]{UserType.ADMIN,UserType.STUDENT,UserType.TEACHER}));

        adminTypeComb.setBounds(169, 187, 139, 23);
        contentPane.add(adminTypeComb);

        JButton btnNewButton = new JButton("重置");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resetButton(e);
            }
        });
        btnNewButton.setBounds(251, 230, 97, 23);
        contentPane.add(btnNewButton);

        JButton btnNewButton_1 = new JButton("登录");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                confirmLoginButton(e);
            }
        });
        btnNewButton_1.setBounds(101, 230, 97, 23);
        contentPane.add(btnNewButton_1);
    }
    //确认登陆按钮
    protected void confirmLoginButton(ActionEvent e) {
        // TODO 自动生成的方法存根
        String name = this.adminName.getText();
        String password = this.adminPassword.getText();
        UserType userType = (UserType) this.adminTypeComb.getSelectedItem();
        if("系统管理员".equals(userType.getName())){
            AdminDao adminDao = new AdminDao();
            Admin admin = adminDao.selectAdmin(name,password);
//            System.out.println(admin);
            if(admin==null){
                JOptionPane.showMessageDialog(this,"用户名或密码错误！");
            }else{
                JOptionPane.showMessageDialog(this,"登陆成功！");
                IndexFrame indexFrame = new IndexFrame(userType,admin);
                indexFrame.setVisible(true);
                this.dispose();
            }
        }
        if("学生".equals(userType.getName())){
            StudentDao studentDao = new StudentDao();
            Student student =  studentDao.selectStudent(name,password);
            if(student==null){
                JOptionPane.showMessageDialog(this,"用户名或密码错误！");
            }else{
                JOptionPane.showMessageDialog(this,"登陆成功！");
                StudentFrame studentFrame = new StudentFrame(userType,student);
                studentFrame.setVisible(true);
                this.dispose();
            }
        }
        if("教师".equals(userType.getName())){
            TeacherDao teacherDao = new TeacherDao();
            Teacher teacher = teacherDao.selectTeacher(name,password);
            if(teacher==null){
                JOptionPane.showMessageDialog(this,"用户名或密码错误！");
            }else{
                JOptionPane.showMessageDialog(this,"登陆成功！");
                TeacherFrame teacherFrame = new TeacherFrame(userType,teacher);
                teacherFrame.setVisible(true);
                this.dispose();
            }
        }
    }
//    重置按钮，conbobox的默认是系统管理员
    private void resetButton(ActionEvent e) {
        this.adminName.setText("");
        this.adminPassword.setText("");
        this.adminTypeComb.setSelectedIndex(0);
    }
}

