package dao;

import model.Admin;
import view.IndexFrame;

import java.sql.ResultSet;
import java.sql.SQLException;

import static view.IndexFrame.admin;
//管理员的方法
public class AdminDao extends BaseDao{
    //登陆界面选择身份为管理员
    public Admin selectAdmin(String name, String password){
        String sqlStr = "select * from adminLogin where name = ? and password = ?";
        Admin admin = null;
        try{
            this.pStatement = this.con.prepareStatement(sqlStr);
            this.pStatement.setString(1,name);
            this.pStatement.setString(2,password);

            ResultSet executeQuery = this.pStatement.executeQuery();
            if(executeQuery.next()){
                admin = new Admin(executeQuery.getInt(1),executeQuery.getString(2),executeQuery.getString(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            this.close();
        }
        return admin;
    }
    //管理员修改密码
    public String revisePassword(String name,String newPassword){
        String resultStr = "操作失败";
        String sqlStr = "update adminLogin set password = ? where name = ? and password = ?";
        try{
            this.pStatement = this.con.prepareStatement(sqlStr);
            this.pStatement.setString(1,newPassword);
            this.pStatement.setString(2,admin.getName());
            this.pStatement.setString(3, admin.getPassword());
            if(pStatement.executeUpdate()>0){
                resultStr = "操作成功！";
                IndexFrame.admin.setPassword(newPassword);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            this.close();
        }
        return resultStr;
    }
}