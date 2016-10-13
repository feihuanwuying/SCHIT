package dao;

import vo.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 与数据库交互，获得user表的信息
 * Created by ZouKaifa on 2016/10/10.
 */
public class UserDao extends Dao{

    /**
     * 通过用户名获得一个User对象
     *
     * @param username 要查询的用户名
     * @return 若该用户存在，则返回对应的User对象，否则返回null
     */
    public User getUser(String username) {
        try {
            setCon();
            String sql = "SELECT * FROM user WHERE (username = ?)";
            ResultSet rs = getResultSet(sql, new Object[]{username});
            if (rs.next()) {
                User user = getUser(rs);
                con.close();
                return user;
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean exits(String username, String password) {
        try {
            setCon();
            String sql = "SELECT * FROM user WHERE (username = ?) AND (password = ?)";
            if (getResultSet(sql, new Object[]{username, password}).next()) {
                con.close();
                return true;
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
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
