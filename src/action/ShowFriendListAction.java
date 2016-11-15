package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import service.FriendService;
import service.UserService;
import vo.Friend;
import vo.User;

import java.util.List;

/**
 * Created by ZouKaifa on 2016/11/1.
 */
public class ShowFriendListAction extends ActionSupport {
    private List<Friend> friendList;  //好友列表
    private long friendCount;  //好友数量
    private long pageNumber;
    private long pageCount;
    private int pageSize;
    private int id;
    private User user;

    public List<Friend> getFriendList() {
        return friendList;
    }

    public void setFriendList(List<Friend> friendList) {
        this.friendList = friendList;
    }

    public long getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(long pageNumber) {
        this.pageNumber = pageNumber;
    }

    public long getPageCount() {
        return pageCount;
    }

    public void setPageCount(long pageCount) {
        this.pageCount = pageCount;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getFriendCount() {
        return friendCount;
    }

    public void setFriendCount(long friendCount) {
        this.friendCount = friendCount;
    }

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

    @Override
    public String execute() throws Exception {
        FriendService friendService = new FriendService();
        UserService userService = new UserService();
        user = userService.getUser(id);
        if (user == null) {
            return ERROR;
        }
        friendCount = friendService.getFriendCount(id);
        pageCount = friendService.getFriendPageCount(id);
        pageNumber = friendService.getPageNumber(pageNumber);
        setFriendList(friendService.getFriendList(id));
        pageSize = friendService.getPageSize();
        return SUCCESS;
    }
}
