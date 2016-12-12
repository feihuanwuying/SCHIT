package action.circle;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import service.CircleService;
import vo.Circle;
import vo.CirclePost;

import java.util.List;

/**
 * Created by ZouKaifa on 2016/12/11.
 */
public class ShowCircleDetailAction extends ActionSupport {
    private List<CirclePost> postList;  //帖子列表
    private long pageNumber;  //帖子页码
    private long pageCount;  //帖子总页数
    private int circleId;
    private Circle circle;
    private int isOwner;

    public int getIsOwner() {
        return isOwner;
    }

    public void setIsOwner(int isOwner) {
        this.isOwner = isOwner;
    }

    public int getCircleId() {
        return circleId;
    }

    public void setCircleId(int circleId) {
        this.circleId = circleId;
    }

    public List<CirclePost> getPostList() {
        return postList;
    }

    public void setPostList(List<CirclePost> postList) {
        this.postList = postList;
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

    public Circle getCircle() {
        return circle;
    }

    public void setCircle(Circle circle) {
        this.circle = circle;
    }

    @Override
    public String execute() throws Exception {
        CircleService circleService = new CircleService();
        pageCount = circleService.getCirclePostPageCount(circleId);
        pageNumber = circleService.getPageNumber(pageNumber);
        postList = circleService.getCirclePostList(circleId);
        circle = circleService.getCircle(circleId);
        int userId = (int) ActionContext.getContext().getSession().get("id");
        isOwner = circleService.isOwner(userId, circleId);
        return SUCCESS;
    }
}
