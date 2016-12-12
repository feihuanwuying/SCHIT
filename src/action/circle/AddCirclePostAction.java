package action.circle;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;
import service.CircleService;
import vo.CirclePost;

/**
 * Created by ZouKaifa on 2016/12/11.
 */
public class AddCirclePostAction extends ActionSupport implements ModelDriven<CirclePost> {
    private CirclePost post = new CirclePost();
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public CirclePost getPost() {
        return post;
    }

    public void setPost(CirclePost post) {
        this.post = post;
    }

    @Override
    public String execute() throws Exception {
        CircleService circleService = new CircleService();
        setUrl(ServletActionContext.getRequest().getHeader("referer"));
        if (! circleService.addCirclePost(post)) {
            return ERROR;
        }
        return SUCCESS;
    }

    @Override
    public CirclePost getModel() {
        return post;
    }
}
