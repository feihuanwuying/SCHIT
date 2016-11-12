package dao;

import util.TimeTransform;
import vo.Visit;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ZouKaifa on 2016/11/12.
 */
public class VisitDao extends Dao {
    private Visit getVisit(ResultSet rs) {
        Visit visit = null;
        try {
            UserDao userDao = new UserDao();
            visit.setUser(userDao.getUser(rs.getInt("user_id")));
            visit.setVisitor(userDao.getUser(rs.getInt("visitor_id")));
            visit.setTime(TimeTransform.timeStampToDate(rs.getTimestamp("time")));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return visit;
    }

    private List<Visit> getVisitList(ResultSet rs) {
        List<Visit> visitList = new ArrayList<>();
        try {
            while (rs.next()) {
                visitList.add(getVisit(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return visitList;
    }

    public Visit getVisit(int userId, int visitorId) {
        Visit visit = null;
        try {
            String sql = "SELECT * FROM visit WHERE (user_id = ?) and (visitor_id = ?)";
            ResultSet rs = executeQuery(sql, new Object[]{userId, visitorId});
            if (rs.next()) {
                visit = getVisit(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return visit;
    }

    public List<Visit> getVisitList(int userId) {
        String sql = "SELECT * FROM visit WHERE (user_id = ?) ORDER BY time DESC";
        ResultSet rs = executeQuery(sql, new Object[]{userId});
        return getVisitList(rs);
    }

    public void addVisit(Visit visit) {
        String sql = "INSERT INTO visit (user_id, visitor_id, time) values(?, ?, ?)";
        Object[] params = {visit.getUser().getId(),
            visit.getVisitor().getId(),
                TimeTransform.dateTotimeStamp(visit.getTime())};
        execute(sql, params);
    }

    public void updateVisit(Visit visit) {
        String sql = "UPDATE visit SET time = ? WHERE (user_id = ?) and (visitor_id = ?)";
        Object[] params = {TimeTransform.dateTotimeStamp(visit.getTime()),
                visit.getUser().getId(), visit.getVisitor().getId()};
        executeUpdate(sql, params);
    }

}
