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
            reply.setReplierName(rs.getString("replier_name"));
            reply.setContent(rs.getString("content"));
            reply.setTime(TimeTransform.timeStampToDate(rs.getTimestamp("time")));
            reply.setType(rs.getInt("type"));

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
                replyList.add(getReply(rs));
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
        String sql = "SELECT * FROM reply WHERE post_id = ? limit ?, ?";
        ResultSet rs = executeQuery(sql, new Object[]{id, (pageNumber-1)*pageSize, pageSize});
        return getReplyList(rs);
    }
}
