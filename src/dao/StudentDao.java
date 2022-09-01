package dao;


import model.Student;
import view.IndexFrame;
import view.StudentFrame;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static view.StudentFrame.student;


public class StudentDao extends BaseDao{
    //LoginFrame登陆界面的筛选身份
    public Student selectStudent(String name, String password){
        String sqlStr = "select * from studentLogin where name = ? and password = ?";
//        String sqlStr = "select * from student where name = ? and password = ?";
        Student student = null;
        try{
            this.pStatement = this.con.prepareStatement(sqlStr);
            this.pStatement.setString(1,name);
            this.pStatement.setString(2,password);

            ResultSet executeQuery = this.pStatement.executeQuery();
            if(executeQuery.next()){
                student = new Student(executeQuery.getInt(1),executeQuery.getString(2),executeQuery.getString(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            this.close();
        }
        return student;
    }
    //学生登陆界面中的修改密码方法
    public String revisePassword(String name,String newPassword){
        String resultStr = "操作失败";
        String sqlStr = "update studentLogin set password = ? where name = ? and password = ?";
        //String sqlStr = "update student set password = ? where name = ? and password = ?";
        try{
            this.pStatement = this.con.prepareStatement(sqlStr);
            this.pStatement.setString(1,newPassword);
            this.pStatement.setString(2,student.getName());
            this.pStatement.setString(3, student.getPassword());
            //System.out.println(student.getPassword());
            if(pStatement.executeUpdate()>0){
                resultStr = "操作成功！";
                StudentFrame.student.setPassword(newPassword);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            this.close();
        }
        return resultStr;
    }
    //这是管理员登陆界面中对学生信息操作的增加学生账号密码的方法
    public String addStuLogin(String id,String name,String password) {
        String resultStr = "操作失败";
        String sqlStr = "insert into studentLogin values(?,?,?)";
//        String sqlStr = "insert into student values(?,?,?,null,null,null)";
        try {
            this.pStatement = this.con.prepareStatement(sqlStr);
            this.pStatement.setString(1, id);
            this.pStatement.setString(2, name);
            this.pStatement.setString(3, password);
            if(pStatement.executeUpdate()>0) {

                String sqlStr1 = "insert into student values(?,?,null,null,null)";
                PreparedStatement preparedStatement = this.con.prepareStatement(sqlStr1);
                preparedStatement.setInt(1, Integer.parseInt(id));
                preparedStatement.setString(2,name);
                if(preparedStatement.executeUpdate()>=1){
                    resultStr = "操作成功";
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            this.close();
        }
        return resultStr;
    }

    public String deleteStuInfo(String StuName,int StuID) throws SQLException {
        String resultStr = "删除失败！";
        String sqlStr1 = "delete from chooseCourse where studentName = ? and studentId = ?";
        PreparedStatement preparedStatement = this.con.prepareStatement(sqlStr1);
        preparedStatement.setString(1,StuName);
        preparedStatement.setInt(2,StuID);
        if(preparedStatement.executeUpdate()>=0){
            String sqlStr2 = "delete from student where name = ? and id = ?";
            PreparedStatement p = this.con.prepareStatement(sqlStr2);
            p.setString(1,StuName);
            p.setInt(2,StuID);
            if(p.executeUpdate()>=1){
                String sqlStr3 = "delete from studentLogin where name = ? and id = ?";
                PreparedStatement preparedStatement1 = this.con.prepareStatement(sqlStr3);
                preparedStatement1.setString(1,StuName);
                preparedStatement1.setInt(2,StuID);
                if(preparedStatement1.executeUpdate()>=1){
                    resultStr = "删除成功！";
                }
            }
        }
        return resultStr;
    }

//    public void findStuInfo(String name){
//        String sqlStr = ""
//    }

    public String reviseStuInfo(String ChangeWho,String StuSex,int StuAge,String StuDept,String StuPassword) throws SQLException {
        String resultStr = "修改失败！";
        String sqlStr = "update student set  sex = ? , age = ? , dept = ? where name = ?";

        PreparedStatement preparedStatement = this.con.prepareStatement(sqlStr);

        preparedStatement.setString(1,StuSex);
        preparedStatement.setInt(2,StuAge);
        preparedStatement.setString(3,StuDept);
        preparedStatement.setString(4,ChangeWho);
        if(preparedStatement.executeUpdate()>=0&&StuPassword==null){
            resultStr = "修改成功！";
        }
        if(StuPassword!=null){
            String sqlStr1 = "update studentLogin set password = ? where name = ?";
            PreparedStatement preparedStatement1 = this.con.prepareStatement(sqlStr1);
            preparedStatement1.setString(1,StuPassword);
            preparedStatement1.setString(2,ChangeWho);
            if(preparedStatement1.executeUpdate()>=1){
                resultStr = "修改成功！";
            }
        }
        return resultStr;
    }

    /*以下getXXX方法是在学生登陆界面中展示个人信息*/
    //获取id
    public String getId(String name) throws SQLException {
        String resultStr = null;
        String sqlStr = "select id from student where name = ? ";
        PreparedStatement preparedStatement = this.con.prepareStatement(sqlStr);
        preparedStatement.setString(1,name);
//        preparedStatement.setString(2,student.getPassword());
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            resultStr = resultSet.getString("id");
        }
        System.out.println(resultStr);
        return resultStr;
    }
    //获取dept
    public String getDept(String name) throws SQLException {
        String resultStr = null;
        String sqlStr = "select dept from student where name = ?";
        PreparedStatement preparedStatement = this.con.prepareStatement(sqlStr);
        preparedStatement.setString(1,name);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            resultStr = resultSet.getString("dept");
        }
        return resultStr;
    }
    //获取age
    public String getAge(String name) throws SQLException {
        String resultAge = null;
        String sqlStr = "select age from student where name = ?";
        PreparedStatement preparedStatement = this.con.prepareStatement(sqlStr);
        preparedStatement.setString(1,name);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            resultAge = resultSet.getString("age");
        }
        return resultAge;
    }
    //获取sex
    public String getSex(String name) throws SQLException {
        String resultSex = null;
        String sqlStr = "select sex from student where name = ?";
        PreparedStatement preparedStatement = this.con.prepareStatement(sqlStr);
        preparedStatement.setString(1,name);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            resultSex = resultSet.getString("sex");
        }
        return resultSex;
    }
    /*以上getXXX方法是在学生登陆界面中展示个人信息*/

    public int FindGrade(String studentName,String courseName) throws SQLException {
        String resultStr = null;
        int result = 0;
        String sqlStr = "select grade from chooseCourse where studentName = ? and courseName = ?";
        PreparedStatement preparedStatement = this.con.prepareStatement(sqlStr);
        preparedStatement.setString(1,studentName);
        preparedStatement.setString(2,courseName);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            resultStr = resultSet.getString("grade");
            result = resultSet.getInt("grade");
            //System.out.println(resultStr);
        }
        return result;
        //return resultStr;
    }

    public String ChooseCourse(String stuID,String stuName,String courseID , String courseName) throws SQLException {
        String resultStr = "选课失败";
        String sqlStr = "insert into chooseCourse values(?,?,?,?,null)";
        PreparedStatement preparedStatement = this.con.prepareStatement(sqlStr);
        preparedStatement.setString(1,stuID);
        preparedStatement.setString(2,stuName);
        preparedStatement.setString(3,courseID);
        preparedStatement.setString(4,courseName);
//        ResultSet resultSet = preparedStatement.executeQuery();
//        while(resultSet.next()){
//            resultStr = "选课成功";
//        }
        if(preparedStatement.executeUpdate()>=1){
            resultStr = "选课成功";
        }
        return resultStr;
    }

}
