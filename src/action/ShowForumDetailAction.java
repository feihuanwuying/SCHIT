package action;

import com.opensymphony.xwork2.ActionSupport;
import service.ForumService;
import vo.Post;

import java.util.List;

/**
 * Created by ZouKaifa on 2016/10/24.
 */
public class ShowForumDetailAction extends ActionSupport {
    private List<Post> postList;  //帖子列表
    private long pageNumber;  //帖子页码
    private long pageCount;  //帖子总页数
    private int type;  //分区类型
    private String title;  //分区标题

    public List<Post> getPostList() {
        return postList;
    }

    public void setPostList(List<Post> postList) {
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

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String execute() throws Exception {
        ForumService forumService = new ForumService();
        title = forumService.getLabel(type);
        if (title == null) {
            return ERROR;  //通过url访问了其它类型
        }
        pageCount = forumService.getPostPageCount(type);
        pageNumber = forumService.getPageNumber(pageNumber);
        postList = forumService.getPostList(type);
        return SUCCESS;
    }
}
