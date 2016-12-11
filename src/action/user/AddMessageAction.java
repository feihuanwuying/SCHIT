package action.user;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import service.InformService;

/**
 * Created by ZouKaifa on 2016/11/15.
 */
public class AddMessageAction extends ActionSupport {
    private int userId;
    private String message;
    private String url;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String execute() throws Exception {
        InformService informService = new InformService();
        setUrl(ServletActionContext.getRequest().getHeader("referer"));
        if (! informService.addMessage(userId, message)) {
            return ERROR;
        }
        return SUCCESS;
    }
}
