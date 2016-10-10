package Dao;

import Data.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 与数据库交互，获得user表的信息
 * Created by ZouKaifa on 2016/10/10.
 */
public class UserDao {
    private Connection con;

    /**
     * 通过用户名获得一个User对象
     *
     * @param username 要查询的用户名
     * @return 若该用户名存在，则返回对应的User对象，否则返回null
     */
    public User getUser(String username) {
        try {
            con = Dao.getConnection();
            Statement sta = con.createStatement();
            ResultSet rs = sta.executeQuery("SELECT * FROM user WHERE username = '" + username + "'");
            if (rs.next()) {
                User user = getUser(rs);
                con.close();
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 通过结果集获得一个User对象，该结果集必须已确认存在数据
     *
     * @param rs ResultSet结果集
     * @return 获得的User对象，出错则为null
     */
    private User getUser(ResultSet rs) {
        try {
            User user = new User();
            user.setUsername(rs.getString(1));
            user.setPassword(rs.getString(2));
            user.setNickname(rs.getString(3));
            user.setEmail(rs.getString(4));
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
