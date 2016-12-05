package action.User;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import service.UserService;

/**
 * Created by ZouKaifa on 2016/10/23.
 */
public class LogoutAction extends ActionSupport {
    private String username;
    private String url;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String execute() throws Exception {
        UserService userService = new UserService();
        userService.logout();
        setUrl(ServletActionContext.getRequest().getHeader("referer"));
        return SUCCESS;
    }
}
