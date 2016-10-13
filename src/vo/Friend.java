package vo;

/**
 * 对应于数据表friend
 * Created by ZouKaifa on 2016/10/10.
 */
public class Friend {
    private long id;
    private String username;  //用户名
    private String remark;  //备注
    private User friend;  //好友

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public User getFriend() {
        return friend;
    }

    public void setFriend(User friend) {
        this.friend = friend;
    }
}
