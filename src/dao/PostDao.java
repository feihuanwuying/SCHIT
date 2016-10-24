package dao;

import util.TimeTransform;
import vo.Post;
import vo.Reply;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 用数据库交互获取reply表的信息
 * Created by ZouKaifa on 2016/10/24.
 */
public class PostDao extends Dao {
    /**
     * 获得某个分区的帖子总数
     * @param type 分区类型
     * @return 帖子总数
     */
    public long getPostCount(int type) {
        long count = 0;
        try {
            setCon();
            String sql = "SELECT count(*) FROM post WHERE type = ?";
            ResultSet rs = executeQuery(sql, new Object[]{type});
            if (rs.next()) {
                count = rs.getLong(1);
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    /**
     * 根据id获得一个post对象
     * @param id
     * @return
     */
    public Post getPost(long id) {
        Post post = null;
        try {
            setCon();
            String sql = "SELECT * FROM post WHERE id = ?";
            ResultSet rs = executeQuery(sql, new Object[]{id});
            if (rs.next()) {
                post = getPost(rs);
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return post;
    }

    /**
     * 根据数据集对象产生一个Post对象
     * @param rs
     * @return
     */
    private Post getPost(ResultSet rs) {
        Post post = null;
        try {
            post = new Post();
            post.setId(rs.getLong("id"));
            post.setPosterName(rs.getString("poster_name"));
            post.setTitle(rs.getString("title"));
            post.setContent(rs.getString("content"));
            post.setType(rs.getInt("type"));
            post.setTime(TimeTransform.timeStampToDate(rs.getTimestamp("time")));
            long replyId = rs.getLong("last_reply");
            if (rs.wasNull()) {
                post.setReplyName("");
                post.setReplyTime(post.getTime());  //无人回复，则回复时间与创建时间相同
            } else {
                ReplyDao replyDao = new ReplyDao();
                Reply reply = replyDao.getReply(replyId);
                post.setReplyTime(reply.getTime());
                post.setReplyName(reply.getReplierName());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return post;
    }

}
