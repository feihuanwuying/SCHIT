package dao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * 用于获得数据库的连接
 * Created by ZouKaifa on 2016/10/10.
 */
public class Dao {
    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/SCHIT", "root", "960331");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
