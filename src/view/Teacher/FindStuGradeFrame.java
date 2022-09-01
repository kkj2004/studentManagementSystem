package view.Teacher;

import dao.TeacherDao;
import view.TeacherFrame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

public class FindStuGradeFrame extends JFrame {

    private JPanel contentPane;
    private JTextField StuName;
    private JLabel StuGrade;
    private String grade = null;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FindStuGradeFrame frame = new FindStuGradeFrame();
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
    public FindStuGradeFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        setLocationRelativeTo(null);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("查询学生成绩");
        lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        lblNewLabel.setBounds(132, 40, 159, 31);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("学生姓名：");
        lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 15));
        lblNewLabel_1.setBounds(92, 101, 84, 31);
        contentPane.add(lblNewLabel_1);

        JLabel lblNewLabel_1_1 = new JLabel("学生成绩：");
        lblNewLabel_1_1.setFont(new Font("宋体", Font.PLAIN, 15));
        lblNewLabel_1_1.setBounds(92, 163, 84, 31);
        contentPane.add(lblNewLabel_1_1);

        StuName = new JTextField();
        StuName.setBounds(173, 106, 118, 21);
        contentPane.add(StuName);
        StuName.setColumns(10);

        StuGrade = new JLabel();
        StuGrade.setFont(new Font("宋体", Font.PLAIN, 15));
        StuGrade.setBounds(186, 163, 84, 31);
        contentPane.add(StuGrade);

        JButton btnNewButton = new JButton("查询");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    findStuGrade(e);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        btnNewButton.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        btnNewButton.setBounds(59, 211, 97, 23);
        contentPane.add(btnNewButton);

        JButton btnNewButton_1 = new JButton("重置");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resetButton(e);
            }
        });
        btnNewButton_1.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        btnNewButton_1.setBounds(173, 213, 97, 23);
        contentPane.add(btnNewButton_1);

        JButton btnNewButton_1_1 = new JButton("退出");
        btnNewButton_1_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                exitButton(e);
            }
        });
        btnNewButton_1_1.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        btnNewButton_1_1.setBounds(284, 213, 97, 23);
        contentPane.add(btnNewButton_1_1);
    }

    protected void findStuGrade(ActionEvent e) throws SQLException {
        // TODO 自动生成的方法存根
        TeacherDao teacherDao = new TeacherDao();
        String stuName = this.StuName.getText();
        String teacherName = TeacherFrame.teacher.getName();
        //String courseName = teacherDao.getTeachCourse(stuName);
        String courseName = teacherDao.getTeachCourse(teacherName);
        grade = teacherDao.FindStuGrade(stuName,courseName);
        //System.out.println(stuName+"courseName = "+courseName);
        this.StuGrade.setText(grade) ;
        if(grade==null){
            JOptionPane.showMessageDialog(this,"学生没选择这门课或暂时未出分！");
        }
        this.resetButton(e);
    }

    protected void resetButton(ActionEvent e) {
        // TODO 自动生成的方法存根
        this.StuName.setText("");
        this.StuGrade.setText("");
    }

    protected void exitButton(ActionEvent e) {
        // TODO 自动生成的方法存根
        this.setVisible(false);
    }

}
