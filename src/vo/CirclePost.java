package vo;

import java.util.Date;

/**
 * Created by ZouKaifa on 2016/12/11.
 */
public class CirclePost {
    private int id;
    private User poster = new User();  //发帖人
    private String title = "";  //题目
    private String content = "";  //内容
    private int circleId;  //所属圈子
    private Date time;  //发帖时间
    private CircleReply lastReply;  //最后回复
    private long replyCount;  //回复量
    private Date lastReplyTime;  //最后回帖时间

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getCircleId() {
        return circleId;
    }

    public void setCircleId(int circleId) {
        this.circleId = circleId;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public long getReplyCount() {
        return replyCount;
    }

    public void setReplyCount(long replyCount) {
        this.replyCount = replyCount;
    }

    public User getPoster() {
        return poster;
    }

    public void setPoster(User poster) {
        this.poster = poster;
        this.poster.setPassword("");
    }

    public CircleReply getLastReply() {
        return lastReply;
    }

    public void setLastReply(CircleReply lastReply) {
        this.lastReply = lastReply;
    }

    public Date getLastReplyTime() {
        return lastReplyTime;
    }

    public void setLastReplyTime(Date lastReplyTime) {
        this.lastReplyTime = lastReplyTime;
    }
}
