package action;

import com.opensymphony.xwork2.ActionContext;
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
    private long friendCount;  //好友数量
    private long pageNumber;
    private long pageCount;
    private int pageSize;

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

    @Override
    public String execute() throws Exception {
        FriendService friendService = new FriendService();
        String username = (String)ActionContext.getContext().getSession().get("username");
        friendCount = friendService.getFriendCount(username);
        pageCount = friendService.getFriendPageCount(username);
        pageNumber = friendService.getPageNumber(pageNumber);
        setFriendList(friendService.getFriendList(username));
        pageSize = friendService.getPageSize();
        return SUCCESS;
    }
}
