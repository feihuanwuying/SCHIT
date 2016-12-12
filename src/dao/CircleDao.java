package dao;

import util.TimeTransform;
import vo.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ZouKaifa on 2016/12/10.
 */
public class CircleDao extends Dao {
    public long getPostCount(int circleId) {
        long count = 0;
        try {
            String sql = "SELECT count(*) FROM circle_post WHERE circle_id = ?";
            ResultSet rs = executeQuery(sql, circleId);
            if (rs.next()) {
                count = rs.getLong(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    public long getReplyCount(int circleId) {
        long count = 0;
        try {
            String sql = "SELECT count(*) FROM circle_reply WHERE circle_id = ?";
            ResultSet rs = executeQuery(sql, circleId);
            if (rs.next()) {
                count = rs.getLong(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    public long getPostReplyCount(int postId) {
        long count = 0;
        try {
            String sql = "SELECT count(*) FROM circle_reply WHERE post_id = ?";
            ResultSet rs = executeQuery(sql, postId);
            if (rs.next()) {
                count = rs.getLong(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    public long getMemberCount(int circleId) {
        long count = 0;
        try {
            String sql = "SELECT count(*) FROM circle_member WHERE circle_id = ?";
            ResultSet rs = executeQuery(sql, circleId);
            if (rs.next()) {
                count = rs.getLong(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    private Circle getCircle(ResultSet rs) {
        Circle circle = null;
        try {
            circle = new Circle();
            UserDao userDao = new UserDao();
            circle.setId(rs.getInt("id"));
            circle.setName(rs.getString("name"));
            circle.setLabel(rs.getString("label"));
            circle.setOwner(userDao.getUser(rs.getInt("owner_id")));
            circle.setPostCount(getPostCount(circle.getId()));
            circle.setReplyCount(getReplyCount(circle.getId()));
            circle.setMembers(getMemberCount(circle.getId()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return circle;
    }

    private List<Circle> getCircleList(ResultSet rs) {
        List<Circle> circleList = new ArrayList<>();
        try {
            while (rs.next()) {
                circleList.add(new Circle());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return circleList;
    }

    /**
     * 为circleList添加通知数
     * @param circleList
     */
    private void addInformCount(List<Circle> circleList, int memberId) {
        try {
            for (int i = 0; i < circleList.size(); i++) {
                Circle circle = circleList.get(i);
                String sql = "SELECT inform FROM circle_member WHERE (circle_id = ?) AND (member_id = ?)";
                ResultSet rs = executeQuery(sql, circle.getId(), memberId);
                if (rs.next()) {
                    circle.setInform(rs.getLong(1));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Circle> getCircleList(int userId, long pageNumber, int pageSize) {
        List<Circle> circleList = new ArrayList<>();
        try {
            String sql = "SELECT circle_id FROM circle_member WHERE member_id = ? LIMIT ?, ?";
            ResultSet rs = executeQuery(sql, userId, (pageNumber - 1) * pageSize, pageSize);
            while (rs.next()) {
                circleList.add(getCircle(rs.getInt(1)));
            }
            addInformCount(circleList, userId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return circleList;
    }

    public Circle getCircle(int circleId) {
        Circle circle = null;
        try {
            String sql = "SELECT * FROM circle WHERE id = ?";
            ResultSet rs = executeQuery(sql, circleId);
            if (rs.next()) {
                circle = getCircle(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return circle;
    }

    public long getCircleCount(int userId) {
        long count = 0;
        try {
            String sql = "SELECT count(*) FROM circle_member WHERE member_id = ?";
            ResultSet rs = executeQuery(sql, userId);
            if (rs.next()) {
                count = rs.getLong(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    public int addCircle(Circle circle, int[] userList) {
        int id = 0;
        try {
            String sql = "INSERT INTO circle (name, label, owner_id) values (?, ?, ?)";
            execute(sql, circle.getName(), circle.getLabel(), circle.getOwner().getId());
            sql = "SELECT LAST_INSERT_ID()";
            ResultSet rs = executeQuery(sql);
            if (rs.next()) {
                id = rs.getInt(1);
            }
            sql = "INSERT INTO circle_member (circle_id, member_id) VALUES(?, ?)";
            execute(sql, id, circle.getOwner().getId());
            for (int i = 0; i < userList.length; i++) {
                sql = "INSERT INTO circle_member (circle_id, member_id) VALUES(?, ?)";
                execute(sql, id, userList[i]);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

    public List<Circle> getRandomCircleList(int number) {
        //// TODO: 2016/12/11
        return null;
    }

    private CirclePost getCirclePost(ResultSet rs) {
        CirclePost post = null;
        try {
            post = new CirclePost();
            post.setId(rs.getInt("id"));
            post.setTitle(rs.getString("title"));
            post.setContent(rs.getString("content"));
            if (post.getContent() == null) {
                post.setContent("");
            }
            post.setCircleId(rs.getInt("circle_id"));
            post.setTime(TimeTransform.timeStampToDate(rs.getTimestamp("time")));
            post.setReplyCount(getPostReplyCount(post.getId()));
            UserDao userDao = new UserDao();
            post.setPoster(userDao.getUser(rs.getInt("poster_id")));
            post.setLastReply(getLastCircleReply(post.getId()));
            post.setLastReplyTime(TimeTransform.timeStampToDate(rs.getTimestamp("reply_time")));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return post;
    }

    public CirclePost getCirclePost(long id) {
        CirclePost post = null;
        try {
            String sql = "SELECT * FROM circle_post WHERE id = ?";
            ResultSet rs = executeQuery(sql, new Object[]{id});
            if (rs.next()) {
                post = getCirclePost(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return post;
    }

    private List<CirclePost> getCirclePostList(ResultSet rs) {
        List<CirclePost> postList = null;
        try {
            postList = new ArrayList<>();
            while (rs.next()) {
                postList.add(getCirclePost(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return postList;
    }

    public List<CirclePost> getCirclePostList(int circleId, long pageNumber, int pageSize) {
        List<CirclePost> postList = null;
        String sql = "SELECT * FROM circle_post WHERE circle_id = ? ORDER BY reply_time DESC LIMIT ?, ?";
        ResultSet rs = executeQuery(sql, circleId, (pageNumber-1)*pageSize, pageSize);
        postList = getCirclePostList(rs);
        return postList;
    }

    public void updateCirclePost(CirclePost post) {
        String sql = "UPDATE circle_post SET title = ?, content = ?, reply_time = ? WHERE id = ?";
        executeUpdate(sql, post.getTitle(), post.getContent(),
                TimeTransform.dateTotimeStamp(post.getLastReplyTime()), post.getId());
    }

    public void addCirclePost(CirclePost post) {
        String sql = "INSERT INTO circle_post (id, poster_id, title, content, circle_id, time, reply_time) values (?, ?, ?, ?, ?, ?, ?)";
        execute(sql, post.getId(), post.getPoster().getId(),
                post.getTitle(), post.getContent(), post.getCircleId(),
                TimeTransform.dateTotimeStamp(post.getTime()),
                TimeTransform.dateTotimeStamp(post.getLastReplyTime()));
        try {
            sql = "SELECT * FROM circle_member WHERE circle_id = ?";
            ResultSet rs = executeQuery(sql, post.getCircleId());
            while (rs.next()) {
                int inform = rs.getInt("inform")+1;
                int memberId = rs.getInt("member_id");
                sql = "UPDATE circle_member SET inform = ? WHERE (circle_id = ?) AND (member_id = ?)";
                if (memberId != post.getPoster().getId()) {
                    executeUpdate(sql, inform, post.getCircleId(), memberId);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletePost(long id) {
        String sql = "DELETE FROM circle_post WHERE id = ?";
        execute(sql, id);
    }


    private CircleReply getCircleReply(ResultSet rs) {
        CircleReply reply = null;
        try {
            reply = new CircleReply();
            reply.setId(rs.getLong("id"));
            reply.setPostId(rs.getLong("post_id"));
            reply.setParentId(rs.getLong("parent_id"));
            UserDao userDao = new UserDao();
            if (rs.wasNull()) {
                reply.setParentId(-1);  //直接回复楼主
            }
            reply.setContent(rs.getString("content"));
            reply.setTime(TimeTransform.timeStampToDate(rs.getTimestamp("time")));
            reply.setCircleId(rs.getInt("circle_id"));
            reply.setFloor(rs.getLong("floor"));
            reply.setReplier(userDao.getUser(rs.getInt("replier_id")));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reply;
    }

    public CircleReply getCircleReply(long id) {
        CircleReply reply = null;
        try {
            String sql = "SELECT * FROM circle_reply WHERE id = ?";
            ResultSet rs = executeQuery(sql, id);
            if (rs.next()) {
                reply = getCircleReply(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reply;
    }

    private List<CircleReply> getCircleReplyList(ResultSet rs) {
        List<CircleReply> replyList = new ArrayList<>();
        try {
            while (rs.next()) {
                CircleReply reply = getCircleReply(rs);
                if (reply.getParentId() != -1) {
                    reply.setParentReply(getCircleReply(reply.getParentId()));
                }
                replyList.add(reply);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return replyList;
    }

    public List<CircleReply> getCircleReplyList(long id, long pageNumber, int pageSize) {
        String sql = "SELECT * FROM circle_reply WHERE post_id = ? ORDER BY time LIMIT ?, ? ";
        ResultSet rs = executeQuery(sql, id, (pageNumber-1)*pageSize, pageSize);
        return getCircleReplyList(rs);
    }

    public void addCircleReply(CircleReply reply) {
        String sql = null;
        Object[] param = null;
        if (reply.getParentId() == -1) {  //直接回复
            sql = "INSERT INTO circle_reply (post_id, replier_id, content, time, circle_id, floor) values (?, ?, ?, ?, ?, ?)";
            param = new Object[]{reply.getPostId(), reply.getReplier().getId(), reply.getContent(),
                    TimeTransform.dateTotimeStamp(reply.getTime()), reply.getCircleId(), reply.getFloor()};
        } else {
            sql = "INSERT INTO circle_reply (post_id, parent_id, replier_id, content, time, circle_id, floor) values (?, ?, ?, ?, ?, ?, ?)";
            param = new Object[]{reply.getPostId(), reply.getParentId(), reply.getReplier().getId(),
                    reply.getContent(), TimeTransform.dateTotimeStamp(reply.getTime()), reply.getCircleId(), reply.getFloor()};
        }
        execute(sql, param);
        try {
            sql = "SELECT * FROM circle_member WHERE circle_id = ?";
            ResultSet rs = executeQuery(sql, reply.getCircleId());
            while (rs.next()) {
                int inform = rs.getInt("inform")+1;
                int memberId = rs.getInt("member_id");
                if (memberId != reply.getReplier().getId()) {
                    sql = "UPDATE circle_member SET inform = ? WHERE (circle_id = ?) AND (member_id = ?)";
                    executeUpdate(sql, inform, reply.getCircleId(), memberId);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public CircleReply getLastCircleReply(long id) {
        try {
            String sql = "SELECT * FROM circle_reply WHERE post_id = ? order by floor desc limit 1";
            ResultSet rs = executeQuery(sql, id);
            if (rs.next()) {
                return getCircleReply(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void deleteCircleReply(long id) {
        String sql = "DELETE FROM circle_reply WHERE id = ?";
        execute(sql, id);
    }

    public boolean isOwner(int userId, int circleId) {
        boolean is = false;
        try {
            String sql = "SELECT * FROM circle WHERE (owner_id = ?) AND (id = ?)";
            ResultSet rs = executeQuery(sql, userId, circleId);
            if (rs.next()) {
                is = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return is;
    }

    public boolean isMember(int memberId, int circleId) {
        boolean is = false;
        try {
            String sql = "SELECT * FROM circle_member WHERE (member_id = ?) AND (circle_id = ?)";
            ResultSet rs = executeQuery(sql, memberId, circleId);
            if (rs.next()) {
                is = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return is;
    }

    public int getInformCount(int userId, int circleId) {
        int count = 0;
        try {
            String sql = "SELECT inform FROM circle_member WHERE (member_id = ?) AND (circle_id = ?)";
            ResultSet rs = executeQuery(sql, userId, circleId);
            if (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    public int getInformCount(int userId) {
        int count = 0;
        try {
            String sql = "SELECT inform FROM circle_member WHERE member_id = ?";
            ResultSet rs = executeQuery(sql, userId);
            while (rs.next()) {
                count += rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    public void viewCircle(int userId, int circleId) {
        String sql = "UPDATE circle_member SET inform = 0 WHERE (member_id = ?) AND (circle_id = ?)";
        executeUpdate(sql, userId, circleId);
    }
}
