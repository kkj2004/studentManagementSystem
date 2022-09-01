package view.Student;

import dao.StudentDao;
import view.StudentFrame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

public class FindGradeFrame extends JFrame {

    private JPanel contentPane;
    private JTextField FindCourseName;
    private JLabel lblNewLabel_2;
    private JButton btnNewButton_1;
    private JButton btnNewButton_2;
    private JTextField textField;
    //private String grade = null;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FindGradeFrame frame = new FindGradeFrame();
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
    public FindGradeFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        setLocationRelativeTo(null);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("请输入查询的科目：");
        lblNewLabel.setFont(new Font("微软雅黑", Font.BOLD, 15));
        lblNewLabel.setBounds(59, 80, 155, 29);
        contentPane.add(lblNewLabel);

        FindCourseName = new JTextField();
        FindCourseName.setFont(new Font("微软雅黑", Font.BOLD, 14));
        FindCourseName.setBounds(193, 83, 159, 21);
        contentPane.add(FindCourseName);
        FindCourseName.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("您的成绩为：");
        lblNewLabel_1.setFont(new Font("微软雅黑", Font.BOLD, 15));
        lblNewLabel_1.setBounds(87, 145, 98, 29);
        contentPane.add(lblNewLabel_1);

//        lblNewLabel_2 = new JLabel("a");
//        lblNewLabel_2.setFont(new Font("微软雅黑", Font.BOLD, 15));
//        lblNewLabel_2.setBounds(193, 145, 98, 29);
//        contentPane.add(lblNewLabel_2);
        textField = new JTextField();
        textField.setFont(new Font("微软雅黑", Font.BOLD, 14));
        textField.setColumns(10);
        textField.setBounds(193, 151, 159, 21);
        contentPane.add(textField);

        JButton btnNewButton = new JButton("查询");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    findCourse(e);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        btnNewButton.setBounds(36, 209, 97, 23);
        contentPane.add(btnNewButton);

        btnNewButton_1 = new JButton("关闭");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CloseButton(e);
            }
        });
        btnNewButton_1.setBounds(286, 209, 97, 23);
        contentPane.add(btnNewButton_1);

        btnNewButton_2 = new JButton("重置");
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resetButton(e);
            }
        });
        btnNewButton_2.setBounds(161, 209, 97, 23);
        contentPane.add(btnNewButton_2);
    }

//    protected void findCourse(ActionEvent e) throws SQLException {
//        // TODO 自动生成的方法存根
//        String courseName = this.FindCourseName.getText();
//        StudentDao studentDao = new StudentDao();
//        System.out.println(courseName+" "+StudentFrame.student.getName());
//        int grade = studentDao.FindGrade(StudentFrame.student.getName(),courseName);
//        System.out.println(grade);
////        this.lblNewLabel_2.setText(String.valueOf(grade));
//        //this.lblNewLabel_2.setText("aaa");
//        lblNewLabel_2 = new JLabel(String.valueOf(grade));
//        lblNewLabel_2.setFont(new Font("微软雅黑", Font.BOLD, 15));
//        lblNewLabel_2.setBounds(193, 145, 98, 29);
//        contentPane.add(lblNewLabel_2);
//        if(grade ==0 ){
//            JOptionPane.showMessageDialog(this,"你没选择这门课或暂时未出分！");
//        }
//        this.resetButton(e);
//    }
    private void findCourse(ActionEvent e) throws SQLException {
        String courseName = this.FindCourseName.getText();
        StudentDao studentDao = new StudentDao();
        String stuName = StudentFrame.student.getName();
        int grade = studentDao.FindGrade(stuName,courseName);
        System.out.println("  aaa");
        textField.setText(String.valueOf(grade));
        System.out.println("  aaa");

        if(grade ==0){
            JOptionPane.showMessageDialog(this,"你没选择这门课或暂时未出分！");
        }
    }

    protected void resetButton(ActionEvent e) {
        // TODO 自动生成的方法存根
        this.FindCourseName.setText("");
        this.textField.setText("");
    }

    protected void CloseButton(ActionEvent e) {
        // TODO 自动生成的方法存根
        this.dispose();
    }
}
