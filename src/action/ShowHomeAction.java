package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import service.ForumService;
import service.FriendService;
import service.InformService;
import service.UserService;
import vo.*;

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
    private long postCount = 0;
    private long replyCount = 0;
    private List<Inform> informList;
    private List<Post> postList;


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

    public List<Inform> getInformList() {
        return informList;
    }

    public void setInformList(List<Inform> informList) {
        this.informList = informList;
    }

    public List<Post> getPostList() {
        return postList;
    }

    public void setPostList(List<Post> postList) {
        this.postList = postList;
    }

    @Override
    public String execute() throws Exception {
        UserService userService = new UserService();
        FriendService friendService = new FriendService();
        ForumService forumService = new ForumService();
        InformService informService = new InformService();
        user = userService.getUser(id);
        if (user == null) {
            return ERROR;
        }
        userService.visitHome(id);
        visitCount = userService.getVisitCount(id);
        visitList = userService.getVisitList(id);
        friendService.getFriendPageCount(id);
        friendService.getPageNumber(0);
        friendList = friendService.getFriendList(id);
        postCount = forumService.getUserPostCount(id);
        replyCount = forumService.getUserReplyCount(id);
        informService.getInformCount(Inform.MESSAGE, id);
        informService.getPageNumber(0);
        informList = informService.getInformList(Inform.MESSAGE, id);
        postList = forumService.getUserPostList(id);
        return SUCCESS;
    }
}
