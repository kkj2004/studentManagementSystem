package view.systemManager;

import dao.TeacherDao;

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

public class FindTeacherInfoFrame extends JFrame {

    private JPanel contentPane;
    private JTextField TeacherName;
    private JLabel TeacherID;
    private JLabel TeachCourseName;
    private JLabel TeachCourseID;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FindTeacherInfoFrame frame = new FindTeacherInfoFrame();
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
    public FindTeacherInfoFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        setLocationRelativeTo(null);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("查询学生信息");
        lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        lblNewLabel.setBounds(130, 10, 147, 50);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("请输入查找的教师姓名：");
        lblNewLabel_1.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        lblNewLabel_1.setBounds(26, 78, 167, 15);
        contentPane.add(lblNewLabel_1);

        TeacherName = new JTextField();
        TeacherName.setColumns(10);
        TeacherName.setBounds(190, 70, 118, 21);
        contentPane.add(TeacherName);

        JLabel lblNewLabel_1_1 = new JLabel("教师编号：");
        lblNewLabel_1_1.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        lblNewLabel_1_1.setBounds(100, 114, 76, 15);
        contentPane.add(lblNewLabel_1_1);

        JLabel lblNewLabel_1_1_1 = new JLabel("授课名称：");
        lblNewLabel_1_1_1.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        lblNewLabel_1_1_1.setBounds(100, 152, 76, 15);
        contentPane.add(lblNewLabel_1_1_1);

        JLabel lblNewLabel_1_1_2 = new JLabel("授课编号：");
        lblNewLabel_1_1_2.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        lblNewLabel_1_1_2.setBounds(100, 188, 76, 15);
        contentPane.add(lblNewLabel_1_1_2);

        JButton btnNewButton = new JButton("查询");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    find(e);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        btnNewButton.setBounds(26, 230, 97, 23);
        contentPane.add(btnNewButton);

        JButton btnNewButton_1 = new JButton("重置");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resetButton(e);
            }
        });
        btnNewButton_1.setBounds(158, 230, 97, 23);
        contentPane.add(btnNewButton_1);

        JButton btnNewButton_1_1 = new JButton("退出");
        btnNewButton_1_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                exitButton(e);
            }
        });
        btnNewButton_1_1.setBounds(291, 230, 97, 23);
        contentPane.add(btnNewButton_1_1);

        TeacherID = new JLabel();
        TeacherID.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        TeacherID.setBounds(190, 116, 118, 15);
        contentPane.add(TeacherID);

        TeachCourseName = new JLabel();
        TeachCourseName.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        TeachCourseName.setBounds(190, 154, 118, 15);
        contentPane.add(TeachCourseName);

        TeachCourseID = new JLabel();
        TeachCourseID.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        TeachCourseID.setBounds(190, 190, 118, 15);
        contentPane.add(TeachCourseID);
    }

    protected void find(ActionEvent e) throws SQLException {
        // TODO 自动生成的方法存根
        TeacherDao teacherDao = new TeacherDao();
        String TeacherName = this.TeacherName.getText();
        this.TeacherID.setText(teacherDao.getId(TeacherName));
        this.TeachCourseID.setText(teacherDao.getTeachCourseID(TeacherName));
        this.TeachCourseName.setText(teacherDao.getTeachCourse(TeacherName));
    }

    protected void resetButton(ActionEvent e) {
        // TODO 自动生成的方法存根
        this.TeacherName.setText("");
        this.TeachCourseID.setText("");
        this.TeachCourseName.setText("");
        this.TeacherID.setText("");
    }

    protected void exitButton(ActionEvent e) {
        // TODO 自动生成的方法存根
        this.dispose();
    }

}
