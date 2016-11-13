package vo;

import java.util.Date;

/**
 * visit表
 * Created by ZouKaifa on 2016/11/12.
 */
public class Visit {
    private User user;  //被访问者
    private User visitor;  //访问者
    private Date time;  //访问时间

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getVisitor() {
        return visitor;
    }

    public void setVisitor(User visitor) {
        this.visitor = visitor;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
