package dao;

import util.TimeTransform;
import vo.Reply;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ZouKaifa on 2016/10/24.
 */
public class ReplyDao extends Dao {
    /**
     * 获得某个分区回复总数
     * @param type 分区类型
     * @return 回复总数
     */
    public long getReplyCount(int type) {
        long count = 0;
        try {
            String sql = "SELECT count(*) FROM reply WHERE type = ?";
            ResultSet rs = executeQuery(sql, new Object[]{type});
            if (rs.next()) {
                count = rs.getLong(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    /**
     * 根据id返回reply对象
     * @param id
     * @return
     */
    public Reply getReply(long id) {
        Reply reply = null;
        try {
            String sql = "SELECT * FROM reply WHERE id = ?";
            ResultSet rs = executeQuery(sql, new Object[]{id});
            if (rs.next()) {
                reply = getReply(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reply;
    }

    /**
     * 根据结果集返回Reply对象
     * @param rs
     * @return
     */
    private Reply getReply(ResultSet rs) {
        Reply reply = null;
        try {
            reply = new Reply();
            reply.setId(rs.getLong("id"));
            reply.setPostId(rs.getLong("post_id"));
            reply.setParentId(rs.getLong("parent_id"));
            UserDao userDao = new UserDao();
            if (rs.wasNull()) {
                reply.setParentId(-1);  //直接回复楼主
            }
            reply.setContent(rs.getString("content"));
            reply.setTime(TimeTransform.timeStampToDate(rs.getTimestamp("time")));
            reply.setType(rs.getInt("type"));
            reply.setFloor(rs.getLong("floor"));
            reply.setReplier(userDao.getUser(rs.getInt("replier_id")));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reply;
    }

    /**
     * 根据主题id，获得回复数量
     * @param id
     * @return
     */
    public long getReplyCount(long id) {
        long replies = 0;
        try {
            String sql = "SELECT count(*) FROM reply WHERE post_id = ?";
            ResultSet rs = executeQuery(sql, new Object[]{id});
            if (rs.next()) {
                replies = rs.getLong(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return replies;
    }

    /**
     * 根据结果集返回回复列表
     * @param rs
     * @return
     */
    private List<Reply> getReplyList(ResultSet rs) {
        List<Reply> replyList = new ArrayList<>();
        try {
            while (rs.next()) {
                Reply reply = getReply(rs);
                if (reply.getParentId() != -1) {
                    reply.setParentReply(getReply(reply.getParentId()));
                }
                replyList.add(reply);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return replyList;
    }

    /**
     * 根据主题帖id和页码、大小返回回复列表
     * @param id
     * @param pageNumber
     * @param pageSize
     * @return
     */
    public List<Reply> getReplyList(long id, long pageNumber, int pageSize) {
        String sql = "SELECT * FROM reply WHERE post_id = ? ORDER BY time LIMIT ?, ? ";
        ResultSet rs = executeQuery(sql, new Object[]{id, (pageNumber-1)*pageSize, pageSize});
        return getReplyList(rs);
    }

    /**
     * 向数据库中添加一条回复
     * @param reply
     */
    public void addReply(Reply reply) {
        String sql = null;
        Object[] param = null;
        if (reply.getParentId() == -1) {  //直接回复
            sql = "INSERT INTO reply (post_id, replier_id, content, time, type, floor) values (?, ?, ?, ?, ?, ?)";
            param = new Object[]{reply.getPostId(), reply.getReplier().getId(), reply.getContent(),
            TimeTransform.dateTotimeStamp(reply.getTime()), reply.getType(), reply.getFloor()};
        } else {
            sql = "INSERT INTO reply (post_id, parent_id, replier_id, content, time, type, floor) values (?, ?, ?, ?, ?, ?, ?)";
            param = new Object[]{reply.getPostId(), reply.getParentId(), reply.getReplier().getId(),
            reply.getContent(), TimeTransform.dateTotimeStamp(reply.getTime()), reply.getType(), reply.getFloor()};
        }
        execute(sql, param);
    }

    /**
     * 根据id获得主题帖的最新回复
     * @param id
     * @return
     */
    public Reply getLastReply(long id) {
        try {
            String sql = "SELECT * FROM reply WHERE post_id = ? order by floor desc limit 1";
            ResultSet rs = executeQuery(sql, new Object[]{id});
            if (rs.next()) {
                return getReply(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 根据id删除回复
     * @param id
     */
    public void deleteReply(long id) {
        String sql = "DELETE FROM reply WHERE id = ?";
        execute(sql, new Object[]{id});
    }

    public long getUserReplyCount(int userId) {
        long count = 0;
        try {
            String sql = "SELECT * FROM reply WHERE replier_id = ?";
            ResultSet rs = executeQuery(sql, userId);
            if (rs.next()) {
                count = rs.getLong(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }
}
