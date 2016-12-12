package action.friend;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import service.FriendService;

/**
 * Created by ZouKaifa on 2016/11/15.
 */
public class DeleteFriendAction extends ActionSupport {
    private String url;
    private int friendId;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getFriendId() {
        return friendId;
    }

    public void setFriendId(int friendId) {
        this.friendId = friendId;
    }

    @Override
    public String execute() throws Exception {
        FriendService friendService = new FriendService();
        setUrl(ServletActionContext.getRequest().getHeader("referer"));
        int userId = (int) ActionContext.getContext().getSession().get("id");
        if (! friendService.deleteFriend(userId, friendId)) {
            return ERROR;
        }
        return SUCCESS;
    }
}
