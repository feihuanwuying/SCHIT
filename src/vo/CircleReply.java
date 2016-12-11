package vo;

import java.util.Date;

/**
 * Created by ZouKaifa on 2016/12/11.
 */
public class CircleReply {
    private long id;
    private long postId;  //帖子id
    private long parentId;  //父贴id，为-1则表示无父贴（直接回复）
    private User replier = new User();  //回帖人
    private String content = "";  //回帖内容
    private Date time;  //回帖时间
    private int circleId;
    private long floor;  //层数
    private CircleReply parentReply = null;  //父贴

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getPostId() {
        return postId;
    }

    public void setPostId(long postId) {
        this.postId = postId;
    }

    public long getParentId() {
        return parentId;
    }

    public void setParentId(long parentId) {
        this.parentId = parentId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public int getCircleId() {
        return circleId;
    }

    public void setCircleId(int circleId) {
        this.circleId = circleId;
    }

    public CircleReply getParentReply() {
        return parentReply;
    }

    public void setParentReply(CircleReply parentReply) {
        this.parentReply = parentReply;
    }

    public long getFloor() {
        return floor;
    }

    public void setFloor(long floor) {
        this.floor = floor;
    }

    public User getReplier() {
        return replier;
    }

    public void setReplier(User replier) {
        this.replier = replier;
        this.replier.setPassword("");
    }
}
