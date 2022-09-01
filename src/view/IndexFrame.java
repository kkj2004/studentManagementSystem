package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Admin;
import model.UserType;
import view.systemManager.*;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Font;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JDesktopPane;
import java.awt.Color;

public class IndexFrame extends JFrame {

    private JPanel contentPane;
    private JDesktopPane desktopPane;
    public static UserType userType;
    public static Admin admin;
    /**
     * Launch the application.
     */


    /**
     * Create the frame.
     */
    //管理员登陆后的界面
    public IndexFrame(UserType u,Admin a) {
        userType = u;
        admin = a;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1001, 701);
        setLocationRelativeTo(null);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu mnNewMenu = new JMenu("系统管理");
        mnNewMenu.setFont(new Font("微软雅黑", Font.BOLD, 15));
        menuBar.add(mnNewMenu);

        JMenuItem mntmNewMenuItem = new JMenuItem("修改密码");
        mntmNewMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                revisePassword(e);
            }
        });
        mntmNewMenuItem.setFont(new Font("微软雅黑", Font.BOLD, 14));
        mnNewMenu.add(mntmNewMenuItem);

        JMenuItem mntmNewMenuItem_1 = new JMenuItem("退出系统");
        mntmNewMenuItem_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
//                System.exit(0);
                exitButton(e);
            }
        });
        mntmNewMenuItem_1.setFont(new Font("微软雅黑", Font.BOLD, 14));
        mnNewMenu.add(mntmNewMenuItem_1);

        JMenu mnNewMenu_1 = new JMenu("教师管理");
        mnNewMenu_1.setFont(new Font("微软雅黑", Font.BOLD, 15));
        menuBar.add(mnNewMenu_1);

        JMenuItem mntmNewMenuItem_2 = new JMenuItem("增加教师");
        mntmNewMenuItem_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addNewTeacher(e);
            }
        });
        mntmNewMenuItem_2.setFont(new Font("微软雅黑", Font.BOLD, 14));
        mnNewMenu_1.add(mntmNewMenuItem_2);

        JMenuItem mntmNewMenuItem_1_1 = new JMenuItem("删除教师");
        mntmNewMenuItem_1_1.setFont(new Font("微软雅黑", Font.BOLD, 14));
        mnNewMenu_1.add(mntmNewMenuItem_1_1);

        JMenuItem mntmNewMenuItem_1_1_1 = new JMenuItem("修改教师");
        mntmNewMenuItem_1_1_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                reviseTeacher(e);
            }
        });
        mntmNewMenuItem_1_1_1.setFont(new Font("微软雅黑", Font.BOLD, 14));
        mnNewMenu_1.add(mntmNewMenuItem_1_1_1);

        JMenuItem mntmNewMenuItem_1_1_2 = new JMenuItem("查询教师");
        mntmNewMenuItem_1_1_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                findTeacher(e);
            }
        });
        mntmNewMenuItem_1_1_2.setFont(new Font("微软雅黑", Font.BOLD, 14));
        mnNewMenu_1.add(mntmNewMenuItem_1_1_2);

        JMenu mnNewMenu_2 = new JMenu("学生管理");
        mnNewMenu_2.setFont(new Font("微软雅黑", Font.BOLD, 15));
        menuBar.add(mnNewMenu_2);

        JMenuItem mntmNewMenuItem_3 = new JMenuItem("增加学生");
        mntmNewMenuItem_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addNewStu(e);
            }
        });
        mntmNewMenuItem_3.setFont(new Font("微软雅黑", Font.BOLD, 14));
        mnNewMenu_2.add(mntmNewMenuItem_3);

        JMenuItem mntmNewMenuItem_1_2 = new JMenuItem("删除学生");
        mntmNewMenuItem_1_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deleteTeacher(e);
            }
        });
        mntmNewMenuItem_1_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deleteStu(e);
            }
        });
        mntmNewMenuItem_1_2.setFont(new Font("微软雅黑", Font.BOLD, 14));
        mnNewMenu_2.add(mntmNewMenuItem_1_2);

        JMenuItem mntmNewMenuItem_1_2_1 = new JMenuItem("修改学生");
        mntmNewMenuItem_1_2_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                changeStuInfo(e);
            }
        });
        mntmNewMenuItem_1_2_1.setFont(new Font("微软雅黑", Font.BOLD, 14));
        mnNewMenu_2.add(mntmNewMenuItem_1_2_1);

        JMenuItem mntmNewMenuItem_1_2_2 = new JMenuItem("查询学生");
        mntmNewMenuItem_1_2_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                findStuInfo(e);
            }
        });
        mntmNewMenuItem_1_2_2.setFont(new Font("微软雅黑", Font.BOLD, 14));
        mnNewMenu_2.add(mntmNewMenuItem_1_2_2);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        desktopPane = new JDesktopPane();
        desktopPane.setBackground(new Color(95, 158, 160));
        contentPane.add(desktopPane, BorderLayout.CENTER);
    }

    private void exitButton(ActionEvent e) {
        this.setVisible(false);
        LoginFrame loginFrame = new LoginFrame();
        loginFrame.setVisible(true);
    }

    protected void addNewTeacher(ActionEvent e) {
        // TODO 自动生成的方法存根
        AddTeacherFrame addTeacherFrame = new AddTeacherFrame();
        addTeacherFrame.setVisible(true);
    }

    protected void deleteTeacher(ActionEvent e) {
        // TODO 自动生成的方法存根
        DeleteTeacherInfoFrame deleteTeacherInfoFrame = new DeleteTeacherInfoFrame();
        deleteTeacherInfoFrame.setVisible(true);
    }

    protected void reviseTeacher(ActionEvent e) {
        // TODO 自动生成的方法存根
        ReviseTeacherInfoFrame reviseTeacherInfoFrame = new ReviseTeacherInfoFrame();
        reviseTeacherInfoFrame.setVisible(true);
    }

    protected void findTeacher(ActionEvent e) {
        // TODO 自动生成的方法存根
        FindTeacherInfoFrame findTeacherInfoFrame = new FindTeacherInfoFrame();
        findTeacherInfoFrame.setVisible(true);
    }

//    增加学生
    protected void addNewStu(ActionEvent e) {
        // TODO 自动生成的方法存根
        AddStudentFrame addStudentFrame = new AddStudentFrame();
        addStudentFrame.setVisible(true);
    }

    protected void deleteStu(ActionEvent e) {
        // TODO 自动生成的方法存根
        DeleteStuInfoFrame deleteStuInfoFrame = new DeleteStuInfoFrame();
        deleteStuInfoFrame.setVisible(true);
    }
    protected void changeStuInfo(ActionEvent e) {
        // TODO 自动生成的方法存根
        ReviseStuInfoFrame reviseStuInfoFrame = new ReviseStuInfoFrame();
        reviseStuInfoFrame.setVisible(true);
    }
    protected void findStuInfo(ActionEvent e) {
        // TODO 自动生成的方法存根
        FindStuInfoFrame findStuInfoFrame = new FindStuInfoFrame();
        findStuInfoFrame.setVisible(true);
    }
    //管理员修改密码
    private void revisePassword(ActionEvent e) {
        desktopPane.add(new RevisePassword());
    }

}
