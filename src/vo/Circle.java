package vo;

/**
 * Created by ZouKaifa on 2016/12/10.
 */
public class Circle {
    private int id;
    private String name = "";  //圈子名称
    private String label = "";  //圈子标签
    private User owner;  //圈子拥有者
    private long postCount;  //帖子总数
    private long replyCount;  //回复总数
    private long inform;  //新信息数
    private long members;
    public static String[] labelList = {"学习", "交友", "班级", "运动",
    "电竞", "情感", "兼职"};

    public long getMembers() {
        return members;
    }

    public void setMembers(long members) {
        this.members = members;
    }

    public long getInform() {
        return inform;
    }

    public void setInform(long inform) {
        this.inform = inform;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public long getPostCount() {
        return postCount;
    }

    public void setPostCount(long postCount) {
        this.postCount = postCount;
    }

    public long getReplyCount() {
        return replyCount;
    }

    public void setReplyCount(long replyCount) {
        this.replyCount = replyCount;
    }
}
