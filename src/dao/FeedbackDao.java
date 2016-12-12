package dao;

import util.TimeTransform;

import java.util.Date;

/**
 * Created by ZouKaifa on 2016/12/12.
 */
public class FeedbackDao extends Dao {
    public void addFeedback(String ip, String info) {
        String sql = "INSERT INTO feedback (ip, info, time) values(?, ?, ?)";
        execute(sql, ip, info, TimeTransform.dateTotimeStamp(new Date()));
    }
}
