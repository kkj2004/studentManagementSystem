package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//连接数据库&加载jdbc驱动
public class DBUtil {
    private static String jdbcDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    public static Connection getConnection(){
        Connection dbConnection = null;
        try{
            Class.forName(jdbcDriver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try{
            //dbConnection = DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;DatabaseName=studentManagementSystem","sa","123456");
            dbConnection = DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;DatabaseName=studentManagementSystem","sa","123456");
            //System.out.println("数据库连接成功");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dbConnection;
    }
}