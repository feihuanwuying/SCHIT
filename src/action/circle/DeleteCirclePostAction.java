package action.circle;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import service.CircleService;

/**
 * Created by ZouKaifa on 2016/12/11.
 */
public class DeleteCirclePostAction extends ActionSupport {
    private int id;
    private String url;

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
        CircleService circleService = new CircleService();
        setUrl(ServletActionContext.getRequest().getHeader("referer"));
        if (!circleService.deleteCirclePost(id)) {
            return ERROR;
        }
        return SUCCESS;
    }
}
