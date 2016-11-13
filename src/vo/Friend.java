package vo;

/**
 * friend表
 * Created by ZouKaifa on 2016/10/28.
 */
public class Friend {
    private User friend = new User();  //好友
    private String remark = "";  //备注

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
