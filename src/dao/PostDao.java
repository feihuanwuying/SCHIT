package dao;

import util.TimeTransform;
import vo.Post;
import vo.Reply;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
            String sql = "SELECT count(*) FROM post WHERE type = ?";
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
     * 根据id获得一个post对象
     * @param id
     * @return
     */
    public Post getPost(long id) {
        Post post = null;
        try {
            String sql = "SELECT * FROM post WHERE id = ?";
            ResultSet rs = executeQuery(sql, new Object[]{id});
            if (rs.next()) {
                post = getPost(rs);
            }
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
            ReplyDao replyDao = new ReplyDao();
            post.setReplyCount(replyDao.getReplyCount(post.getId()));
            post.setReplyTime(TimeTransform.timeStampToDate(rs.getTimestamp("reply_time")));
            post.setReplyName(rs.getString("reply_name"));
            UserDao userDao = new UserDao();
            post.setReplyNickName(userDao.getUser(post.getReplyName()).getNickname());
            post.setPosterNickName(userDao.getUser(post.getPosterName()).getNickname());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return post;
    }

    /**
     * 根据结果集返回一个post列表
     * @param rs
     * @return
     */
    private List<Post> getPostList(ResultSet rs) {
        List<Post> postList = null;
        try {
            postList = new ArrayList<>();
            while (rs.next()) {
                postList.add(getPost(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return postList;
    }

    /**
     * 根据分区、页码、页面帖子数量返回post列表
     * @param type
     * @param pageNumber
     * @param pageSize
     * @return
     */
    public List<Post> getPostList(int type, long pageNumber, int pageSize) {
        List<Post> postList = null;
        String sql = "SELECT * FROM post WHERE type = ? ORDER BY reply_time DESC LIMIT ?, ?";
        ResultSet rs = executeQuery(sql, new Object[]{type, (pageNumber-1)*pageSize, pageSize});
        postList = getPostList(rs);
        return postList;
    }


}