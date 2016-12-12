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
            friend.setFriend(userDao.getUser(rs.getInt("friend_id")));
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
    public Friend getFriend(int userId, int friendId) {
        Friend friend = null;
        try {
            String sql = "SELECT * FROM friend WHERE (user_id = ?) and (friend_id = ?)";
            ResultSet rs = executeQuery(sql, userId, friendId);
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
    public List<Friend> getFriendList(int userId, long pageNumber, int pageSize) {
        List<Friend> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM friend WHERE user_id = ? LIMIT ?, ?";
            ResultSet rs = executeQuery(sql, userId, (pageNumber-1)*pageSize, pageSize);
            while (rs.next()) {
                list.add(getFreind(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Friend> getFriendList(int userId) {
        List<Friend> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM friend WHERE user_id = ?";
            ResultSet rs = executeQuery(sql, userId);
            while (rs.next()) {
                list.add(getFreind(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 获得某用户好友总数
     * @param username
     * @return
     */
    public long getFriendCount(int userId) {
        long count = 0;
        try {
            String sql = "SELECT count(*) FROM friend WHERE user_id = ?";
            ResultSet rs = executeQuery(sql, userId);
            if (rs.next()) {
                count = rs.getLong(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    /**
     * 为username添加好友
     * @param username
     * @param friend
     */
    public void addFriend(int userId, Friend friend) {
        String sql = "INSERT INTO friend (user_id, friend_id, remark)" +
                "values (?, ?, ?)";
        Object[] params = {userId, friend.getFriend().getId(),
                friend.getRemark()};
        execute(sql, params);
    }

    /**
     * 删除username的friend
     * @param username
     * @param friend
     */
    public void deleteFriend(int userId, Friend friend) {
        String sql = "DELETE FROM friend WHERE (user_id = ?)" +
                "and (friend_id = ?)";
        //双向删除
        execute(sql, userId, friend.getFriend().getId());
        execute(sql, friend.getFriend().getId(), userId);
    }

    /**
     * 更改备注
     * @param username
     * @param friendName
     * @param remark
     */
    public void updateRemark(int userId, int friendId, String remark) {
        String sql = "UPDATE friend SET remark = ? WHERE (user_id = ?) AND (friend_id = ?)";
        executeUpdate(sql, remark, userId, friendId);
    }
}
