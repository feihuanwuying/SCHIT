package Dao;

import Data.Friend;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * 获取friend表的数据
 * Created by ZouKaifa on 2016/10/10.
 */
public class FriendDao {
    private Connection con;

    /**
     * 根据用户名，获得该用户的好友列表
     *
     * @param username 用户名
     * @return 好友列表（Friend）
     */
    public List<Friend> getFriends(String username) {
        try {
            con = Dao.getConnection();
            Statement sta = con.createStatement();
            ResultSet rs = sta.executeQuery("SELECT * FROM friend WHERE username = '" + username + "'");
            List<Friend> list = new ArrayList<>();
            UserDao userDao = new UserDao();
            while (rs.next()) {
                Friend friend = new Friend();
                friend.setId(rs.getLong(1));
                friend.setUsername(rs.getString(2));
                friend.setFriend(userDao.getUser(rs.getString(3)));
                friend.setRemark(rs.getString(4));
                list.add(friend);
            }
            con.close();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
