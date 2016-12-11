package dao;

import vo.Circle;
import vo.User;

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

    public long getReplyCount(int circleId, int postId) {
        long count = 0;
        try {
            String sql = "SELECT count(*) FROM circle_reply WHERE (circle_id = ?) AND (post_id = ?)";
            ResultSet rs = executeQuery(sql, circleId, postId);
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

    public void addCircle(Circle circle, int[] userList) {
        try {
            String sql = "INSERT INTO circle (name, label, owner_id) values (?, ?, ?)";
            execute(sql, circle.getName(), circle.getLabel(), circle.getOwner().getId());
            sql = "SELECT LAST_INSERT_ID()";
            ResultSet rs = executeQuery(sql);
            int id = 0;
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
    }

    public List<Circle> getRandomCircleList(int number) {
        //// TODO: 2016/12/11
        return null;
    }

}
