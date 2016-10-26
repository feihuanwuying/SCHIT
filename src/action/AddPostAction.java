package action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;
import service.ForumService;
import vo.Post;

/**
 * Created by ZouKaifa on 2016/10/26.
 */
public class AddPostAction extends ActionSupport implements ModelDriven<Post> {
    private Post post = new Post();
    private String url;

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String execute() throws Exception {
        ForumService forumService = new ForumService();
        setUrl(ServletActionContext.getRequest().getHeader("referer"));
        if (! forumService.addPost(post)) {
            return ERROR;
        }
        return SUCCESS;
    }

    @Override
    public Post getModel() {
        return post;
    }
}
