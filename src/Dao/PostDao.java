package Dao;

import Data.Post;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 与数据库交互，获取post表的信息
 * Created by ZouKaifa on 2016/10/10.
 */
public class PostDao {
    private Connection con;

    /**
     * 根据帖子id获得一个post对象
     *
     * @param id 帖子的id
     * @return post对象，不存在则为null
     */
    public Post getPost(long id) {
        try {
            Statement sta = con.createStatement();
            ResultSet rs = sta.executeQuery("SELECT * FROM post WHERE id = " + id);
            if (rs.next()) {
                Post post = getPost(rs);
                con.close();
                return post;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 根据结果集获得一个post对象
     *
     * @param rs 结果集对象
     * @return post对象
     */
    private Post getPost(ResultSet rs) {
        Post post = new Post();
        try {
            post.setId(rs.getLong(1));
            post.setPosterName(rs.getString(2));
            post.setTitle(rs.getString(3));
            post.setContent(rs.getString(4));
            post.setType(rs.getInt(5));
            post.setTime(rs.getDate(6));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
