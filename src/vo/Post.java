package vo;

import java.util.Date;

/**
 * 对应于数据表content
 * Created by ZouKaifa on 2016/10/10.
 */
public class Post {
    private long id;
    private String posterName;  //发帖人
    private String title;  //题目
    private String content;  //内容
    private int type;  //帖子形式（如聊天灌水）
    private Date time;  //发帖时间
    private String replyName;  //最后回复人
    private Date replyTime;  //最后回复时间

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPosterName() {
        return posterName;
    }

    public void setPosterName(String posterName) {
        this.posterName = posterName;
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

    public String getReplyName() {
        return replyName;
    }

    public void setReplyName(String replyName) {
        this.replyName = replyName;
    }

    public Date getReplyTime() {
        return replyTime;
    }

    public void setReplyTime(Date replyTime) {
        this.replyTime = replyTime;
    }
}
