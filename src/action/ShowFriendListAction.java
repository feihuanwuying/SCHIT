package action;

import com.opensymphony.xwork2.ActionSupport;
import service.FriendService;
import vo.Friend;
import vo.User;

import java.util.List;

/**
 * Created by ZouKaifa on 2016/11/1.
 */
public class ShowFriendListAction extends ActionSupport {
    private List<Friend> friendList;  //好友列表
    private String username;  //用户名

    public List<Friend> getFriendList() {
        return friendList;
    }

    public void setFriendList(List<Friend> friendList) {
        this.friendList = friendList;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String execute() throws Exception {
        FriendService friendService = new FriendService();
        setFriendList(friendService.getFriendList(username));
        return SUCCESS;
    }
}
