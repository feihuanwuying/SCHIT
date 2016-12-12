package action.circle;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import service.CircleService;
import service.FriendService;
import vo.Circle;
import vo.Friend;

import java.util.List;

/**
 * Created by ZouKaifa on 2016/12/11.
 */
public class ShowCircleAction extends ActionSupport {
    private List<Friend> friendList;
    private List<Circle> circleList;
    private long pageCount;
    private long pageNumber;

    public List<Friend> getFriendList() {
        return friendList;
    }

    public void setFriendList(List<Friend> friendList) {
        this.friendList = friendList;
    }

    public List<Circle> getCircleList() {
        return circleList;
    }

    public void setCircleList(List<Circle> circleList) {
        this.circleList = circleList;
    }

    public long getPageCount() {
        return pageCount;
    }

    public void setPageCount(long pageCount) {
        this.pageCount = pageCount;
    }

    public long getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(long pageNumber) {
        this.pageNumber = pageNumber;
    }

    @Override
    public String execute() throws Exception {
        FriendService friendService = new FriendService();
        CircleService circleService = new CircleService();
        int userId = (int) ActionContext.getContext().getSession().get("id");
        friendList = friendService.getAllFriendList(userId);
        pageCount = circleService.getCirclePageCount(userId);
        pageNumber = circleService.getPageNumber(pageNumber);
        circleList = circleService.getCircleList(userId);
        return SUCCESS;
    }
}
