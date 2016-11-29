package action.Forum;

import com.opensymphony.xwork2.ActionSupport;
import service.ForumService;
import vo.Post;
import vo.Reply;

import java.util.List;

/**
 * Created by ZouKaifa on 2016/10/24.
 */
public class ShowPostAction extends ActionSupport {
    private Post post = new Post();  //帖子
    private List<Reply> replyList;  //回复列表
    private long pid;  //帖子id
    private long pageNumber;
    private long pageCount;
    private int pageSize;
    private int only;  //只看楼主

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public List<Reply> getReplyList() {
        return replyList;
    }

    public void setReplyList(List<Reply> replyList) {
        this.replyList = replyList;
    }

    public long getPid() {
        return pid;
    }

    public void setPid(long pid) {
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
        ForumService forumService = new ForumService();
        post = forumService.getPost(pid);
        if (post == null || (only != 0 && only != 1)) {
            return ERROR;
        }
        pageCount = forumService.getReplyPageCount(pid);
        pageNumber = forumService.getPageNumber(pageNumber);
        replyList = forumService.getReplyList(pid);
        pageSize = forumService.getPageSize();
        return SUCCESS;
    }

}
