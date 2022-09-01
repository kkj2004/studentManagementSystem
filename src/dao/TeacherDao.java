package dao;

import model.Student;
import model.Teacher;
import view.IndexFrame;
import view.TeacherFrame;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static view.TeacherFrame.teacher;
//关于教师的有关方法
public class TeacherDao extends BaseDao{
    //登陆界面选择身份
    public Teacher selectTeacher(String name, String password){
        String sqlStr = "select * from teacherLogin where name = ? and password = ?";
        Teacher teacher = null;
        try{
            this.pStatement = this.con.prepareStatement(sqlStr);
            this.pStatement.setString(1,name);
            this.pStatement.setString(2,password);

            ResultSet executeQuery = this.pStatement.executeQuery();
            if(executeQuery.next()){
                teacher = new Teacher(executeQuery.getInt(1),executeQuery.getString(2),executeQuery.getString(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            this.close();
        }
        return teacher;
    }
    //教师修改密码
    public  String revisePassword(String name, String newPassword){
        String resultStr = "操作失败";
        String sqlStr = "update teacherLogin set password = ? where name = ? and password = ?";
        try{
            this.pStatement = this.con.prepareStatement(sqlStr);
            this.pStatement.setString(1,newPassword);
            this.pStatement.setString(2,teacher.getName());
            this.pStatement.setString(3, teacher.getPassword());
            if(pStatement.executeUpdate()>0){
                resultStr = "操作成功！";
                TeacherFrame.teacher.setPassword(newPassword);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            this.close();
        }
        return resultStr;
    }
    public String getTeachCourse(String name) throws SQLException {
        String resultTeachCourse = null;
        String sqlStr = "select teachCourseName from teacher where name = ?";
        PreparedStatement preparedStatement = this.con.prepareStatement(sqlStr);
        preparedStatement.setString(1,name);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            resultTeachCourse = resultSet.getString("teachCourseName");
        }
        return resultTeachCourse;
    }

    public String getTeachCourseID(String name) throws SQLException {
        String resultTeachCourseID = null;
        String sqlStr = "select teachCourseId from teacher where name = ?";
        PreparedStatement preparedStatement = this.con.prepareStatement(sqlStr);
        preparedStatement.setString(1,name);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            resultTeachCourseID = resultSet.getString("teachCourseId");
        }
        return resultTeachCourseID;
    }

    public String SetStudentGrade(String stuName,String courseName,int grade) throws SQLException {
        String resultStr = "录入失败";
        String sqlStr = "update chooseCourse set grade=? where studentName = ? and courseName = ?";
        PreparedStatement preparedStatement = this.con.prepareStatement(sqlStr);
        preparedStatement.setInt(1,grade);
        preparedStatement.setString(2,stuName);
        preparedStatement.setString(3,courseName);
        if(preparedStatement.executeUpdate()>=1){
            resultStr = "录入成功";
        }
        return resultStr;
    }

    public String FindStuGrade(String stuName,String courseName) throws SQLException {
        String resultStr = null;
        String sqlStr = "select grade from chooseCourse where studentName = ? and courseName = ? ";
        PreparedStatement preparedStatement = this.con.prepareStatement(sqlStr);
        preparedStatement.setString(1,stuName);
        preparedStatement.setString(2,courseName);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            resultStr = resultSet.getString("grade");
        }
        System.out.println(stuName+" "+courseName);
        //System.out.println(resultStr);
        return resultStr;
    }

    public String ChangeStuGrade(String stuName,String courseName,int changeGrade) throws SQLException {
        String resultStr = null;
        String sqlStr = "update chooseCourse set grade = ? where studentName = ? and courseName = ?";
        PreparedStatement preparedStatement = this.con.prepareStatement(sqlStr);
        preparedStatement.setInt(1,changeGrade);
        preparedStatement.setString(2,stuName);
        preparedStatement.setString(3,courseName);
        if(preparedStatement.executeUpdate()>=1){
            resultStr = "修改成功";
        }
        return resultStr;
    }

    public String AddTeacher(int TeacherID,String TeacherName,String TeacherPassword,String TeachCourseName) throws SQLException {
        String resultStr = "操作失败";
        String sqlSte1 = "insert into teacherLogin values (?,?,?)";
        PreparedStatement preparedStatement = this.con.prepareStatement(sqlSte1);
        preparedStatement.setInt(1,TeacherID);
        preparedStatement.setString(2,TeacherName);
        preparedStatement.setString(3,TeacherPassword);
        if(preparedStatement.executeUpdate()>=1){
            String sqlStr2 = "insert into teacher values(?,?,?)";
            int TeachCourseID = 0;
            String sqlStr3 = "select id from course where name = ?";
            PreparedStatement preparedStatement2 = this.con.prepareStatement(sqlStr3);
            preparedStatement2.setString(1,TeachCourseName);
            ResultSet resultSet = preparedStatement2.executeQuery();
            while(resultSet.next()){
                TeachCourseID = resultSet.getInt("id");
            }
            PreparedStatement preparedStatement1 = this.con.prepareStatement(sqlStr2);
            preparedStatement1.setString(1,TeacherName);
            preparedStatement1.setString(2,TeachCourseName);
            preparedStatement1.setInt(3,TeachCourseID);
            if(preparedStatement1.executeUpdate()>=1){
                resultStr = "操作成功！";
            }
        }
        return resultStr;
    }

    public String DeleteTeacher(String TeacherName,String TeacherID) throws SQLException {
        String resultStr = "删除失败！";
        String sqlStr1 = "delete from teacher where name = ? ";
        PreparedStatement preparedStatement1 = this.con.prepareStatement(sqlStr1);
        preparedStatement1.setString(1,TeacherName);
        if(preparedStatement1.executeUpdate()>=0){
            String sqlStr2 = "delete from teacherLogin where name = ? and id = ?";
            PreparedStatement preparedStatement2 = this.con.prepareStatement(sqlStr2);
            preparedStatement2.setString(1,TeacherName);
            preparedStatement2.setString(2,TeacherID);
            if(preparedStatement2.executeUpdate()>=1){
                resultStr = "删除成功！";
            }
        }
        return resultStr;
    }

    public String reviseTeacherInfo(String TeacherName,String TeachCourseName,int TeachCourseID,String TeacherPassword) throws SQLException {
        String resultStr = "修改失败！";
        String sqlStr1 = "update teacher set teachCourseName = ? ,teachCourseId = ? where name = ?";
        PreparedStatement preparedStatement1 = this.con.prepareStatement(sqlStr1);
        preparedStatement1.setString(1,TeachCourseName);
        preparedStatement1.setInt(2,TeachCourseID);
        preparedStatement1.setString(3,TeacherName);
        if(preparedStatement1.executeUpdate()>=1){
            String sqlStr2 = "update teacherLogin set password = ? where name = ?";
            PreparedStatement preparedStatement2 = this.con.prepareStatement(sqlStr2);
            preparedStatement2.setString(1,TeacherPassword);
            preparedStatement2.setString(2,TeacherName);
            if(preparedStatement2.executeUpdate()>=1){
                resultStr = "修改成功！";
            }
        }
        return resultStr;
    }

    public String getId(String name) throws SQLException {
        String resultStr = null;
        String sqlStr = "select id from teacherLogin where name = ? ";
        PreparedStatement preparedStatement = this.con.prepareStatement(sqlStr);
        preparedStatement.setString(1,name);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            resultStr = resultSet.getString("id");
        }
        System.out.println(resultStr);
        return resultStr;
    }

    public String getCourseName(String name) throws SQLException {
        String resultName = null;
        String sqlStr = "select teachCourseName from teacher where name = ?";
        PreparedStatement preparedStatement = this.con.prepareStatement(sqlStr);
        preparedStatement.setString(1,name);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            resultName = resultSet.getString("teachCourseName");
        }
        return resultName;
    }

    public String getCourseID(String name) throws SQLException {
        String resultID = null;
        String sqlStr = "select teachCourseId from teacher where name = ?";
        PreparedStatement preparedStatement = this.con.prepareStatement(sqlStr);
        preparedStatement.setString(1,name);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            resultID = resultSet.getString("teachCourseId");
        }
        return resultID;
    }

}
