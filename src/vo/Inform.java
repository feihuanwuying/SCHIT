package vo;

import java.util.Date;

/**
 * inform表
 * Created by ZouKaifa on 2016/11/1.
 */
public class Inform {
    public final static int ADD_FRIEND = 1;  //添加好友
    public final static int FRIEND_CHAT = 2;  //好友聊天
    public final static int ADD_SUCCESS = 3;  //好友请求通过
    public final static int POST_REPLY = 4;  //主题被回复
    public final static int MESSAGE = 6;  //留言
    public final static int ADD_FAIL = 7;  //好友请求被拒绝
    public final static int INTO_CIRCLE = 8;  //被拉入圈子
    private int id;
    private User user;  //用户
    private int informType = 0;  //通知类型
    private int informId = 0;  //通知的id，即对应其它表的id
    private Friend friend;  //好友或参与事件的另一用户
    private String friendMessage = "";  //好友私信或申请信息
    private Date time;  //事件发生的时间
    private int treatment;  //处理方式（0未查看,1已经查看，2同意，3拒绝）

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getInformType() {
        return informType;
    }

    public void setInformType(int informType) {
        this.informType = informType;
    }

    public int getInformId() {
        return informId;
    }

    public void setInformId(int informId) {
        this.informId = informId;
    }

    public Friend getFriend() {
        return friend;
    }

    public void setFriend(Friend friend) {
        this.friend = friend;
    }

    public String getFriendMessage() {
        return friendMessage;
    }

    public void setFriendMessage(String friendMessage) {
        this.friendMessage = friendMessage;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public int getTreatment() {
        return treatment;
    }

    public void setTreatment(int treatment) {
        this.treatment = treatment;
    }
}
