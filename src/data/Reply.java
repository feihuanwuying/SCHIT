package data;

import java.util.Date;

/**
 * 对应于数据表reply
 * Created by ZouKaifa on 2016/10/10.
 */
public class Reply {
    private long id;
    private long postId;  //帖子id
    private long parentId;  //父贴id，为-1则表示无父贴（直接回复）
    private String replierName;  //回帖人
    private String content;  //回帖内容
    private Date time;  //回帖时间

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

    public String getReplierName() {
        return replierName;
    }

    public void setReplierName(String replierName) {
        this.replierName = replierName;
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
}
