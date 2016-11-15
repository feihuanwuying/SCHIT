package dao;

import util.TimeTransform;
import vo.Friend;
import vo.Inform;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ZouKaifa on 2016/11/14.
 */
public class InformDao extends Dao {
    private Inform getInform(ResultSet rs) {
        Inform inform = null;
        try {
            inform = new Inform();
            UserDao userDao = new UserDao();
            inform.setId(rs.getInt("id"));
            inform.setUser(userDao.getUser(rs.getInt("user_id")));
            inform.setInformType(rs.getInt("inform_type"));
            inform.setInformId(rs.getInt("inform_id"));
            Friend friend = new Friend();
            friend.setFriend(userDao.getUser(rs.getInt("friend_id")));
            friend.setRemark(rs.getString("friend_remark"));
            inform.setFriend(friend);
            inform.setFriendMessage(rs.getString("friend_message"));
            inform.setTime(TimeTransform.timeStampToDate(rs.getTimestamp("time")));
            inform.setTreatment(rs.getInt("treatment"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return inform;
    }

    private List<Inform> getInformList(ResultSet rs) {
        List<Inform> informList = new ArrayList<>();
        try {
            while (rs.next()) {
                informList.add(getInform(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return informList;
    }

    public List<Inform> getInformList(int informType, int userId, long pageNumber, int pageSize) {
        String sql = "SELECT * FROM inform WHERE (inform_type = ?) AND (user_id = ?) ORDER BY time DESC LIMIT ?, ?";
        ResultSet rs = executeQuery(sql, informType, userId, (pageNumber-1)*pageSize, pageSize);
        return getInformList(rs);
    }

    public void addInform(Inform inform) {
        String sql = "INSERT INTO inform (user_id, inform_type, " +
                "inform_id, friend_id, friend_message, friend_remark, " +
                "time, treatment) values(?, ?, ?, ?, ?, ?, ?, ?)";
        execute(sql, inform.getUser().getId(), inform.getInformType(),
                inform.getInformId(), inform.getFriend().getFriend().getId(),
                inform.getFriendMessage(), inform.getFriend().getRemark(),
                TimeTransform.dateTotimeStamp(inform.getTime()),
                inform.getTreatment());
    }

    public long getInformCount(int informType, int userId) {
        long count = 0;
        String sql = "SELECT count(*) FROM inform WHERE (inform_type = ?) AND (user_id = ?)";
        try {
            ResultSet rs = executeQuery(sql, informType, userId);
            if (rs.next()) {
                count = rs.getLong(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }
}
