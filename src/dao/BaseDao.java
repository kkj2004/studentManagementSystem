package dao;

import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
//Base类，连接到数据库
public abstract class BaseDao {
    protected Connection con = DBUtil.getConnection();
    protected PreparedStatement pStatement = null;
    protected void close(){
        try{
            this.con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}