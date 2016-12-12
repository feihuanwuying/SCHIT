package vo;

import java.util.Date;

/**
 * 对应于数据表content
 * Created by ZouKaifa on 2016/10/10.
 */
public class Post {
    private int id;
    private User poster = new User();  //发帖人
    private String title = "";  //题目
    private String content = "";  //内容
    private int type = 0;  //帖子形式（如聊天灌水）
    private Date time;  //发帖时间
    private Reply lastReply;  //最后回复
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

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
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

    public Reply getLastReply() {
        return lastReply;
    }

    public void setLastReply(Reply lastReply) {
        this.lastReply = lastReply;
    }

    public Date getLastReplyTime() {
        return lastReplyTime;
    }

    public void setLastReplyTime(Date lastReplyTime) {
        this.lastReplyTime = lastReplyTime;
    }
}
