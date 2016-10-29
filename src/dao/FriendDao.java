package dao;

import vo.Friend;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ZouKaifa on 2016/10/29.
 */
public class FriendDao extends Dao {

    /**
     * 通过结果集产生一个Friend对象
     * @param rs
     * @return
     */
    private Friend getFreind(ResultSet rs) {
        UserDao userDao = new UserDao();
        Friend friend = null;
        try {
            friend = new Friend();
            friend.setFriend(userDao.getUser(rs.getString("friend_name")));
            friend.getFriend().setPassword("");
            friend.setRemark(rs.getString("remark"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return friend;
    }

    /**
     * 通过用户名和好友名获得一个Friend对象
     * @param friendName
     * @return
     */
    public Friend getFriend(String username, String friendName) {
        Friend friend = null;
        try {
            String sql = "SELECT * FROM friend WHERE (username = ?) and (friend_name = ?)";
            ResultSet rs = executeQuery(sql, new Object[]{username, friendName});
            if (rs.next()) {
                friend = getFreind(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return friend;
    }


    /**
     * 通过用户名获得其好友list
     * @param username
     * @return
     */
    public List<Friend> getFriendList(String username) {
        List<Friend> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM friend WHERE username = ?";
            ResultSet rs = executeQuery(sql, new Object[]{username});
            while (rs.next()) {
                list.add(getFreind(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 为username添加好友
     * @param username
     * @param friend
     */
    public void addFriend(String username, Friend friend) {
        String sql = "INSERT INTO friend (username, friend_name, remark)" +
                "values (?, ?, ?)";
        Object[] params = {username, friend.getFriend().getUsername(),
                friend.getRemark()};
        execute(sql, params);
    }

    /**
     * 删除username的friend
     * @param username
     * @param friend
     */
    public void deleteFriend(String username, Friend friend) {
        String sql = "DELETE FROM friend WHERE (username = ?)" +
                "and (friend_name = ?)";
        execute(sql, new Object[]{username, friend.getFriend().getUsername()});
    }
}
