package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import service.FriendService;
import service.UserService;
import vo.Friend;
import vo.User;
import vo.Visit;

import java.util.List;

/**
 * Created by ZouKaifa on 2016/11/12.
 */
public class ShowHomeAction extends ActionSupport{
    private User user = new User();
    private int id = -1;
    private long visitCount = 0;
    private List<Visit> visitList;
    private List<Friend> friendList;


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getVisitCount() {
        return visitCount;
    }

    public void setVisitCount(long visitCount) {
        this.visitCount = visitCount;
    }

    public List<Visit> getVisitList() {
        return visitList;
    }

    public void setVisitList(List<Visit> visitList) {
        this.visitList = visitList;
    }

    public List<Friend> getFriendList() {
        return friendList;
    }

    public void setFriendList(List<Friend> friendList) {
        this.friendList = friendList;
    }

    @Override
    public String execute() throws Exception {
        UserService userService = new UserService();
        FriendService friendService = new FriendService();
        user = userService.getUser(id);
        if (user == null) {
            return ERROR;
        }
        userService.visitHome(id);
        visitCount = userService.getVisitCount(id);
        visitList = userService.getVisitList(id);
        return SUCCESS;
    }
}
