package action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import service.ForumService;

/**
 * Created by ZouKaifa on 2016/10/27.
 */
public class DeleteReplyAction extends ActionSupport {
    private long id;
    private String url;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
        if (!forumService.deleteReply(id)) {
            return ERROR;
        }
        return SUCCESS;
    }
}
