package view.Teacher;

import dao.TeacherDao;
import view.TeacherFrame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

public class FindCourseInfoFrame extends JFrame {

    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FindCourseInfoFrame frame = new FindCourseInfoFrame();
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
    public FindCourseInfoFrame() throws SQLException {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        setLocationRelativeTo(null);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        TeacherDao teacherDao = new TeacherDao();
        String teacherName = TeacherFrame.teacher.getName();
        String TeachCourseName = teacherDao.getTeachCourse(teacherName);
        String TeachCourseID = teacherDao.getTeachCourseID(teacherName);

        JLabel lblNewLabel = new JLabel("授课信息");
        lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 21));
        lblNewLabel.setBounds(145, 27, 144, 34);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("教师姓名：");
        lblNewLabel_1.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        lblNewLabel_1.setBounds(92, 82, 96, 27);
        contentPane.add(lblNewLabel_1);

        JLabel lblNewLabel_1_1 = new JLabel("授课名称：");
        lblNewLabel_1_1.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        lblNewLabel_1_1.setBounds(92, 119, 96, 27);
        contentPane.add(lblNewLabel_1_1);

        JLabel lblNewLabel_1_2 = new JLabel("课程编号：");
        lblNewLabel_1_2.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        lblNewLabel_1_2.setBounds(92, 156, 96, 27);
        contentPane.add(lblNewLabel_1_2);

        JLabel lblNewLabel_2 = new JLabel(teacherName);
        lblNewLabel_2.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        lblNewLabel_2.setBounds(181, 90, 108, 15);
        contentPane.add(lblNewLabel_2);

        JLabel lblNewLabel_2_1 = new JLabel(TeachCourseName);
        lblNewLabel_2_1.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        lblNewLabel_2_1.setBounds(181, 127, 108, 15);
        contentPane.add(lblNewLabel_2_1);

        JLabel lblNewLabel_2_2 = new JLabel(TeachCourseID);
        lblNewLabel_2_2.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        lblNewLabel_2_2.setBounds(181, 164, 108, 15);
        contentPane.add(lblNewLabel_2_2);

        JButton btnNewButton = new JButton("关闭");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                closeButton(e);
            }
        });
        btnNewButton.setBounds(145, 209, 97, 23);
        contentPane.add(btnNewButton);
    }

    protected void closeButton(ActionEvent e) {
        // TODO 自动生成的方法存根
        this.setVisible(false);
    }
}
