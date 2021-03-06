package util;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间转换方法
 * Created by ZouKaifa on 2016/10/24.
 */
public class TimeTransform {
    /**
     * 时间戳转换成date
     * @param timestamp
     * @return
     */
    public static Date timeStampToDate(Timestamp timestamp) {
        Date date = timestamp;
        return date;
    }

    /**
     * date转为timestamp
     * @param date
     * @return
     */
    public static Timestamp dateTotimeStamp(Date date) {
        Timestamp times = new Timestamp(date.getTime());
        return times;
    }
}
