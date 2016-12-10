package action.Friend;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import service.FriendService;

/**
 * Created by ZouKaifa on 2016/12/10.
 */
public class DenyFriendAction extends ActionSupport{
    private String url;
    private String message;
    private int informId;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getInformId() {
        return informId;
    }

    public void setInformId(int informId) {
        this.informId = informId;
    }

    @Override
    public String execute() throws Exception {
        FriendService friendService = new FriendService();
        setUrl(ServletActionContext.getRequest().getHeader("referer"));
        if (! friendService.denyFriend(informId, message)) {
            return ERROR;
        }
        return SUCCESS;
    }
}
