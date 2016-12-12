package action.friend;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import service.FriendService;

/**
 * Created by ZouKaifa on 2016/12/12.
 */
public class SendMessageAction extends ActionSupport{
    private String url;
    private int id;
    private String message;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String execute() throws Exception {
        FriendService friendService = new FriendService();
        url = ServletActionContext.getRequest().getHeader("referer");
        if (! friendService.sendMessage(id, message)) {
            return ERROR;
        }
        return SUCCESS;
    }
}
