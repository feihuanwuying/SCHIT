package dao;

import vo.Reply;
import vo.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

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
        User user = null;
        try {
            String sql = "SELECT * FROM user WHERE (username = ?)";
            ResultSet rs = executeQuery(sql, new Object[]{username});
            if (rs.next()) {
                user = getUser(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public User getUser(String username, String password) {
        User user = null;
        try {
            String sql = "SELECT * FROM user WHERE (username = ?) AND (password = ?)";
            ResultSet rs = executeQuery(sql, new Object[]{username, password});
            if (rs.next()) {
                user = getUser(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
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
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setNickname(rs.getString("nickname"));
            user.setEmail(rs.getString("email"));
            user.setPower(rs.getInt("power"));
            String head = rs.getString("head");
            user.setHead(rs.wasNull()?"":head);
            Date birthday = rs.getDate("birthday");
            user.setBirthday(rs.wasNull()?null:birthday);
            String realName = rs.getString("real_name");
            user.setRealName(rs.wasNull()?"":realName);
            user.setSex(rs.getInt("sex"));
            String qq = rs.getString("qq");
            user.setQq(rs.wasNull()?"":qq);
            String tel = rs.getString("tel");
            user.setTel(rs.wasNull()?"":tel);
            String selfIntro = rs.getString("self_introduction");
            user.setSelfIntro(rs.wasNull()?"":selfIntro);
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 更新一条数据
     * @param user user数据
     */
    public void updateUser(User user) {
        String sql = "UPDATE user SET password = ?, nickname = ?, email = ? WHERE username = ?";
        Object[] params = {user.getPassword(), user.getNickname(), user.getEmail(), user.getUsername()};
        executeUpdate(sql, params);
    }

    /**
     * 添加一条数据
     * @param user 要添加的数据
     */
    public void addUser(User user) {
        String sql = "INSERT INTO user (username, password, nickname, email)" +
                "values(?, ?, ?, ?)";
        Object[] params = {user.getUsername(), user.getPassword(), user.getNickname(), user.getEmail()};
        execute(sql, params);
    }


}
