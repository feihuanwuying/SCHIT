package vo;

/**
 * friend表
 * Created by ZouKaifa on 2016/10/28.
 */
public class Friend {
    private User user = new User();  //用户
    private User friend = new User();  //好友
    private String remark = "";  //备注

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getFriend() {
        return friend;
    }

    public void setFriend(User friend) {
        this.friend = friend;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
