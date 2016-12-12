package action.circle;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import service.CircleService;
import vo.CirclePost;
import vo.CircleReply;

import java.util.List;

/**
 * Created by ZouKaifa on 2016/12/12.
 */
public class ShowCirclePostAction extends ActionSupport {
    private CirclePost post = new CirclePost();  //帖子
    private List<CircleReply> replyList;  //回复列表
    private int pid;  //帖子id
    private long pageNumber;
    private long pageCount;
    private int pageSize;
    private int only;  //只看楼主
    private int isOwner;

    public int getIsOwner() {
        return isOwner;
    }

    public void setIsOwner(int isOwner) {
        this.isOwner = isOwner;
    }

    public CirclePost getPost() {
        return post;
    }

    public void setPost(CirclePost post) {
        this.post = post;
    }

    public List<CircleReply> getReplyList() {
        return replyList;
    }

    public void setReplyList(List<CircleReply> replyList) {
        this.replyList = replyList;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
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

    public int getOnly() {
        return only;
    }

    public void setOnly(int only) {
        this.only = only;
    }

    @Override
    public String execute() throws Exception {
        CircleService circleService = new CircleService();
        post = circleService.getCirclePost(pid);
        if (post == null || (only != 0 && only != 1)) {
            return ERROR;
        }
        pageCount = circleService.getReplyPageCount(pid);
        pageNumber = circleService.getPageNumber(pageNumber);
        replyList = circleService.getCircleReplyList(pid);
        pageSize = circleService.getPageSize();
        int userId = (int) ActionContext.getContext().getSession().get("id");
        isOwner = circleService.isOwner(userId, post.getCircleId());
        return SUCCESS;
    }
}
